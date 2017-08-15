package com.example.anubhav.newsreader.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.anubhav.newsreader.util.NewsStore;
import com.example.anubhav.newsreader.R;

public class NewsDetailsActivity extends AppCompatActivity {

    private static final String KEY_INDEX = "news_index";
    private WebView webNewsView;
    private ProgressBar progressNewsBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webNewsView = (WebView) findViewById(R.id.webNewsView);
        progressNewsBar = (ProgressBar) findViewById(R.id.progressNews);

        int index = getIntent().getIntExtra(KEY_INDEX, -1);

        if (index != -1) {
            updateNewsDetails(index);
        } else {
            Toast.makeText(this, "Sorry the index is incorrect !!", Toast.LENGTH_LONG).show();
        }
    }

    public void updateNewsDetails(int index) {
        webNewsView.getSettings().setJavaScriptEnabled(true);
        webNewsView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressNewsBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressNewsBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                progressNewsBar.setVisibility(View.GONE);
                Toast.makeText(NewsDetailsActivity.this, "Error occured while loading webpage !!", Toast.LENGTH_LONG).show();
            }
        });
        webNewsView.loadUrl(NewsStore.getNewsArticles().get(index).getArticleUrl());
        getSupportActionBar().setTitle(NewsStore.getNewsArticles().get(index).getTitle());
    }

    public static void launch(Context context, int position) {
        Intent intent = new Intent(context, NewsDetailsActivity.class);
        intent.putExtra(KEY_INDEX, position);
        context.startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
