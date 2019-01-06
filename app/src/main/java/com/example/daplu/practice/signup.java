package com.example.daplu.practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity {
    EditText name, login_email, login_pwd, login_pwd2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.signup);

        name = findViewById(R.id.name);
        login_email = findViewById(R.id.login_email);
        login_pwd = findViewById(R.id.login_pwd);
        login_pwd2 = findViewById(R.id.login_pwd2);

        Button btn_signin = findViewById(R.id.btn_signin);


        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signup.this, signin.class));
            }
        });

    }

    public void Onsignup(View view) {
        String str_name = name.getText().toString();
        String str_login_email = login_email.getText().toString();
        String str_login_pwd = login_pwd.getText().toString();
        String str_login_pwd2 = login_pwd2.getText().toString();

        String type = "register";

        if(str_login_pwd==str_login_pwd2) {
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, str_name, str_login_pwd, str_login_email);
            startActivity(new Intent(signup.this, signin.class));
        }

    }
}

