package com.popularlibrary.viewingphotos.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonExample {
    @Expose
    @SerializedName("time_of_year")
    String time_of_year;

    @Expose
    @SerializedName("year")
    String year;

}
