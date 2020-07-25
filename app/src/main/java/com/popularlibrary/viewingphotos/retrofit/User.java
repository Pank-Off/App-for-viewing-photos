package com.popularlibrary.viewingphotos.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class User {
    @Expose
    @SerializedName("avatar_url")
    String avatarURL;
}
