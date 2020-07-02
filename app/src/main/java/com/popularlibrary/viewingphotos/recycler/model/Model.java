package com.popularlibrary.viewingphotos.recycler.model;

public class Model {

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
