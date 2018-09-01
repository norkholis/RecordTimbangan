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
import com.example.norkholis.recordtimbangan.model.LoginModel;
import com.example.norkholis.recordtimbangan.model.UserModel;
import com.example.norkholis.recordtimbangan.util.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPanelActivity extends AppCompatActivity {
    private APIClient apiClient = new APIClient();
    SharedPrefManager sharedPrefManager;
    EditText lgn_username, lgn_password;
    Button btn_login, btn_toRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_panel);

        btn_login = (Button)findViewById(R.id.btn_login);
        btn_toRegister = (Button)findViewById(R.id.btn_toRegister);
        lgn_username = (EditText)findViewById(R.id.lgn_username);
        lgn_password = (EditText)findViewById(R.id.lgn_password);

        setTitle("Login");

        sharedPrefManager = new SharedPrefManager(this);
        if (sharedPrefManager.getSpStatusLogin()){
            Intent i = new Intent(LoginPanelActivity.this, NavDrawer.class);
            startActivity(i);
            finish();
        }

        btn_toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginPanelActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<LoginModel> apiCallLogin = apiClient.getService().loginRequest(lgn_username.getText().toString(), lgn_password.getText().toString());

                apiCallLogin.enqueue(new Callback<LoginModel>() {
                    @Override
                    public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                        if (response.isSuccessful()){
                            boolean loginStatus = response.body().getStatus();
                            if (loginStatus == true){
                                UserModel userData = response.body().getUser();
                                int idUser = userData.getIdUser();
                                String namaUser = response.body().getUser().getNamaUser();
                                sharedPrefManager.saveSPInt(SharedPrefManager.SP_ID, idUser);
                                sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMA, namaUser);
                                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_STATUS_LOGIN, true);

                                Intent i = new Intent(LoginPanelActivity.this, NavDrawer.class);
                                startActivity(i);
                                finish();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginModel> call, Throwable t) {
                        Toast.makeText(LoginPanelActivity.this, "Login Failed \n Please check your internet connection", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
