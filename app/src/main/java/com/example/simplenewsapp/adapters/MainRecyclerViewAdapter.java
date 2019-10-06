package com.example.simplenewsapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simplenewsapp.R;
import com.example.simplenewsapp.models.News;

import java.util.ArrayList;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>{

    Context mContext;
    ArrayList<News> news = new ArrayList<>();

    public MainRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_list_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.title.setText(news.get(i).getTitle());
        viewHolder.content.setText(news.get(i).getContent());
        viewHolder.date.setText(news.get(i).getDate());
        if (!news.get(i).isUnread())
        viewHolder.unreadIcon.setVisibility(View.INVISIBLE); //TODO change after onClick on item
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public void setData(ArrayList<News> news){
        this.news = news;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView content;
        TextView date;
        ImageView unreadIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
            date = itemView.findViewById(R.id.date);
            unreadIcon = itemView.findViewById(R.id.icon_unread);
        }
    }
}
