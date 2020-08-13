package com.popularlibrary.viewingphotos.room;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.popularlibrary.viewingphotos.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RoomActivity extends AppCompatActivity {
    private RoomPresenter roomPresenter;


    @BindView(R.id.add_data)
    Button addBtn;

    @BindView(R.id.delete_data)
    Button deleteBtn;

    @BindView(R.id.update_data)
    Button updateBtn;

    @BindView(R.id.get_data)
    Button getBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        roomPresenter = new RoomPresenter();
        ButterKnife.bind(this);

    }

    @OnClick(R.id.add_data)
    public void putData() {
        roomPresenter.putData();
    }

    @OnClick(R.id.delete_data)
    public void deleteData() {
        roomPresenter.deleteData();
    }

    @OnClick(R.id.update_data)
    public void updateData() {
        roomPresenter.updateData();
    }

    @OnClick(R.id.get_data)
    public void getData() {
        roomPresenter.getData();
    }
}
