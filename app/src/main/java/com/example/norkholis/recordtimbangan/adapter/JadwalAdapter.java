package com.example.norkholis.recordtimbangan.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.norkholis.recordtimbangan.R;
import com.example.norkholis.recordtimbangan.model.JadwalModel;

import java.util.ArrayList;
import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalViewHolder> {
    private List<JadwalModel> list = new ArrayList<>();

    public void updateData(List<JadwalModel> items){
        list.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public JadwalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new JadwalViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.jadwal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
