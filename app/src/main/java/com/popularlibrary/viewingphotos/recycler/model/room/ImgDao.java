package com.popularlibrary.viewingphotos.recycler.model.room;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface ImgDao {

    @Insert
    void insert(String url);
}
