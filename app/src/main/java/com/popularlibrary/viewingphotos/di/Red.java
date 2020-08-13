package com.popularlibrary.viewingphotos.di;

import android.util.Log;

class Red {

    private static final String TAG ="Red";
    Red(Green green){

        Log.d(TAG, green.getColor());
        Log.d(TAG, String.valueOf(green));
    }
}
