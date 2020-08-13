package com.popularlibrary.viewingphotos.rxJava.single;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.popularlibrary.viewingphotos.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class SingleActivity extends AppCompatActivity {
    private static final String TAG = "SingleActivity";
    private SinglePresenter singlePresenter;
    private Single single;
    private Disposable disposable;

    @BindView(R.id.btn)
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        singlePresenter = new SinglePresenter();
        single = singlePresenter.getMessage();
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    void onClickBtn() {
        disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(
                string -> Log.d(TAG, "onClickBtn: " + string),
                throwable -> Log.e(TAG, "onClickBtn: ", (Throwable) throwable));
    }
}
