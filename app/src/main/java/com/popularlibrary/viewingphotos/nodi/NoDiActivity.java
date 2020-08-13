package com.popularlibrary.viewingphotos.nodi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.popularlibrary.viewingphotos.R;

public class NoDiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_di);

        Green green = new Green();
        Red red = new Red();
        White white = new White();

    }
}
