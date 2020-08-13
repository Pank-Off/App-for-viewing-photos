package com.popularlibrary.viewingphotos.gson;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.popularlibrary.viewingphotos.R;

public class GsonActivity extends AppCompatActivity {
    String json = "{\n" +
            " \"time_of_year\": \"summer\",\n" +
            "\"year\": 2019}";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        Log.d("json:", json);

        Gson gson = new GsonBuilder().create();
        JsonExample user = gson.fromJson(json, JsonExample.class);
        Log.d("parse json:",user.time_of_year + " " + user.year);
    }
}
