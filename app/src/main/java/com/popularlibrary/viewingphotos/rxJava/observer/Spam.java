package com.popularlibrary.viewingphotos.rxJava.observer;

import android.util.Log;

import java.util.ArrayList;

public class Spam implements Observable {
    private ArrayList<Observer> arrayList;
    private static final String TAG = "Spam";
    private String spam;

    Spam() {
        arrayList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        Log.d(TAG, Thread.currentThread().getName() + " registerObserver: ");
        arrayList.add(observer);
    }

    void newSpam(String spam) {
        this.spam = spam;
        notifyAllObservers();
    }

    @Override
    public void unregisterObserver(Observer observer) {
        Log.d(TAG, Thread.currentThread().getName() + " unregisterObserver: ");
        arrayList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        Log.d(TAG, Thread.currentThread().getName() + " notifyAllObservers: ");
        for (Observer o : arrayList) {
            o.updateInfo(spam);
        }
    }
}
