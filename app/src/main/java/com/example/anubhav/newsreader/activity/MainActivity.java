package com.example.anubhav.newsreader.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.anubhav.newsreader.R;
import com.example.anubhav.newsreader.adapter.HomeNewsAdapter;
import com.example.anubhav.newsreader.model.GetArticlesResponse;
import com.example.anubhav.newsreader.networking.NewsAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView newsRecyclerView;
    private HomeNewsAdapter homeNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsRecyclerView = (RecyclerView) findViewById(R.id.newsRecycler);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        Call<GetArticlesResponse> call = NewsAPI.getApi().getArticles("reuters", "top");
        call.enqueue(new Callback<GetArticlesResponse>() {
            @Override
            public void onResponse(Call<GetArticlesResponse> call, Response<GetArticlesResponse> response) {
                GetArticlesResponse getArticlesResponse = response.body();
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                homeNewsAdapter = new HomeNewsAdapter(getArticlesResponse.getArticles(), MainActivity.this);
                newsRecyclerView.setAdapter(homeNewsAdapter);
            }

            @Override
            public void onFailure(Call<GetArticlesResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
