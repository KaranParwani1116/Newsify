package com.example.newsify;


import android.graphics.Bitmap;

public class NewsActivity {
    private String title;
    private String Content;
    private String imageUrl;
    private String textUrl;

    public NewsActivity(String mtitle,String mcontent,String mimageUrl,String Url)
    {
        title=mtitle;
        Content=mcontent;
        imageUrl=mimageUrl;
        textUrl=Url;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return Content;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public String getTextUrl() {
        return textUrl;
    }
}
