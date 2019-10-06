package com.example.simplenewsapp.network;

import com.google.gson.annotations.SerializedName;

public class NewsModel {

    private int id;

    private String title;

    @SerializedName("text")
    private String content;

    private String date;

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
}
