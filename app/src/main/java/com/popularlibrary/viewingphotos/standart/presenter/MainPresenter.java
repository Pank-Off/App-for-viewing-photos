package com.popularlibrary.viewingphotos.standart.presenter;

import com.popularlibrary.viewingphotos.standart.model.Model;
import com.popularlibrary.viewingphotos.standart.view.MainView;

public class MainPresenter {
    private MainView mainView;
    private Model model;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        model = new Model();
    }

    public void setOnBtnClick(String text) {
        model.setText(text);
        mainView.setTextFromEditText(model.getText());
    }
}
