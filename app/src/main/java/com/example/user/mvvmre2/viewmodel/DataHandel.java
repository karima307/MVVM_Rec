package com.example.user.mvvmre2.viewmodel;

import android.util.Log;

import com.example.user.mvvmre2.Api;
import com.example.user.mvvmre2.MainActivity;
import com.example.user.mvvmre2.model.Hero;
import com.example.user.mvvmre2.viewmodel.Movie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 3/7/2018.
 */

public class DataHandel {
    ArrayList<Movie> movieList;
    MainActivity mainActivity;

    public DataHandel(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        getAraayListMovie();
    }

    public DataHandel() {
    }

    public void getAraayListMovie() {
        movieList = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);

        Call<ArrayList<Hero>> call = api.getHero();

        call.enqueue(new Callback<ArrayList<Hero>>() {
            @Override
            public void onResponse(Call<ArrayList<Hero>> call, Response<ArrayList<Hero>> response) {
                List<Hero> heroes = response.body();
                for (int i = 0; i < heroes.size(); i++) {
                    Log.d("onResponse", "Response came from server");

                    movieList.add(new Movie(new Hero(heroes.get(i).getName(), heroes.get(i).getRealname())));
                    Log.d("ImageURL", heroes.get(i).getImageurl());
                    Log.d("ImageName", heroes.get(i).getName());
                    Log.d("ImageRealName", heroes.get(i).getRealname());
                    Log.d("Donnnnnne", "DONE");

                }
                Log.d("****************", "" + movieList.size());
                mainActivity.updateAdapter(movieList);
            }

            @Override
            public void onFailure(Call<ArrayList<Hero>> call, Throwable t) {
                Log.e("error", "errrror");
            }
        });

        //   return  movieList;
    }

    public ArrayList<Movie> moviesArrayList() {
        movieList = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);

        Call<ArrayList<Hero>> call = api.getHero();

        call.enqueue(new Callback<ArrayList<Hero>>() {
            @Override
            public void onResponse(Call<ArrayList<Hero>> call, Response<ArrayList<Hero>> response) {
                List<Hero> heroes = response.body();
                for (int i = 0; i < heroes.size(); i++) {
                    Log.d("onResponse", "Response came from server");

                    movieList.add(new Movie(new Hero(heroes.get(i).getName(), heroes.get(i).getRealname())));
                    Log.d("ImageURL", heroes.get(i).getImageurl());
                    Log.d("ImageName", heroes.get(i).getName());
                    Log.d("ImageRealName", heroes.get(i).getRealname());
                    Log.d("Donnnnnne", "DONE");

                }

             //   mainActivity.updateAdapter(movieList);
            }
            @Override
            public void onFailure(Call<ArrayList<Hero>> call, Throwable t) {
                Log.e("error", "errrror");
            }
        });
     //   Log.d("hghh", "" + movieList.size());
          return  movieList;
    }
}
