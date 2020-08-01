package com.popularlibrary.viewingphotos.di;

import android.util.Log;

class White {

    private static final String TAG ="White";
    White(Green green){
        Log.d(TAG, green.getColor());
        Log.d(TAG, String.valueOf(green));
    }
}
