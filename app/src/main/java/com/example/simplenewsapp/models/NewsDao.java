package com.example.simplenewsapp.models;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface NewsDao {
    @Insert
    void insert(News news);
}
