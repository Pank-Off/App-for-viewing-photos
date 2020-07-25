package com.popularlibrary.viewingphotos.recycler.model;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideLoader {
    private Context context;

    public GlideLoader(Context context) {
        this.context = context;
    }

    public void loadImage(String url, ImageView imageView){
        Glide
                .with(context)
                .load(url).placeholder(android.R.drawable.progress_indeterminate_horizontal).error(android.R.drawable.stat_notify_error)
                .into(imageView);
    }
}
