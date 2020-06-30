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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.wahyu.latihan3.Encrypto.MD5;

public class Login extends AppCompatActivity {

    Button loginbutton;
    EditText userinput;
    EditText passinput;
    Button regist_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);

        loginbutton = findViewById(R.id.loginbutton);
        userinput = findViewById(R.id.userinput);
        passinput = findViewById(R.id.passinput);
        regist_screen = findViewById(R.id.regist_screen);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(userinput.getText())){
                    userinput.setError("Masukan Username atau Email Terlebih Dahulu!!!");
                }
                if (TextUtils.isEmpty(passinput.getText())){
                    passinput.setError("Masukan Password Terlebih Dahulu!!!");
                }else {
                    Log.d("TAG", "onClick: ");
                    String user = userinput.getText().toString();
                    String pass = passinput.getText().toString();
                    String encrypt1 = MD5(pass);
                    String PassMd5 = MD5(pass);
                    Log.d("Pass", "Password Md5 Login"+MD5(pass));
                    Server.Login(user,PassMd5, Login.this);
                }
            }

        });
        regist_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }
    public void Home() {
        Intent intent = new Intent(this,Scanner.class);
        startActivity(intent);
    }

    /*public void CekUser(final String LoginUser, final String LoginPass){
        RequestQueue queue = Volley.newRequestQueue(this);
        String Url = BuildConfig.BASEURL+"User.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("TAG", "onResponse: atas");
                try {
                    Log.d("TAG", "onResponse: "+response);
                    JSONObject object = new JSONObject(response);
                    JSONArray arr = object.getJSONArray("data");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject object1 = arr.getJSONObject(i);
                        User CekUser = new User(object1);

                        Log.d("TAG", "onResponse: user ; "+CekUser.Name);
                        Log.d("TAG", "onResponse: pass "+CekUser.Pass);
                        Log.d("TAG", "onResponse: loginUsser "+LoginUser);
                        Log.d("TAG", "onResponse: Md5Pass "+LoginPass);
                        Log.d("TAG", "Ada " + LoginUser.equals(CekUser.Name));
                        Log.d("TAG", "Ada Pass: "+ LoginPass.equals(CekUser.Pass));
                        Log.d("TAG", "PanjangLogin "+LoginUser.length());
                        Log.d("TAG", "PanjangUser "+CekUser.Name.length());

//                        if (LoginUser.equals(CekUser.Name) && LoginPass.equals(CekUser.Pass)) {
//                            Log.d("TAG", "onResponse: dalam if ");
//                            Intent intent = new Intent(Login.this, Home.class);
//                            startActivity(intent);
//                        }
                        if (LoginUser.equals(CekUser.Name)&& LoginPass.equals(CekUser.Pass)){
                            Log.d("TAG", "onResponse: Sukses");
                            Intent intent = new Intent(Login.this, Home.class);
                            startActivity(intent);
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
    });
        queue.add(stringRequest);
    }*/
}
