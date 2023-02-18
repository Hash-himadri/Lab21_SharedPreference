package com.himadri_parikh.lab7_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Space;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView tvUname;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SPConfig sp = new SPConfig(HomeActivity.this);

        tvUname = findViewById(R.id.tvUname);
        btnLogout = findViewById(R.id.btnLogout);
        tvUname.setText("Welcome "+getIntent().getExtras().getString("u"));
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sp.writeLoginStatus(false);
                Intent in = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(in);
                finish();
            }
        });

    }
}