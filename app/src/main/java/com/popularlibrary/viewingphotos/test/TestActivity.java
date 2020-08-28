package com.popularlibrary.viewingphotos.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.popularlibrary.viewingphotos.R;

import java.util.List;

public class TestActivity extends AppCompatActivity implements TestView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestPresenter testPresenter = new TestPresenter(this);
       List<String> list = testPresenter.getList();

       for(String s:list){
           Log.d("LIST", s);
       }
       testPresenter.testMethod();
    }

    @Override
    public List<String> getList() {
        return null;
    }

    @Override
    public void testMethod() {

        Log.d("test","meow");
    }
}
