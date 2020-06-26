package com.popularlibrary.viewingphotos.moxy.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.popularlibrary.viewingphotos.R;
import com.popularlibrary.viewingphotos.moxy.presenter.SecondPresenter;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class SecondActivity extends MvpAppCompatActivity implements SecondView {

    Button setTextBtn;
    TextView textView;
    EditText editText;

    @InjectPresenter
    SecondPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setOnBtnClickListener();
    }

    private void setOnBtnClickListener() {
        setTextBtn.setOnClickListener(v -> {
            String text = editText.getText() + " ";
            presenter.setOnBtnClick(text);
            editText.setText("");
        });
    }

    public void setTextFromEditText(String text) {
        textView.append(text);
    }

    private void initViews() {
        setTextBtn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
    }
}
