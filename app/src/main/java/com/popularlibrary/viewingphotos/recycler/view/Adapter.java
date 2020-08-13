package com.popularlibrary.viewingphotos.recycler.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.popularlibrary.viewingphotos.R;
import com.popularlibrary.viewingphotos.recycler.model.GlideLoader;
import com.popularlibrary.viewingphotos.recycler.presenter.I2RecyclerMain;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private I2RecyclerMain i2RecyclerMain;
    private GlideLoader glideLoader;
    private OnItemClickListener onItemClickListener;

    Adapter(Context context, I2RecyclerMain i2RecyclerMain, OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        this.i2RecyclerMain = i2RecyclerMain;
        glideLoader = new GlideLoader(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new MyViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.img.setOnClickListener(v -> holder.listener.onClick(position, holder.img));
        holder.position = position;
        i2RecyclerMain.bindView(holder);
    }

    @Override
    public int getItemCount() {
        return i2RecyclerMain.getItemCount();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements IViewHolder {
        ImageView img;
        OnItemClickListener listener;
        private int position = 0;

        MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            this.listener = listener;
        }

        @Override
        public int getPos() {
            return position;
        }

        @Override
        public void setImage(String url) {
            glideLoader.loadImage(url, img);
        }
    }
}
