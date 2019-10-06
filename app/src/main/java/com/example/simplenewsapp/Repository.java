package com.example.simplenewsapp;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.simplenewsapp.models.News;
import com.example.simplenewsapp.network.NewsModel;
import com.example.simplenewsapp.network.SprutNewsQuery;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class Repository {

    private static final String TAG = "debug";
    private static Repository instance;
    private MutableLiveData<ArrayList<News>> news = new MutableLiveData<>();
    private Call<ArrayList<News>> call;

    public Repository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SprutNewsQuery.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SprutNewsQuery sprutNewsQuery = retrofit.create(SprutNewsQuery.class);
        call = sprutNewsQuery.getNews();
    }

    public static Repository getInstance() {
        if(instance == null)
            instance = new Repository();
        return instance;
    }

    public MutableLiveData<ArrayList<News>> getNews() {
        getServerData();
        return news;
    }

    private void getServerData(){
        call.enqueue(new Callback<ArrayList<News>>() {
            @Override
            public void onResponse(Call<ArrayList<News>> call, Response<ArrayList<News>> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse" + response.code());
                    return;
                }
                news.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<News>> call, Throwable t) {
                Log.d(TAG, "onFailure" + t.getMessage());
            }
        });
    }
}
