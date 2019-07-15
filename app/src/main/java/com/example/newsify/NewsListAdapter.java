package com.example.newsify;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {
    private static final String TAG=NewsListAdapter.class.getSimpleName();

  private List<NewsActivity>News;

  public interface NewsClickHandler{
      void onClick(int Position);
  }

  private NewsClickHandler mNewsClickHandler;
  private Context context;

  public NewsListAdapter(Context mcontext,NewsClickHandler clickHandler)
  {
      context=mcontext;
      mNewsClickHandler=clickHandler;
  }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG,"On Create View Holder Invoked");
        Context context=viewGroup.getContext();
        int layoutid=R.layout.simple_list_item;
        boolean ShouldAttatchToParentImmediately=false;
        LayoutInflater inflater=LayoutInflater.from(context);

        View view=inflater.inflate(layoutid,viewGroup,ShouldAttatchToParentImmediately);

        NewsViewHolder newsViewHolder=new NewsViewHolder(view);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int position) {
        Log.d(TAG,"ON BInd View Holder Invoked");
        NewsActivity NewsObject=News.get(position);
        String title=NewsObject.getTitle();
        String imageurl=NewsObject.getImageUrl();
        String Summary=NewsObject.getContent();

        if(imageurl== JSONObject.NULL)
        {

        }
        else{


            newsViewHolder.News_Title.setText(title);
            Picasso.with(context).load(imageurl).fit().into(newsViewHolder.imageView);
            newsViewHolder.News_Summary.setText(Summary);
        }

    }

    public NewsActivity getItem(int position)
    {
        return News.get(position);
    }

    public void setNewsdata(List<NewsActivity>mnews)
    {
      News=mnews;
      notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(News==null)
            return 0;

        Log.d(TAG,String.valueOf(News.size()));
        return News.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView imageView;
        public TextView News_Title;
        public TextView News_Summary;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            News_Title=(TextView)itemView.findViewById(R.id.NewsContent);
            imageView=(ImageView)itemView.findViewById(R.id.News_Image);
            News_Summary=(TextView)itemView.findViewById(R.id.Summary);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int Position=getAdapterPosition();
            mNewsClickHandler.onClick(Position);
        }
    }
}
