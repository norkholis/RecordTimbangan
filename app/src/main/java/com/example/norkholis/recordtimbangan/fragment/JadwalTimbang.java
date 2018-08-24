package com.example.norkholis.recordtimbangan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.norkholis.recordtimbangan.R;
import com.example.norkholis.recordtimbangan.adapter.JadwalAdapter;
import com.example.norkholis.recordtimbangan.api.APIClient;
import com.example.norkholis.recordtimbangan.model.JadwalModel;
import com.example.norkholis.recordtimbangan.util.SharedPrefManager;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.icu.lang.UCharacter.DecompositionType.VERTICAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class JadwalTimbang extends Fragment {
    private JadwalAdapter jadwalAdapter;
    private APIClient apiClient = new APIClient();
    private SharedPrefManager sharedPrefManager;
    private Call<List<JadwalModel>> apiCall;


    @BindView(R.id.rvJadwal)
    RecyclerView rvJadwal;

    public JadwalTimbang() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jadwal_timbang, container, false);
        sharedPrefManager = new SharedPrefManager(getContext());

        loadData();

        return view;
    }

    private void setupList(){

//        rvJadwal.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));


    }

    private void loadData(){
        int id_user = sharedPrefManager.getSpId();
        apiCall = apiClient.getService().requestJadwal(id_user);
        apiCall.enqueue(new Callback<List<JadwalModel>>() {
            @Override
            public void onResponse(Call<List<JadwalModel>> call, Response<List<JadwalModel>> response) {
                if (response.isSuccessful()){
                    List<JadwalModel> list = response.body();
                    if (list.size()!=0) {
                        rvJadwal.setLayoutManager(new LinearLayoutManager(getContext()));
                        jadwalAdapter = new JadwalAdapter();
                        jadwalAdapter.updateData(list);
                        rvJadwal.setAdapter(jadwalAdapter);
                    }else {
                        Toast.makeText(getContext(), "Data kosong", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<JadwalModel>> call, Throwable t) {
                    Toast.makeText(getContext(), "Data Tidak bisa diambil"+t, Toast.LENGTH_LONG).show();
            }
        });
    }

}


//apiCall.enqueue(new Callback<JadwalModel>() {
//@Override
//public void onResponse(Call<JadwalModel> call, Response<JadwalModel> response) {
//        if (response.isSuccessful()){
//        List<JadwalModel> list = (List<JadwalModel>) response.body();
//        if (list.size()!=0){
//        rvJadwal.setLayoutManager(new LinearLayoutManager(getContext()));
//        jadwalAdapter = new JadwalAdapter();
//        jadwalAdapter.updateData(list);
//        rvJadwal.setAdapter(jadwalAdapter);
//        }else{
//        Toast.makeText(getContext(), "Data kosong", Toast.LENGTH_LONG).show();
//        }
//        }
//        }
//
//@Override
//public void onFailure(Call<JadwalModel> call, Throwable t) {
//        Toast.makeText(getContext(), "Data Tidak bisa diambil"+t, Toast.LENGTH_LONG).show();
//        }
//        });