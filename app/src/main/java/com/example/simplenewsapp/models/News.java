package com.example.simplenewsapp.models;

import com.example.simplenewsapp.utils.DateManager;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "news")
public class News {

    @PrimaryKey
    private int id;

    private String title;

    @SerializedName("text")
    private String content;

    private String date;

    private long millis;

    private transient boolean unread = true;

    public News(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
        millis = DateManager.parseToMillis(date);
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public boolean isUnread() {
        return unread;
    }


    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setRead() {
        this.unread = false;
    }
}
