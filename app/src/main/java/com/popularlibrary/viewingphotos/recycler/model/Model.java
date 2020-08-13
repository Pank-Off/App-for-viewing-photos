package com.popularlibrary.viewingphotos.recycler.model;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class Model {
    private static final String TAG = "Model";
    private int count = 0;

    private static int number;

    public int getCount() {
        return count;
    }

    public static int getNumber() {
        return number;
    }

    public void setData(int position) {
        this.count++;
        number = position;
    }


}
