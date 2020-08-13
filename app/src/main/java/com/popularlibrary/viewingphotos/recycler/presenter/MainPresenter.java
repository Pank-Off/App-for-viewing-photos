package com.popularlibrary.viewingphotos.recycler.presenter;

import android.util.Log;


import com.popularlibrary.viewingphotos.recycler.app.App;
import com.popularlibrary.viewingphotos.recycler.model.Model;
import com.popularlibrary.viewingphotos.recycler.model.entity.Hit;
import com.popularlibrary.viewingphotos.recycler.model.entity.Photo;
import com.popularlibrary.viewingphotos.recycler.model.retrofit.IApiHelper;
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
    private Model model;
    private RecyclerMain recyclerMain;
    private List<Hit> hitList;
    private ImgDao imgDao;

    @Inject
    IApiHelper apiHelper;

    public MainPresenter() {
        recyclerMain = new RecyclerMain();
      //  apiHelper = new IApiHelper();
        model = new Model();

//        imgDao = App.getAppDatabase().imgDao();
    }

    public void setOnItemClickListener(int position) {
        model.setData(position);
        int count = model.getCount();
        getViewState().showCount(count);
    }

    @Override
    protected void onFirstViewAttach() {
       /** if(базы нет) {*/
            getAllPhoto();
      /**  }else{
            getDataFromDB();
        }*/
    }

    private void getAllPhoto() {
        App.getAppComponent().inject(this);
        Observable<Photo> single = apiHelper.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(photos -> {
            //Log.d(TAG, "onNext: " + photos.totalHits);

//            for (Photo.Hit hit : photos.hits) {
//                Log.d(TAG, "getAllPhoto: " + hit.webformatURL);
//            }
            hitList = photos.hits;

/**Где то здесь надо сохранить в базу то ли список URL, то ли фотки по отдельности?*/
            getViewState().updateRecyclerView();

        }, throwable -> {
            Log.e(TAG, "onError " + throwable);
        });

        putListData();
    }

    private void putListData() {

//        List<Image> images = new ArrayList<>();
//
//        images.add(new Image(hitList.get(0)));
//        images.add(new Image(hitList.get(1)));
//        images.add(new Image(hitList.get(2)));
//        Disposable disposable = insertList(images).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(photos->{
//
//                }, throwable -> {
//                    Log.d(TAG, "putList " + throwable);
//                });
    }

    void getDataFromDB(){

        Disposable disposable = imgDao.getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(photos -> {

                }, throwable -> {
                    Log.d(TAG, "getData: " + throwable);
                });
    }
    private class RecyclerMain implements I2RecyclerMain {

        @Override
        public void bindView(IViewHolder iViewHolder) {
            iViewHolder.setImage(hitList.get(iViewHolder.getPos()).webformatURL);
        }

        @Override
        public int getItemCount() {
            if (hitList != null) {
                return hitList.size();
            }
            return 0;
        }
    }

    public RecyclerMain getRecyclerMain() {
        return recyclerMain;
    }
}
