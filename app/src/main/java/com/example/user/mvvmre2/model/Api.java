package com.example.user.mvvmre2.model;

import com.example.user.mvvmre2.model.Hero;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by user on 2/28/2018.
 */

public interface Api {
    String BASE_URL="https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<ArrayList<Hero>> getHero();
}
