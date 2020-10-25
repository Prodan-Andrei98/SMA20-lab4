package com.example.l4;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;

public class MyCustomWebViewClient extends Application {



    public boolean shouldOverrideUrlLoading(WebView view, String url){
        if(Uri.parse(url).toString().startsWith("https://www.google.com/search?q=")
                && Uri.parse(url).toString().contains("tbm=isch"))
        {
            return false;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
        return true;
    }
}
