package com.wahyu.latihan3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    Button register, login_screen;
    EditText pass;
    EditText user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = findViewById(R.id.btnRegister);
        user= findViewById(R.id.edtUsernameRegister);
        pass= findViewById(R.id.edtPassRegister);
        login_screen = findViewById(R.id.btn_signUp);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("onclik", "onclik");
                String nama = user.getText().toString();
                String password = pass.getText().toString();
                String passEncript = Encrypto.MD5(password);

                Server.Daftar(passEncript, nama, Register.this);
            }
        });

        login_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });


    }
}
