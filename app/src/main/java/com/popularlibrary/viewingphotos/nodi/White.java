package com.popularlibrary.viewingphotos.nodi;

import android.util.Log;

class White {

    private static final String TAG ="White";
    White(){
        Green green = new Green();
        Log.d(TAG, green.getColor());
        Log.d(TAG, String.valueOf(green));
    }
}
