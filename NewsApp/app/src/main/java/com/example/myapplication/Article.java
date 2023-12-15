package com.example.myapplication;
import com.example.myapplication.NewsAdapter;
import com.example.myapplication.NewsApiService;
import com.example.myapplication.NewsResponse;

public class Article {
    public String title;
    public String description;
    public String urlToImage;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }
}
