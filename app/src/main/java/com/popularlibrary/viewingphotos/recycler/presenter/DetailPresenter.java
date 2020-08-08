package com.popularlibrary.viewingphotos.recycler.presenter;

import android.util.Log;

import com.popularlibrary.viewingphotos.recycler.model.Model;
import com.popularlibrary.viewingphotos.recycler.view.MainView;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class DetailPresenter extends MvpPresenter<MainView> {

    public void getNumber() {
        Log.d(getClass().getSimpleName() + " Number ", Model.getNumber() + "");
        getViewState().showNumber(Model.getNumber());
    }
}
