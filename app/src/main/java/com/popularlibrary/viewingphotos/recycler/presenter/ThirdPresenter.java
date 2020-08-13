package com.popularlibrary.viewingphotos.recycler.presenter;

import com.popularlibrary.viewingphotos.recycler.model.Model;
import com.popularlibrary.viewingphotos.recycler.view.ThirdView;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class ThirdPresenter extends MvpPresenter<ThirdView> {

    private Model model;

    public ThirdPresenter() {
        model = new Model();
    }

    public void setOnItemClickListener(int position) {
        model.setData(position);
        int count = model.getCount();
        getViewState().showCount(count);
    }
}
