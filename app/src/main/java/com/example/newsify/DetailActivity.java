package com.example.newsify;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsify.utils.NetworkUtils;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

public class DetailActivity extends AppCompatActivity {

    private WebView webView;
    private String Content_Key="Content_key";
    private String Image_key="Image_key";
    private static final String TAG=DetailActivity.class.getSimpleName();
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent=getIntent();
        String Content=intent.getStringExtra(Content_Key);
        String Image_Url=intent.getStringExtra(Image_key);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

         getWebView(Content);
    }

    private void getWebView(String Content) {

        webView=(WebView)findViewById(R.id.News_Web_View);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(Content);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
