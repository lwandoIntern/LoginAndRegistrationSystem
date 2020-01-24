package com.example.loginandregistrationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    Button signInBtn;
    EditText txtUserEmail, txtUserPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signInBtn = (Button)findViewById(R.id.loginBtn);
        txtUserEmail = (EditText)findViewById(R.id.txtLoginEmail);
        txtUserPass = (EditText)findViewById(R.id.txtLoginPass);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
