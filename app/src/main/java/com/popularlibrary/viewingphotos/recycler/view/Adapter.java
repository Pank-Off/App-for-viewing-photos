package com.popularlibrary.viewingphotos.recycler.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.popularlibrary.viewingphotos.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private ArrayList<Integer> arrayList;
    private OnItemClickListener onItemClickListener;

    Adapter(ArrayList<Integer> arrayList, OnItemClickListener onItemClickListener) {
        this.arrayList = arrayList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new MyViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.img.setImageResource(arrayList.get(position));
        holder.img.setOnClickListener(v -> holder.listener.onClick(position));
    }

    @Override
    public int getItemCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        OnItemClickListener listener;

        MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            this.listener = listener;
        }
    }
}
