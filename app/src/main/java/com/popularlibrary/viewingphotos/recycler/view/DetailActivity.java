package com.popularlibrary.viewingphotos.recycler.view;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.popularlibrary.viewingphotos.R;
import com.popularlibrary.viewingphotos.recycler.presenter.DetailPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

import static com.popularlibrary.viewingphotos.recycler.view.MainActivity.EXTRA;

public class DetailActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    DetailPresenter detailPresenter;

    @BindView(R.id.image)
    ImageView imageView;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);
        imageView.setImageResource((Integer) getIntent().getExtras().get(EXTRA));
        detailPresenter.getNumber();
    }

    @Override
    public void showCount(int count) {

    }

    @Override
    public void showNumber(int number) {
        Log.d(getClass().getSimpleName() + " Number: ", number + "");
    }

    @Override
    public void updateRecyclerView() {

    }
}
