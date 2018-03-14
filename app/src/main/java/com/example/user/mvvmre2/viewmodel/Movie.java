package com.example.user.mvvmre2.viewmodel;

import android.databinding.BaseObservable;
import android.util.Log;

import com.example.user.mvvmre2.R;
import com.example.user.mvvmre2.model.Hero;

import java.util.ArrayList;

/**
 * Created by user on 2/28/2018.
 */


public class Movie extends BaseObservable {
    private String title, header, image;
    Hero hero;
    DataHandel dataHandel;

    public Movie(DataHandel dataHandel) {

    }

    public Movie(Hero hero) {
        this.title = hero.getName();
        this.header = hero.getRealname();
    }

    public Movie() {
    }


    public String getTitle() {
        return title;

    }

    public void setTitle(String name) {
        this.title = name;
        notifyPropertyChanged(R.id.text1);

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {

        this.image = image;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
        notifyPropertyChanged(R.id.text2);

    }

    public ArrayList<Movie> getmodel() {


        ArrayList<Movie> movies ;
        DataHandel jj = new DataHandel();
        movies = jj.moviesArrayList();
        // movies.add(movie);
        Log.d( "getmodel: ",movies.toString());

        return movies;
    }
}
