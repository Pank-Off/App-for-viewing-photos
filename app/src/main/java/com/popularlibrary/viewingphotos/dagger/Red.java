package com.popularlibrary.viewingphotos.dagger;

import android.util.Log;

import com.popularlibrary.viewingphotos.dagger.app.App;

import javax.inject.Inject;

public class Red {

    private static final String TAG = "Red";

    @Inject
    Green green;

    Red() {
        App.getAppComponent().inject(this);
        Log.d(TAG, green.getColor());
        Log.d(TAG, String.valueOf(green));
    }
}
