package com.popularlibrary.viewingphotos.rxJava.observer;

import android.util.Log;

public class Iam implements Observer {
    private static final String TAG = "Iam";

    @Override
    public void updateInfo(String spam) {
        Log.d(TAG, Thread.currentThread().getName() + " display: " + spam);
    }
}
