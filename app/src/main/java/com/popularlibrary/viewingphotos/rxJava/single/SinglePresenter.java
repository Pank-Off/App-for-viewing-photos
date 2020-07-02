package com.popularlibrary.viewingphotos.rxJava.single;

import android.util.Log;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

class SinglePresenter {
    private static final String TAG = "SinglePresenter";

    Single<String> getMessage() {
        return Single.create((SingleOnSubscribe<String>) emitter -> {
            String message = "message is received";
            Log.d(TAG, "getMessage: " + Thread.currentThread().getName() + ": " + message);
            emitter.onSuccess(message);
        }).subscribeOn(Schedulers.io());
    }
}
