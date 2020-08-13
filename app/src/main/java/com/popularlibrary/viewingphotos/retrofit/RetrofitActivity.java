package com.popularlibrary.viewingphotos.retrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.popularlibrary.viewingphotos.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RetrofitActivity extends AppCompatActivity {
    RetrofitPresenter retrofitPresenter;
    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        retrofitPresenter = new RetrofitPresenter(this);
    }

    @OnClick(R.id.button_activity_retrofit)
    public void onClickButton(View view) {
        retrofitPresenter.getPhoto();

    }

    void setImage(String url) {
        Glide
                .with(this)
                .load(url)
                .into(imageView);
    }
}
