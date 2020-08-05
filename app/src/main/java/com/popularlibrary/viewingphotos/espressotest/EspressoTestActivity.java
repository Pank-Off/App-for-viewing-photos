package com.popularlibrary.viewingphotos.espressotest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.popularlibrary.viewingphotos.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EspressoTestActivity extends AppCompatActivity {

    @BindView(R.id.test_button)
    Button button;

    @BindView(R.id.test_textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.test_button)
    void setText(){
        textView.setText("Test passed");
    }
}
