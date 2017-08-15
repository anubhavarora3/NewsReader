package com.example.anubhav.newsreader.util;

import com.example.anubhav.newsreader.model.NewsArticle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anubhav on 15/08/17.
 */

public class NewsStore {

    private static List<NewsArticle> newsArticles = new ArrayList<>();

    public static List<NewsArticle> getNewsArticles() {
        return newsArticles;
    }

    public static void setNewsArticles(List<NewsArticle> newsArticles) {
        NewsStore.newsArticles = newsArticles;
    }
}

