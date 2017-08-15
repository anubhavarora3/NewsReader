package com.example.anubhav.newsreader.model;

/**
 * Created by anubhav on 15/08/17.
 */

public class NewsArticle {

    private String title, details, time, imageUrl, articleUrl;


    public NewsArticle(String title, String details, String time, String imageUrl, String articleUrl) {
        this.title = title;
        this.details = details;
        this.time = time;
        this.imageUrl = imageUrl;
        this.articleUrl = articleUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }
}
