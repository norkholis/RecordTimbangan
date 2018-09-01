package com.example.norkholis.recordtimbangan.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.norkholis.recordtimbangan.R;
import com.example.norkholis.recordtimbangan.api.APIClient;
import com.example.norkholis.recordtimbangan.model.RegisterModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterNCActivity extends AppCompatActivity {
    static String id_user = "";
    static String status_anc = "Tidak Aktif";
    static String id_sa = "1";
    APIClient apiClient = new APIClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_nc);

        final EditText inNama = (EditText)findViewById(R.id.inNamaNc);
        final EditText inUsername = (EditText)findViewById(R.id.inUsernameNc);
        final EditText inPassword = (EditText)findViewById(R.id.inPasswordNc);
        final EditText inAlamat = (EditText)findViewById(R.id.inAlamatNc);
        final EditText inTelp = (EditText)findViewById(R.id.inTelpNc);
        Button btnRegisterNc = (Button)findViewById(R.id.btnRegisterNc);

        btnRegisterNc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<RegisterModel> apiRegisterNC = apiClient.getService().registerRequestNc(id_user,
                        inNama.getText().toString(),
                        inUsername.getText().toString(),
                        inPassword.getText().toString(),
                        inAlamat.getText().toString(),
                        inTelp.getText().toString(),
                        status_anc,
                        id_sa);

                apiRegisterNC.enqueue(new Callback<RegisterModel>() {
                    @Override
                    public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                        if (response.isSuccessful()){
                            RegisterModel responseRegistNc = response.body();
                            Boolean status = responseRegistNc.getStatus();
                            if (status){
                                Toast.makeText(RegisterNCActivity.this, "Register NC berhasil dilakukan", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(RegisterNCActivity.this, LoginPanelActivity.class);
                                startActivity(i);
                                finish();
                            }else {
                                Toast.makeText(RegisterNCActivity.this, "Register NC tidak berhasil dilakukan", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterModel> call, Throwable t) {
                        Toast.makeText(RegisterNCActivity.this, "Register NC tidak berhasil dilakukan, silahkan cek koneksi internet anda", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }
}
