package com.popularlibrary.viewingphotos.recycler.model.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface ImgDao {

    @Query("SELECT * FROM table_images")
    Single<List<Image>> getAll();

    @Query("SELECT * FROM table_images WHERE id = :id")
    Single<List<Image>> getAllById(int id);

    @Insert
    Single<Long> insert(Image img);

    @Insert
    List<Long> insertList(List<Image> images);

    @Delete
    Single<Integer> delete(Image img);

    @Update
    Single<Integer> update(Image img);
}
