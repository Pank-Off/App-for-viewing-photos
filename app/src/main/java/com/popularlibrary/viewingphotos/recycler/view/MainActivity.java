package com.popularlibrary.viewingphotos.recycler.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.popularlibrary.viewingphotos.R;
import com.popularlibrary.viewingphotos.recycler.presenter.MainPresenter;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    private static final String TAG = "MainActivity";
    public static final String EXTRA = "EXTRA";
    RecyclerView recyclerView;
    Adapter myAdapter;
    Context context = this;

    @InjectPresenter
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycler);
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new Adapter(context, mainPresenter.getRecyclerMain(), (position, img) ->
        {
            Toast.makeText(context, position + " ", Toast.LENGTH_LONG).show();
            Bundle extras = new Bundle();

            Bitmap bitmap = Bitmap.createBitmap(img.getWidth(),img.getHeight(),Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            img.draw(canvas);
            extras.putParcelable(EXTRA,bitmap);

            Intent intent = new Intent(this,DetailActivity.class);
            intent.putExtras(extras);
            startActivity(intent);
        }
        );
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void showCount(int count) {
        Log.d("Count", count + "");
    }

    @Override
    public void showNumber(int number) {
    }

    @Override
    public void updateRecyclerView() {
        Log.d(TAG, "updateRecyclerView: ");
        myAdapter.notifyDataSetChanged();
    }
}
