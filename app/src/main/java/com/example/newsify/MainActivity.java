package com.example.newsify;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.newsify.Sync.NewsSyncUtils;
import com.example.newsify.utils.JsonNewsutils;
import com.example.newsify.utils.NetworkUtils;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsListAdapter.NewsClickHandler {

    private RecyclerView mrecyclerview;
    private static final String TAG=MainActivity.class.getSimpleName();
    private  NewsListAdapter newsListAdapter;
    private String Content_Key="Content_key";
    private String Image_key="Image_key";
    private static final String TOPHEADLINE_URL="https://newsapi.org/v2/top-headlines?country=In&category=sports&apiKey=3656e4760aea425b8268643bcf9b1208";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"On Create Invoked");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] fakedata={"Osama Died In Pakistan","Narendra Modi Takes Oath",
        "Nafaj shareef put in jail","India Won 2019 World Cup","Pakistan Losse All matches in World cup"};

         mrecyclerview=(RecyclerView)findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mrecyclerview.setLayoutManager(layoutManager);

        mrecyclerview.setHasFixedSize(true);

        newsListAdapter=new NewsListAdapter(this,this);
        mrecyclerview.setAdapter(newsListAdapter);

        updateui();

    }

    private void updateui() {
        final URL url= NetworkUtils.geturl();
        AsyncTask<Void,Void,List<NewsActivity>>asyncTask=new AsyncTask<Void, Void, List<NewsActivity>>() {
            @Override
            protected List<NewsActivity> doInBackground(Void... voids) {
                List<NewsActivity>NewsObject=null;

                try {
                    String JsonResponse=NetworkUtils.getResponseFromHTTPUrl(url);
                    NewsObject = JsonNewsutils.getnews(JsonResponse);
                    return NewsObject;

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return NewsObject;

            }

            @Override
            protected void onPostExecute(List<NewsActivity>news) {
                newsListAdapter.setNewsdata(news);
            }
        };

        asyncTask.execute();

    }


    @Override
    public void onClick(int Position) {

        NewsActivity newsActivity=newsListAdapter.getItem(Position);

        Intent intent=new Intent(MainActivity.this,DetailActivity.class);
        intent.putExtra(Content_Key,newsActivity.getTextUrl());
        intent.putExtra(Image_key,newsActivity.getImageUrl());

        startActivity(intent);
    }
}
