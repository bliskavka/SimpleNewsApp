package com.example.simplenewsapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.simplenewsapp.models.News;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

   private MutableLiveData<ArrayList<News>> news;
   private Repository repository;
   private static final String TAG = "MainViewModel";

    public MainViewModel() {
        repository = Repository.getInstance();
        news = repository.getNews();
    }

    public LiveData<ArrayList<News>> getNews() {
        return news;
    }
}
