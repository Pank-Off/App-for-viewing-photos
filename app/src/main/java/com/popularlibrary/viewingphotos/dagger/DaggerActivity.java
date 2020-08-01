package com.popularlibrary.viewingphotos.dagger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.popularlibrary.viewingphotos.R;
import com.popularlibrary.viewingphotos.dagger.app.App;

import javax.inject.Inject;

public class DaggerActivity extends AppCompatActivity {
    private static final String TAG = "DaggerActivity";
    @Inject
    Green green;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        App.getAppComponent().inject(this);
        White white = new White();
        Red red = new Red();

        Log.d(TAG, "onCreate: " + green.getColor());
        Log.i(TAG, "onCreate: " + green);
    }
}
