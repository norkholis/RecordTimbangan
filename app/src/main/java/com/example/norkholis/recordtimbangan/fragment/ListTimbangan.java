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
import com.example.norkholis.recordtimbangan.adapter.ListTimbanganAdapter;
import com.example.norkholis.recordtimbangan.api.APIClient;
import com.example.norkholis.recordtimbangan.model.DataTimbanganModel;
import com.example.norkholis.recordtimbangan.util.SharedPrefManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListTimbangan extends Fragment {
    private ListTimbanganAdapter listTimbanganAdapter;
    private APIClient apiClient = new APIClient();
    private SharedPrefManager sharedPrefManager;
    private Call<List<DataTimbanganModel>> apiCall;
    private RecyclerView rvListTimbangan;


    public ListTimbangan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_list_timbangan, container, false);

        sharedPrefManager = new SharedPrefManager(getContext());

        int id_user = sharedPrefManager.getSpId();
        apiCall = apiClient.getService().getTimbanganUser(id_user);
        apiCall.enqueue(new Callback<List<DataTimbanganModel>>() {
            @Override
            public void onResponse(Call<List<DataTimbanganModel>> call, Response<List<DataTimbanganModel>> response) {
                if (response.isSuccessful()){
                    List<DataTimbanganModel> listDataTimbangan = response.body();
                    if (listDataTimbangan.size()!= 0){
                        rvListTimbangan = (RecyclerView)view.findViewById(R.id.rvListTimbangan);
                        rvListTimbangan.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
                        rvListTimbangan.setLayoutManager(new LinearLayoutManager(getContext()));
                        listTimbanganAdapter = new ListTimbanganAdapter();
                        listTimbanganAdapter.updateData(listDataTimbangan);
                        rvListTimbangan.setAdapter(listTimbanganAdapter);
                    }else{
                        Toast.makeText(getContext(), "Data kosong", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<DataTimbanganModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Data Tidak bisa diambil"+t, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
