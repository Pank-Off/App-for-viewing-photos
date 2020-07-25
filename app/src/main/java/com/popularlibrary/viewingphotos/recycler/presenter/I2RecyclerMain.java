package com.popularlibrary.viewingphotos.recycler.presenter;

import com.popularlibrary.viewingphotos.recycler.view.IViewHolder;


public interface I2RecyclerMain {
    void bindView(IViewHolder iViewHolder);

    int getItemCount();
}
