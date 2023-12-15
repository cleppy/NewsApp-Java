package com.example.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import com.example.myapplication.Article;
import com.example.myapplication.NewsApiService;
import com.example.myapplication.NewsResponse;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<Article> newsItems;
    private Context context;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    public void setNewsItems(List<Article> newsItems) {
        this.newsItems = newsItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Article newsItem = newsItems.get(position);
        holder.title.setText(newsItem.getTitle());
        holder.description.setText(newsItem.getDescription());

        Picasso.get().load(newsItem.getUrlToImage()).into(holder.urlToImage);
    }

    @Override
    public int getItemCount() {
        return newsItems != null ? newsItems.size() : 0;
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        public ImageView urlToImage;
        public TextView title;
        public TextView description;

        public NewsViewHolder(@NonNull View newsItems) {
            super(newsItems);
            urlToImage = newsItems.findViewById(R.id.urlToImage);
            title = newsItems.findViewById(R.id.title);
            description = newsItems.findViewById(R.id.description);
        }
    }
}
