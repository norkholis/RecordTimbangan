package com.example.norkholis.recordtimbangan.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.norkholis.recordtimbangan.R;

public class LoginPanelActivity extends AppCompatActivity {
    Button btn_login, btn_toRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_panel);

        btn_login = (Button)findViewById(R.id.btn_login);
        btn_toRegister = (Button)findViewById(R.id.btn_toRegister);

        btn_toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginPanelActivity.this, RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginPanelActivity.this, DashBoardActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
