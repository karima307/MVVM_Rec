package com.example.user.mvvmre2;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.mvvmre2.adapter.MoviesAdapter;
import com.example.user.mvvmre2.databinding.ActivityMainBinding;
import com.example.user.mvvmre2.model.DataHandel;
import com.example.user.mvvmre2.model.Hero;
import com.example.user.mvvmre2.viewmodel.Movie;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        dataHandel = new DataHandel(this);
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