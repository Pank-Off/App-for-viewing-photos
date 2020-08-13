package com.popularlibrary.viewingphotos.moxy.presenter;

import com.popularlibrary.viewingphotos.moxy.model.SecondModel;
import com.popularlibrary.viewingphotos.moxy.view.SecondView;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class SecondPresenter extends MvpPresenter<SecondView> {
    private SecondModel model;

    public SecondPresenter() {
        model = new SecondModel();
    }

    public void setOnBtnClick(String text) {
        model.setText(text);
        getViewState().setTextFromEditText(model.getText());
    }
}
