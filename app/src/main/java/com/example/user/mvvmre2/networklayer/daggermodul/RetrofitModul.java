package com.example.user.mvvmre2.networklayer.daggermodul;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 3/14/2018.
 */
@Module
public class RetrofitModul {
    private String URL;

    public RetrofitModul(String URL) {
        this.URL = URL;
    }
    @Provides
    @Singleton
    public Gson getGson(){
        return new GsonBuilder().create();
    }
    @Singleton
    @Provides
    public Retrofit getRetrofit(Gson gson){
        return new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }
}
