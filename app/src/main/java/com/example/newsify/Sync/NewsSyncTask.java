package com.example.newsify.Sync;

import android.util.Log;

import com.example.newsify.MainActivity;
import com.example.newsify.NewsActivity;
import com.example.newsify.NewsListAdapter;
import com.example.newsify.utils.JsonNewsutils;
import com.example.newsify.utils.NetworkUtils;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class NewsSyncTask {
    private static final String TAG=NewsSyncTask.class.getSimpleName();

    synchronized public static void syncNews()
    {

        URL url=NetworkUtils.geturl();
        String JsonResponse=null;
        try {
             JsonResponse=NetworkUtils.getResponseFromHTTPUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<NewsActivity>News= JsonNewsutils.getnews(JsonResponse);

    }
}
