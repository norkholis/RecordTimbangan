package com.example.norkholis.recordtimbangan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.norkholis.recordtimbangan.R;
import com.example.norkholis.recordtimbangan.api.APIClient;
import com.example.norkholis.recordtimbangan.model.UserModel;
import com.example.norkholis.recordtimbangan.util.SharedPrefManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {

    private APIClient apiClient = new APIClient();
    SharedPrefManager sharedPrefManager;


    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        final EditText profile_nama = (EditText)view.findViewById(R.id.profile_nama);
        final EditText profile_alamat = (EditText)view.findViewById(R.id.profile_alamat);
        final EditText profile_nc = (EditText)view.findViewById(R.id.profile_nc);
        final EditText profile_telpon = (EditText)view.findViewById(R.id.profile_telpon);
        Button saveProfile = (Button)view.findViewById(R.id.saveProfile);
        EditText profile_tinggiBadan = (EditText)view.findViewById(R.id.profile_tinggiBdn);

        sharedPrefManager = new SharedPrefManager(getContext());
        int id_user = sharedPrefManager.getSpId();

//        float tinggiBadan = Float.parseFloat(profile_tinggiBadan.getText().toString().trim());

//        sharedPrefManager.saveSPFloat(SharedPrefManager.SP_TINGGI_BADAN, tinggiBadan);

        Call<List<UserModel>> apiGetDataUser = apiClient.getService().requestDataUser(id_user);
        apiGetDataUser.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                if (response.isSuccessful()){
                    List<UserModel> dataListUser = response.body();
                    String nama_user = dataListUser.get(0).getNamaUser();
                    String alamat_user = dataListUser.get(0).getAlamatUser();
                    String nc = dataListUser.get(0).getIdAnc();
                    String no_telp_user = dataListUser.get(0).getTelpUser();

                    profile_nama.setText(nama_user);
                    profile_alamat.setText(alamat_user);
                    profile_nc.setText(nc);
                    profile_telpon.setText(no_telp_user);
                }
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Cant get user data"+t, Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }

}
