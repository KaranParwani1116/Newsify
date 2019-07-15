package com.example.newsify.Sync;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NewsSyncUtils {
    private static final String TAG=NewsSyncUtils.class.getSimpleName();
    public static void StartImmediateSync(final Context context)
    {
        Log.d(TAG,"StartImmediateSyncInvoked");
         Intent intent=new Intent(context,NewsSyncIntentService.class);
         context.startService(intent);
    }
}
