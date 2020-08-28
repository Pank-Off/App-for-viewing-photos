package com.popularlibrary.viewingphotos.recycler.presenter;

import com.popularlibrary.viewingphotos.recycler.model.Model;
import com.popularlibrary.viewingphotos.recycler.view.DetailView;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class DetailPresenter extends MvpPresenter<DetailView> {

    public void getNumber() {
        getViewState().showNumber(Model.getNumber());
    }
}
