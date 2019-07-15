package com.example.newsify.Sync;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class NewsSyncIntentService extends IntentService {
    private static final String TAG=NewsSyncIntentService.class.getSimpleName();

    public NewsSyncIntentService() {
        super("NewsIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG,"On Handle Intent Invoked");
        NewsSyncTask.syncNews();
    }
}
