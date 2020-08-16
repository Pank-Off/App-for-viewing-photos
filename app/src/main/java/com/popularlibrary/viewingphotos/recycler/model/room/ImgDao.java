package com.popularlibrary.viewingphotos.recycler.model.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface ImgDao {

    @Query("SELECT * FROM table_images")
    Single<List<Image>> getAll();

    @Insert
    Single<Long> insert(Image img);

}
