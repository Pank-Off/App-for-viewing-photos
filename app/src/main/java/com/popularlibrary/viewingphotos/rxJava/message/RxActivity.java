package com.popularlibrary.viewingphotos.rxJava.message;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.popularlibrary.viewingphotos.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class RxActivity extends AppCompatActivity {
    private static final String TAG = "RxActivity";
    Button subscribe;
    Button unsubscribe;
    RxPresenter rxPresenter;
    Observable<String> observable;
    Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava3);

        subscribe = findViewById(R.id.subscribeBtn);
        unsubscribe = findViewById(R.id.unsubscribeBtn);
        rxPresenter = new RxPresenter();
        observable = rxPresenter.getMessage();
        subscribe();
        unsubscribe();
    }

    void subscribe() {
        subscribe.setOnClickListener(v -> {
            observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
                @Override
                public void onSubscribe(Disposable d) {
                    Log.d(TAG, "onSubscribe: ");
                    RxActivity.this.disposable = d;
                }

                @Override
                public void onNext(String s) {
                    Log.d(TAG, "onNext: " + Thread.currentThread().getName() + ": " + s);
                }

                @Override
                public void onError(Throwable e) {
                    Log.e(TAG, "onError: " + e);
                }

                @Override
                public void onComplete() {
                    Log.d(TAG, "onComplete: ");
                }
            });
            Log.d(TAG, "subscribe: end " + Thread.currentThread().getName());
        });
    }

    public void unsubscribe() {
        unsubscribe.setOnClickListener(v -> disposable.dispose());
    }
}

