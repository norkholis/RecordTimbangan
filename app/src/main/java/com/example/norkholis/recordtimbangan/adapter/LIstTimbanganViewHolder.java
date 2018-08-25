package com.example.norkholis.recordtimbangan.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.norkholis.recordtimbangan.R;
import com.example.norkholis.recordtimbangan.model.DataTimbanganModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LIstTimbanganViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.bmr_Item)
    TextView bmr_item;

    @BindView(R.id.beratBadan_Item)
    TextView beratBadan_item;

    @BindView(R.id.tanggal_Item)
    TextView tanggal_item;

    public LIstTimbanganViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final DataTimbanganModel item){
        bmr_item.setText(item.getBmr());
        beratBadan_item.setText(item.getBeratBadan());
        tanggal_item.setText(item.getTanggal());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
