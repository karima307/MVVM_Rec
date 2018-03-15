package com.example.user.mvvmre2.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.mvvmre2.databinding.MovielistBinding;
import com.example.user.mvvmre2.viewmodel.Movie;
import com.example.user.mvvmre2.R;

import java.util.ArrayList;

/**
 * Created by user on 2/28/2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private ArrayList<Movie> moviesList;
    public MoviesAdapter( ArrayList<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View statusContainer = LayoutInflater.from(parent.getContext()).inflate(R.layout.movielist, parent, false);
        return new MyViewHolder(statusContainer);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
      holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        MovielistBinding mbinding;

        public MyViewHolder(View itemView) {
            super(itemView);
            mbinding = DataBindingUtil.bind(itemView);
        }
        public void bind(@NonNull Movie movie){
            mbinding.setMoviie(movie);


        }
    }


}