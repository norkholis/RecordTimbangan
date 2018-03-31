package com.example.norkholis.recordtimbangan.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.norkholis.recordtimbangan.R;

public class RegisterActivity extends AppCompatActivity {
    TextView daftarNC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView daftarNC = (TextView)findViewById(R.id.daftarNC);

        daftarNC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, RegisterNCActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
