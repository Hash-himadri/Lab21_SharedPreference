package com.himadri_parikh.lab7_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Step 1 - local reference
    EditText edtUser, edtPass;
    Button btnLogin;
//    String user = "admin";
//    String pass = "admin@123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SPConfig sp = new SPConfig(MainActivity.this);
        if(sp.readLoginStatus()){
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }


        //Step 2 - binding views
        edtUser = findViewById(R.id.edtUsername);
        edtPass = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        //Step 3 - implement listener
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = edtUser.getText().toString();
                String upass = edtPass.getText().toString();

                if(uname.equals("")||upass.equals("")){
                    Toast.makeText(MainActivity.this,
                            "Please enter values",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    if(uname.equals(getResources().getString(R.string.uname))
                            &&upass.equals(getResources().getString(R.string.upass))){

                        sp.writeLoginStatus(true);
                        Intent intent = new Intent(MainActivity.this,
                                HomeActivity.class);
//                        intent.putExtra("u", uname);
                        startActivity(intent);

                    }
                    else{
                        Toast.makeText(MainActivity.this,
                                "Please enter valid credentials",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}