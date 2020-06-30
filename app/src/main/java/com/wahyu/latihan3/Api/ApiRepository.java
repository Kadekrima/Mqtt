package com.wahyu.latihan3.Api;

import android.util.Log;

import com.wahyu.latihan3.BuildConfig;

import static com.wahyu.latihan3.BuildConfig.API;
import static com.wahyu.latihan3.BuildConfig.BASEURL_MOVIE;

public class ApiRepository {

    String Url = BASEURL_MOVIE+"3/discover/movie?api_key="+API+"&language=en-US&include_adult=false&include_video=false&page=1";

    public String getAllMovie(){
        Log.d("TAG", "getAllMovie: "+Url);
        return Url;
    }

    public String getMovieGenres(){

        Url+="&with_genres=27";
        Log.d("TAG", "getMovieGenres:  "+Url);
        return Url;
    }

    public String getMovieGenres2(){
        Log.d("TAG", "getMovieGenres2: "+Url);
        return Url+"&with_genres=28";
    }

}
