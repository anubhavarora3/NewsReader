package com.example.anubhav.newsreader.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.anubhav.newsreader.R;
import com.example.anubhav.newsreader.activity.NewsDetailsActivity;
import com.example.anubhav.newsreader.model.Article;

import java.util.List;

/**
 * Created by anubhav on 15/08/17.
 */

public class HomeNewsAdapter extends RecyclerView.Adapter<HomeNewsAdapter.HomeNewsViewHolder> {

    private List<Article> newsList;
    private Context context;

    public HomeNewsAdapter(List<Article> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    public static class HomeNewsViewHolder extends RecyclerView.ViewHolder {
        ImageView imgNews;
        TextView txtTitle, txtDetail, txtTime;

        public HomeNewsViewHolder(View itemView) {
            super(itemView);
            imgNews = (ImageView) itemView.findViewById(R.id.image_card);
            txtTitle = (TextView) itemView.findViewById(R.id.txt_title);
            txtDetail = (TextView) itemView.findViewById(R.id.txt_descp);
            txtTime = (TextView) itemView.findViewById(R.id.txt_time);
        }
    }

    @Override
    public HomeNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_news, parent, false);
        return new HomeNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeNewsViewHolder holder, final int position) {
        Article newsArticle = newsList.get(position);

        Glide.with(context).load(newsArticle.getUrlToImage())
                .into(holder.imgNews);

        holder.txtTitle.setText(newsArticle.getTitle());
        holder.txtDetail.setText(newsArticle.getDescription());
        holder.txtTime.setText(newsArticle.getPublishedAt());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsDetailsActivity.launch(context, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
