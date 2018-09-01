package com.example.norkholis.recordtimbangan.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.norkholis.recordtimbangan.R;
import com.example.norkholis.recordtimbangan.api.APIClient;
import com.example.norkholis.recordtimbangan.model.RegisterModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private APIClient apiClient = new APIClient();
    TextView daftarNC;
    Button btnRegisterUser;
    private String idUserRegis = "";
    EditText inNama, inUsername, inPassword, inNotelp, inAlamat, inStatusUser, inIdNc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegisterUser = (Button)findViewById(R.id.btnRegisterUser);
        daftarNC = (TextView)findViewById(R.id.daftarNC);
        inNama = (EditText)findViewById(R.id.inNama);
        inUsername = (EditText)findViewById(R.id.inUsername);
        inPassword = (EditText)findViewById(R.id.inPassword);
        inNotelp = (EditText)findViewById(R.id.inNotelp);
        inAlamat = (EditText)findViewById(R.id.inAlamat);
        inStatusUser = (EditText)findViewById(R.id.inStatusUser);
        inIdNc = (EditText)findViewById(R.id.inIdNc);

        setTitle("Register");

        btnRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<RegisterModel> apiCallRegister = apiClient.getService().registerRequest(idUserRegis,
                        inNama.getText().toString(),
                        inUsername.getText().toString(),
                        inPassword.getText().toString(),
                        inAlamat.getText().toString(),
                        inNotelp.getText().toString(),
                        inStatusUser.getText().toString(),
                        inIdNc.getText().toString());
                apiCallRegister.enqueue(new Callback<RegisterModel>() {
                    @Override
                    public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                        if (response.isSuccessful()){
                            boolean registerStatus = response.body().getStatus();
                            if (registerStatus){
                                Toast.makeText(RegisterActivity.this, "Register Succed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterModel> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "Register Failed", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(RegisterActivity.this, LoginPanelActivity.class);
                        startActivity(i);
                    }
                });
            }
        });

        daftarNC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, RegisterNCActivity.class);
                startActivity(i);
            }
        });
    }
}
