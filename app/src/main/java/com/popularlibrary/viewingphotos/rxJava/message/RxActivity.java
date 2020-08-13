package com.popularlibrary.viewingphotos.rxJava.message;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.popularlibrary.viewingphotos.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class RxActivity extends AppCompatActivity {
    private static final String TAG = "RxActivity";
    @BindView(R.id.subscribeBtn)
    Button subscribe;
    @BindView(R.id.unsubscribeBtn)
    Button unsubscribe;

    RxPresenter rxPresenter;
    Observable<String> observable;
    Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava3);

        ButterKnife.bind(this);
        rxPresenter = new RxPresenter();
        observable = rxPresenter.getMessage();
    }

    @OnClick(R.id.subscribeBtn)
    public void subscribe() {
        disposable =
                observable.observeOn(AndroidSchedulers.mainThread()).subscribe(
                        string -> Log.d(TAG, "onNext: " + Thread.currentThread().getName() + ": " + string),
                        throwable -> Log.e(TAG, "onError: " + throwable),
                        () -> Log.d(TAG, "onComplete: "));
        Log.d(TAG, "subscribe: end " + Thread.currentThread().getName());

    }

    @OnClick(R.id.unsubscribeBtn)
    public void unsubscribe() {
        unsubscribe.setOnClickListener(v -> disposable.dispose());
    }
}

