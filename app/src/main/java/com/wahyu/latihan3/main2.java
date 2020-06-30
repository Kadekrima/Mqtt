package com.wahyu.latihan3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class main2 extends AppCompatActivity {

    Button loginbutton;
    EditText userinput;
    EditText passinput;

    String PASSWORD = "qwertyuiop";
    String USER = "DOBLEH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        loginbutton = findViewById(R.id.loginbutton);
        userinput = findViewById(R.id.userinput);
        passinput = findViewById(R.id.passinput);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(userinput.getText())){
                    userinput.setError("Masukan Username atau Email Terlebih Dahulu!!!");
                }
                if (TextUtils.isEmpty(passinput.getText())){
                    passinput.setError("Masukan Password Terlebih Dahulu!!!");
                }else {
                    String user = userinput.getText().toString();
                    String pass = passinput.getText().toString();
                    String encrypt1 = Encrypto.MD5(pass);
                    String encrypt2 = Encrypto.MD5(encrypt1);
                    Log.d("pass", "hasil: "+encrypt2);
                    /*if (user.equals(USER) && pass.equals(PASSWORD)){
                        Toast.makeText(main2.this,"Anda Terdaftar",Toast.LENGTH_LONG).show();
                        Home();
                    }else {
                        if (pass.equals(PASSWORD)){
                            Toast.makeText(main2.this,"USER ANDA SALAH!!!",Toast.LENGTH_LONG).show();
                        }
                        else if (user.equals(USER)){
                            Toast.makeText(main2.this,"PASSWORD ANDA SALAH!!!",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(main2.this,"ANDA BELUM TERDAFTAR!!!",Toast.LENGTH_LONG).show();
                        }
                    }*/
                }
            }

        });
    }
    public void Home() {
        Intent intent = new Intent(this,Scanner.class);
        startActivity(intent);
    }
}
