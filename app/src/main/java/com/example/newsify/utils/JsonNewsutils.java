package com.example.newsify.utils;

import android.util.Log;

import com.example.newsify.NewsActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonNewsutils {

    private static final String TAG =JsonNewsutils.class.getSimpleName();

    public static List<NewsActivity> getnews(String JsonResponse){
        List<NewsActivity>Title=new ArrayList<>();

        try {
            JSONObject baseJsonresponse=new JSONObject(JsonResponse);
            JSONArray topArticles=baseJsonresponse.getJSONArray("articles");

            for(int i=0;i<topArticles.length();i++)
            {
               JSONObject CurrentNews=topArticles.getJSONObject(i);
               String Newstitle=CurrentNews.getString("title");
               String Description=CurrentNews.getString("description");
               String imageurl=CurrentNews.getString("urlToImage");
               String Url=CurrentNews.getString("url");
                Log.d(TAG,imageurl);


                   Title.add(new NewsActivity(Newstitle,Description,imageurl,Url));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return Title;
    }
}

