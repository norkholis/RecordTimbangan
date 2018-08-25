package com.example.norkholis.recordtimbangan.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.norkholis.recordtimbangan.R;
import com.example.norkholis.recordtimbangan.model.DataTimbanganModel;

import java.util.ArrayList;
import java.util.List;

public class ListTimbanganAdapter extends RecyclerView.Adapter<LIstTimbanganViewHolder>{
    private List<DataTimbanganModel> list = new ArrayList<>();

    public void updateData(List<DataTimbanganModel> items){
        list.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LIstTimbanganViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LIstTimbanganViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.timbangan_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LIstTimbanganViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
