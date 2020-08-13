package com.popularlibrary.viewingphotos.recycler.presenter;

import android.util.Log;

import com.popularlibrary.viewingphotos.recycler.app.App;
import com.popularlibrary.viewingphotos.recycler.model.Model;
import com.popularlibrary.viewingphotos.recycler.model.entity.Hit;
import com.popularlibrary.viewingphotos.recycler.model.entity.Photo;
import com.popularlibrary.viewingphotos.recycler.model.retrofit.IApiHelper;
import com.popularlibrary.viewingphotos.recycler.model.room.Image;
import com.popularlibrary.viewingphotos.recycler.model.room.ImgDao;
import com.popularlibrary.viewingphotos.recycler.view.IViewHolder;
import com.popularlibrary.viewingphotos.recycler.view.MainView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private static final String TAG = "MainPresenter";
    private RecyclerMain recyclerMain;
    private List<Hit> hitList;
    private ImgDao imgDao;
    private List<Image> imageList;

    @Inject
    IApiHelper apiHelper;

    @Inject
    Model model;

    public MainPresenter() {
        recyclerMain = new RecyclerMain();
        imgDao = App.getAppDatabase().imgDao();
    }

    public void setOnItemClickListener(int position) {

        model.setData(position);
        int count = model.getCount();
        getViewState().showCount(count);
    }

    @Override
    protected void onFirstViewAttach() {
        App.getAppComponent().inject(this);
        getAllPhoto();
    }

    private void getAllPhoto() {

        getDataFromDB();
        if (imageList == null) {
            Observable<Photo> single = apiHelper.requestServer();

            Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(photos -> {

                hitList = photos.hits;
                putListData();
                getViewState().updateRecyclerView();

            }, throwable -> {
                Log.e(TAG, "onError " + throwable);
            });

        }
    }

    private void putListData() {
        for (int i = 0; i < hitList.size(); i++) {
            Image image = new Image(hitList.get(i));
            Disposable disposable = imgDao.insert(image).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(id -> {
                        Log.d(TAG, "putData: " + id);
                    }, throwable -> {
                        Log.d(TAG, "putData: " + throwable);
                    });

            Log.d("HIT: " + i, String.valueOf(hitList.get(i).webformatURL));
        }

    }

    private void getDataFromDB() {

        Disposable disposable = imgDao.getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(photos -> {
                    Log.d("SIZE ", photos.size() + "");
                    for (int i = 0; i < photos.size(); i++) {
                        Log.d("SIZE ", photos.get(i).getURL() + "");
                    }
                    imageList = photos;
                    getViewState().updateRecyclerView();
                }, throwable -> {
                    Log.d(TAG, "getData: " + throwable);
                });
    }

    private class RecyclerMain implements I2RecyclerMain {

        @Override
        public void bindView(IViewHolder iViewHolder) {
            if (imageList.size() != 0) {
                Log.d("LIST", imageList + "");
                iViewHolder.setImage(imageList.get(iViewHolder.getPos()).getURL());
            } else {
                iViewHolder.setImage(hitList.get(iViewHolder.getPos()).webformatURL);
            }
        }

        @Override
        public int getItemCount() {
            if (hitList != null) {
                return hitList.size();
            }
            if (imageList != null) {
                return imageList.size();
            }
            return 0;
        }
    }

    public RecyclerMain getRecyclerMain() {
        return recyclerMain;
    }
}
