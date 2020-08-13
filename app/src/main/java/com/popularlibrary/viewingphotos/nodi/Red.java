package com.popularlibrary.viewingphotos.nodi;

import android.util.Log;

class Red {

    private static final String TAG ="Red";
    Red(){
        Green green = new Green();
        Log.d(TAG, green.getColor());
        Log.d(TAG, String.valueOf(green));
    }
}
