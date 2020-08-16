package com.popularlibrary.viewingphotos.test;

import android.util.Log;

import java.util.List;

public class TestPresenter implements TestView {

    private TestView testView;
    private TestModel model;

    TestPresenter(TestView testView){
        this.testView = testView;
        model = new TestModel();
    }

    @Override
    public List<String> getList() {
       return model.getList();
    }

    @Override
    public void testMethod() {

        Log.d("test","meow");
    }


}
