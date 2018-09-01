package com.example.norkholis.recordtimbangan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.norkholis.recordtimbangan.R;
import com.example.norkholis.recordtimbangan.api.APIClient;
import com.example.norkholis.recordtimbangan.model.DataTimbanganModel;
import com.example.norkholis.recordtimbangan.model.DatumDetailTimbangan;
import com.example.norkholis.recordtimbangan.model.ResponseDetailTimbangan;
import com.example.norkholis.recordtimbangan.util.SharedPrefManager;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewRecord extends Fragment {
    public static final String TIMBANGAN_ITEM = "item_timbangan";
    private Call<ResponseDetailTimbangan> apiCall;
    private APIClient apiClient = new APIClient();
    private SharedPrefManager sharedPrefManager;
    private Gson gson = new Gson();

    @BindView(R.id.vDetaik_Tanggal)
    TextView vDetail_Tanggal;

    @BindView(R.id.vDetaik_BeratBadan)
    TextView vDetail_BeratBadan;

    @BindView(R.id.vDetaik_LemakTubuh)
    TextView vDetail_LemakTubuh;

    @BindView(R.id.vDetaik_KadarAir)
    TextView vDetail_KadarAir;

    @BindView(R.id.vDetaik_MassaOtot)
    TextView vDetail_MassaOtot;

    @BindView(R.id.vDetaik_RatingFisik)
    TextView vDetail_RatingFisik;

    @BindView(R.id.vDetaik_UsiaSel)
    TextView vDetail_UsiaSel;

    @BindView(R.id.vDetail_KepadatanTulang)
    TextView vDetail_KepadatanTulang;

    @BindView(R.id.vDetail_LemakPerut)
    TextView vDetail_LemakPerut;

    @BindView(R.id.vDetail_Bmr)
    TextView vDetail_Bmr;

    @BindView(R.id.deleteTimbangan)
    Button deleteTimbangan;


    public ViewRecord() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_record, container, false);
        ButterKnife.bind(this, view);

        sharedPrefManager = new SharedPrefManager(getContext());
        int id_timbangan = getArguments().getInt(TIMBANGAN_ITEM);
        int id_user = sharedPrefManager.getSpId();

        apiCall = apiClient.getService().getDetailTimbangan(id_user, id_timbangan);
        apiCall.enqueue(new Callback<ResponseDetailTimbangan>() {
            @Override
            public void onResponse(Call<ResponseDetailTimbangan> call, Response<ResponseDetailTimbangan> response) {
                if (response.isSuccessful()){
                    List<DatumDetailTimbangan> listDetail = response.body().getData();
                    if (listDetail.size() != 0){
                        vDetail_Tanggal.setText(listDetail.get(0).getTanggal());
                        vDetail_BeratBadan.setText(listDetail.get(0).getBeratBadan());
                        vDetail_LemakTubuh.setText(listDetail.get(0).getLemakTubuh());
                        vDetail_KadarAir.setText(listDetail.get(0).getKadarAir());
                        vDetail_MassaOtot.setText(listDetail.get(0).getMasaOtot());
                        vDetail_RatingFisik.setText(listDetail.get(0).getRatingFisik());
                        vDetail_UsiaSel.setText(listDetail.get(0).getUsiaSel());
                        vDetail_KepadatanTulang.setText(listDetail.get(0).getKepadatanTulang());
                        vDetail_LemakPerut.setText(listDetail.get(0).getLemakPerut());
                        vDetail_Bmr.setText(listDetail.get(0).getBmr());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDetailTimbangan> call, Throwable t) {
                Toast.makeText(getContext(), "Gagal terkoneksi dengan internet", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        getActivity().getActionBar().setTitle("Detail Timbangan");
    }
}
