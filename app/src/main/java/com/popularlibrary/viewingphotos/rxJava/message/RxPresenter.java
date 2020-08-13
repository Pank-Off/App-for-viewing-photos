package com.popularlibrary.viewingphotos.rxJava.message;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

class RxPresenter {
    private static final String TAG = "RxPresenter";

    Observable<String> getMessage() {
        return Observable.create((ObservableOnSubscribe<String>) emitter -> {
            try {
                for (int i = 0; true; i++) {
                    Thread.sleep(1000);
                    String message = "message " + i;
                    Log.d(TAG, "getMessage: " + Thread.currentThread().getName() + ": " + message);
                    emitter.onNext(message);
                }

            } catch (InterruptedException e) {
                Log.d(TAG, "getMessage: not disposed");
            }
        }).subscribeOn(Schedulers.io());
    }
}
