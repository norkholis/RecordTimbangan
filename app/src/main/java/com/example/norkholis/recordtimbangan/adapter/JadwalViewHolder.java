package com.example.norkholis.recordtimbangan.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import com.example.norkholis.recordtimbangan.R;
import com.example.norkholis.recordtimbangan.model.JadwalModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JadwalViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.tanggal_jadwal)
    TextView tanggalJadwal;

//    @BindView(R.id.namaNc_jadwal)
//    TextView namaNcJadwal;

    public JadwalViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final JadwalModel item){
        tanggalJadwal.setText(item.getTanggal());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Do Nothing
            }
        });
    }
}
