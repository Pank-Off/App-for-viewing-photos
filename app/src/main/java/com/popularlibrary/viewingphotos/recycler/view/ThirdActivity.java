package com.popularlibrary.viewingphotos.recycler.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.popularlibrary.viewingphotos.R;
import com.popularlibrary.viewingphotos.recycler.presenter.ThirdPresenter;

import java.util.ArrayList;
import java.util.Arrays;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class ThirdActivity extends MvpAppCompatActivity implements ThirdView {

    public static final String EXTRA = "EXTRA";
    RecyclerView recyclerView;

    ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground
    ));

    @InjectPresenter
    ThirdPresenter thirdPresenter;

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
        Adapter myAdapter = new Adapter(arrayList, position -> {
            Toast.makeText(getApplicationContext(), position + "", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(EXTRA, arrayList.get(position));
            startActivity(intent);
            thirdPresenter.setOnItemClickListener(position);
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
}
