package com.example.norkholis.recordtimbangan.adapter;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.norkholis.recordtimbangan.R;
import com.example.norkholis.recordtimbangan.fragment.ViewRecord;
import com.example.norkholis.recordtimbangan.model.DataTimbanganModel;
import com.example.norkholis.recordtimbangan.view.NavDrawer;
import com.google.gson.Gson;

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
        beratBadan_item.setText(String.valueOf(item.getBeratBadan()));
        tanggal_item.setText(item.getTanggal());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id_timbangan = item.getIdTimbangan();
                NavDrawer navDrawer = (NavDrawer)view.getContext();
                ViewRecord viewRecord = new ViewRecord();
                Bundle bundle = new Bundle();
                bundle.putInt(ViewRecord.TIMBANGAN_ITEM, id_timbangan);
                viewRecord.setArguments(bundle);

                navDrawer.getSupportFragmentManager().beginTransaction().replace(R.id.container, viewRecord).addToBackStack(null).commit();
            }
        });
    }
}


//    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.container, jadwalTimbang);
//                    transaction.commit();