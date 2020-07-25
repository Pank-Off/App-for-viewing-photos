package com.popularlibrary.viewingphotos.retrofit;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

class RetrofitPresenter {
    private static final String TAG = "RetrofitPresenter";

    private RetrofitApi retrofitApi;
    private RetrofitActivity retrofitActivity;

    RetrofitPresenter(RetrofitActivity retrofitActivity) {
        retrofitApi = new RetrofitApi();
        this.retrofitActivity = retrofitActivity;
    }

    void getPhoto() {
        Observable<User> single = retrofitApi.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(user -> {
            Log.d(TAG, "onNext: " + user.avatarURL);
            retrofitActivity.setImage(user.avatarURL);
        }, throwable -> {
            Log.e(TAG, "onError");
        });
    }
}
