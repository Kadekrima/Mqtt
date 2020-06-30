package com.wahyu.latihan3;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Server {

    public static String Url = BuildConfig.BASEURL;
    public static RequestQueue quen;
    public static StringRequest stringRequest;

    public static void Login(final String user, final String pass, final Context context){
        quen = Volley.newRequestQueue(context);
        stringRequest = new StringRequest(Request.Method.GET, Url + "User.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray arr = object.getJSONArray("data");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject object1 = arr.getJSONObject(i);
                        User user1 = new User(object1);

                        if (user1.Name.equals(user) && user1.Pass.equals(pass)) {
                            Intent intent = new Intent(context, Scanner.class);
                            context.startActivity(intent);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
    });
        quen.add(stringRequest);
    }
    static void Daftar(String pass, String user, final Context context){
        String UrlDaftar = Url+"Login.php?user="+user+"&pass="+pass;
        stringRequest = new StringRequest(Request.Method.GET, UrlDaftar, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    String kode = object.getString("kode");
                    String pesan = object.getString("pesan");
                    Log.d("TAG", "onResponses" + pesan);
                    if (kode.equals("1")){
                        Intent intent = new Intent(context, Login.class);
                        context.startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        quen = Volley.newRequestQueue(context);
        quen.add(stringRequest);
    }
}
