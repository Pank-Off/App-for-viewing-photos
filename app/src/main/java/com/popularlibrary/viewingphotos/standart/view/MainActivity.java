package com.popularlibrary.viewingphotos.standart.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.popularlibrary.viewingphotos.R;

import com.popularlibrary.viewingphotos.standart.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView {

    Button setTextBtn;
    TextView textView;
    EditText editText;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        mainPresenter = new MainPresenter(this);
        setOnBtnClickListener();
    }

    private void setOnBtnClickListener() {
        setTextBtn.setOnClickListener(v -> {
            String text = editText.getText() + " ";
            mainPresenter.setOnBtnClick(text);
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
