package com.example.loginandregistrationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button _registerBtn;
    EditText _txtEmail, _txtName, _txtPass, _txtPass_conf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _registerBtn = (Button)findViewById(R.id.registerBtn);
        _txtName = (EditText)findViewById(R.id.txtName);
        _txtEmail = (EditText)findViewById(R.id.txtEmail);
        _txtPass = (EditText)findViewById(R.id.txtPass);
        _txtPass_conf = (EditText)findViewById(R.id.txtPass_conf);

        _registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = _txtName.getText().toString();
                String email = _txtEmail.getText().toString();
                String password = _txtPass.getText().toString();
                String confirmPassword = _txtPass_conf.getText().toString();

                String type = "reg";
                BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
                backgroundTask.execute(type, name, email, password, confirmPassword);

            }
        });
    }
}
