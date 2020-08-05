package com.popularlibrary.viewingphotos.recycler.model.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.popularlibrary.viewingphotos.recycler.model.entity.Hit;

@Entity(tableName = "table_images")
public class Image {
    @PrimaryKey(autoGenerate = true)
    int id;

    public String URL;

    public Image() {

    }

    public Image(Hit hit) {
        URL = hit.webformatURL;
    }

    public String getURL(){
        return URL;
    }

}
