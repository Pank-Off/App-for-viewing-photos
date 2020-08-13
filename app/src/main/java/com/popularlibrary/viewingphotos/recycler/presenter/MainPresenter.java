package com.popularlibrary.viewingphotos.recycler.presenter;

import android.util.Log;

import com.popularlibrary.viewingphotos.recycler.model.Model;
import com.popularlibrary.viewingphotos.recycler.model.entity.Hit;
import com.popularlibrary.viewingphotos.recycler.model.entity.Photo;
import com.popularlibrary.viewingphotos.recycler.model.retrofit.IApiHelper;
import com.popularlibrary.viewingphotos.recycler.view.IViewHolder;
import com.popularlibrary.viewingphotos.recycler.view.MainView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private static final String TAG = "MainPresenter";
    private Model model;
    private RecyclerMain recyclerMain;
    private IApiHelper apiHelper;
    private List<Hit> hitList;

    public MainPresenter() {
        recyclerMain = new RecyclerMain();
        apiHelper = new IApiHelper();
        model = new Model();
    }

    public void setOnItemClickListener(int position) {
        model.setData(position);
        int count = model.getCount();
        getViewState().showCount(count);
    }

    @Override
    protected void onFirstViewAttach() {
        getAllPhoto();
    }

    private void getAllPhoto() {
        Observable<Photo> single = apiHelper.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(photos -> {
            //Log.d(TAG, "onNext: " + photos.totalHits);

//            for (Photo.Hit hit : photos.hits) {
//                Log.d(TAG, "getAllPhoto: " + hit.webformatURL);
//            }
            hitList = photos.hits;

            getViewState().updateRecyclerView();

        }, throwable -> {
            Log.e(TAG, "onError " + throwable);
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
