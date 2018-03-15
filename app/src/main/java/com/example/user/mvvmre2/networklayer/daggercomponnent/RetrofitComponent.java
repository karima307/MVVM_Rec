package com.example.user.mvvmre2.networklayer.daggercomponnent;

import com.example.user.mvvmre2.networklayer.daggermodul.RetrofitModul;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by user on 3/14/2018.
 */
@Singleton
@Component(modules = {RetrofitModul.class})
public interface RetrofitComponent {
     Retrofit getRetrofitComponent();
}
