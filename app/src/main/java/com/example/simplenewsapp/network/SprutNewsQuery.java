package com.example.simplenewsapp.network;

import com.example.simplenewsapp.models.News;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SprutNewsQuery {
    String BASE_URL = "http://alter.sprut.mobi/news/";

    @GET("eurotaxi.json")
    Call<ArrayList<News>> getNews();
}
