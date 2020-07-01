package com.popularlibrary.viewingphotos.rxJava.observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.popularlibrary.viewingphotos.R;

public class SpamActivity extends AppCompatActivity {

    Button spamBtn;
    Button subscribeBtn;
    Button unsubscribeBtn;
    private Spam spamer = new Spam();
    private Iam iam = new Iam();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava2);
        initViews();
        subscribeBtn.setOnClickListener(this::register);
        unsubscribeBtn.setOnClickListener(this::unregister);
        spamBtn.setOnClickListener(this::emitter);
    }

    private void initViews() {
        subscribeBtn = findViewById(R.id.subscribeBtn);
        unsubscribeBtn = findViewById(R.id.unsubscribeBtn);
        spamBtn = findViewById(R.id.spamBtn);
    }

    public void register(View view) {
        spamer.registerObserver(iam);
    }

    public void unregister(View view) {
        spamer.unregisterObserver(iam);
    }

    public void emitter(View view) {
        spamer.newSpam("spam");
    }
}
