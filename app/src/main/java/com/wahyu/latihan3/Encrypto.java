package com.wahyu.latihan3;

import android.content.Intent;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypto {
    /*Membuat encrypto*/
    public static String MD5(String string){
        try {
            /*Buat hash untuk pesan*/

            MessageDigest hash = MessageDigest.getInstance("MD5");
            hash.update(string.getBytes());

            /*Buat variabel byte[] untuk menampung array dari bit string/password panjang 16byte/128bit*/

            byte[] pesanByte = hash.digest();

            /*Variabel sb untuk menampung string dari hasil hasing*/

            StringBuilder sb = new StringBuilder();

            /*Lakukan perulangan sepanjang pesan byte*/

            for (int i=0; i<pesanByte.length; i++){
                /*Baca semua hasil encryption sepanjang 32 karakter*/

                sb.append(Integer.toString((pesanByte[i] & 0xff)+0x100,16).substring(1));
            }
            /*kembalikan nilai encryption dalam bentuk string*/

            return sb.toString();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }
}
