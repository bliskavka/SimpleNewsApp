package com.example.simplenewsapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.simplenewsapp.adapters.MainRecyclerViewAdapter;
import com.example.simplenewsapp.models.News;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    private static final String TAG = "MainActivity";
    ArrayList<News> news = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(this);
        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getNews().observe(this, new Observer<ArrayList<News>>() {
            @Override
            public void onChanged(@Nullable ArrayList<News> news) {
                adapter.setData(news);
            }
        });


    }
}
