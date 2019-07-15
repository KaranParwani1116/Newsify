package com.example.newsify.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.util.Scanner;

public class NetworkUtils {
    private static final String TAG=NetworkUtils.class.getSimpleName();
    private static final String BASE_URL="https://newsapi.org/v2/";
    private static final String API_KEY="3656e4760aea425b8268643bcf9b1208";
    private static final String TopHeadlinesUrl="https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=3656e4760aea425b8268643bcf9b1208";

    public static URL geturl()
    {
        Log.i(TAG,"get URl method invoked");
        URL TopHeadlinesUrL=null;
        try {
             TopHeadlinesUrL=new URL(TopHeadlinesUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return TopHeadlinesUrL;
    }


    public static String getResponseFromHTTPUrl(URL url) throws IOException{
        Log.i(TAG,"get http response invoked");

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        try {

            InputStream inputStream = httpURLConnection.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("\\A");
            boolean hasinput = scanner.hasNext();
            String response = null;

            if (hasinput) {
                response = scanner.next();
            }
            scanner.close();
            return response;
        }finally {

            httpURLConnection.disconnect();
        }

    }
}
