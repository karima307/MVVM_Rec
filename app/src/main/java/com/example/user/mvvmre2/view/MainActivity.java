package com.example.user.mvvmre2.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.user.mvvmre2.R;
import com.example.user.mvvmre2.view.adapter.MoviesAdapter;
import com.example.user.mvvmre2.databinding.ActivityMainBinding;
import com.example.user.mvvmre2.networklayer.DataHandel;
import com.example.user.mvvmre2.viewmodel.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Movie> movieList = new ArrayList<>();
    ActivityMainBinding activityMainBinding;
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    Movie movie;
    DataHandel dataHandel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movie = new Movie();

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // movieList = movie.getmodel();
        mAdapter = new MoviesAdapter(movie.getmodel());

        activityMainBinding.setButton(new buttonhandel() {
            @Override
            public void onclick() {

                getData();

            }
        });
    }


    public void getData() {
        if (mAdapter == null) mAdapter = new MoviesAdapter(movie.getmodel());

            activityMainBinding.rec.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();




    }
//unUsed
    public void updateAdapter(ArrayList<Movie> movies) {

        Log.d("listSize", "" + movieList.size());
        mAdapter = new MoviesAdapter(movies);
        activityMainBinding.rec.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

}