package com.example.norkholis.recordtimbangan.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.norkholis.recordtimbangan.R;
import com.example.norkholis.recordtimbangan.api.APIClient;
import com.example.norkholis.recordtimbangan.model.NewTimbanganModel;
import com.example.norkholis.recordtimbangan.util.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddNewRecord extends Fragment {
    private APIClient apiClient = new APIClient();
    SharedPrefManager sharedPrefManager;


    public AddNewRecord() {
        // Required empty public constructor
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        getActivity().getActionBar().setTitle("Add New Record");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_new_record, container, false);

        sharedPrefManager = new SharedPrefManager(getContext());

        Button btnSaveTimbangan = (Button)view.findViewById(R.id.saveTimbangan);
        final EditText inTim_Tanggal = (EditText)view.findViewById(R.id.inTim_Tanggal);
        final EditText inTim_BeratBadan = (EditText)view.findViewById(R.id.inTim_BeratBadan);
        final EditText inTim_LemakTubuh = (EditText)view.findViewById(R.id.inTim_LemakTubuh);
        final EditText inTim_KadarAir = (EditText)view.findViewById(R.id.inTim_KadarAir);
        final EditText inTim_MasaOtot =(EditText)view.findViewById(R.id.inTim_MasaOtot);
        final EditText inTim_RatingFisik = (EditText)view.findViewById(R.id.inTim_RatingFisik);
        final EditText inTim_UsiaSel = (EditText)view.findViewById(R.id.inTim_UsiaSel);
        final EditText inTim_KepadatanTulang = (EditText)view.findViewById(R.id.inTim_KepadatanTulang);
        final EditText inTim_LemakPerut = (EditText)view.findViewById(R.id.inTim_LemakPerut);
        final EditText inTim_Bmr = (EditText)view.findViewById(R.id.inTim_Bmr);
        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab);


        final int id_user = sharedPrefManager.getSpId();


        btnSaveTimbangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<NewTimbanganModel> apiCallNewTimbangan = apiClient.getService().addTimbangan(id_user,
                        inTim_Tanggal.getText().toString(),
                        Float.parseFloat(inTim_BeratBadan.getText().toString().trim()),
                        Float.parseFloat(inTim_LemakTubuh.getText().toString().trim()),
                        Float.parseFloat(inTim_KadarAir.getText().toString().trim()),
                        Float.parseFloat(inTim_MasaOtot.getText().toString().trim()),
                        Float.parseFloat(inTim_RatingFisik.getText().toString().trim()),
                        Float.parseFloat(inTim_UsiaSel.getText().toString().trim()),
                        Float.parseFloat(inTim_KepadatanTulang.getText().toString().trim()),
                        Float.parseFloat(inTim_LemakPerut.getText().toString().trim()),
                        Float.parseFloat(inTim_Bmr.getText().toString().trim()));
                apiCallNewTimbangan.enqueue(new Callback<NewTimbanganModel>() {
                    @Override
                    public void onResponse(Call<NewTimbanganModel> call, Response<NewTimbanganModel> response) {
                        if (response.isSuccessful()){
                            boolean statusAdd = response.body().getStatus();
                            if (statusAdd){
                                float bmr = Float.parseFloat(inTim_Bmr.getText().toString().trim());
                                float berat_badan = Float.parseFloat(inTim_BeratBadan.getText().toString().trim());
                                String tanggal = inTim_Tanggal.getText().toString();
                                sharedPrefManager.saveSPFloat(SharedPrefManager.SP_BERATBADAN, berat_badan);
                                sharedPrefManager.saveSPFloat(SharedPrefManager.SP_BMR, bmr);
                                sharedPrefManager.saveSPString(SharedPrefManager.SP_LAST_DATE, tanggal);

                                Toast.makeText(getContext(), "Data berhasil di tanbahkan", Toast.LENGTH_SHORT).show();
                                FragmentManager fragmentManager = getFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                TimbanganFragment timbanganFragment = new TimbanganFragment();
                                fragmentTransaction.replace(R.id.container, timbanganFragment, TimbanganFragment.class.getSimpleName());
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<NewTimbanganModel> call, Throwable t) {

                    }
                });
            }
        });

        return view;
    }

}
