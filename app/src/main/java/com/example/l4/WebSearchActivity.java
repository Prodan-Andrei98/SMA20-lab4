package com.example.l4;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class WebSearchActivity extends Activity {


    public static final String EXTRA_URL = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.websearch);

        WebView myWebView = (WebView) findViewById(R.id.WebView);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.setWebViewClient(new WebViewClient());

        myWebView.loadUrl("https://www.google.com/search?q=cat&tbm=isch&source=lnms&sa=X");

        Button bLoadBackground = (Button) findViewById(R.id.bLoadBackground);
        Button bLoadForeground = (Button) findViewById(R.id.bLoadForeground);
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData abc = clipboard.getPrimaryClip();
        ClipData.Item item = abc.getItemAt(0);
        String url = item.getText().toString();

        if (!url.contains("https://goo.gl/images/"))
            Toast.makeText(this, "Url not valid. Try another.", Toast.LENGTH_SHORT).show();
        else {
            if (myWebView.getId() == R.id.bLoadBackground) {
                Intent intent = new Intent(this, ImageIntentService.class);
                intent.putExtra(EXTRA_URL, url);
                startService(intent);
            } else if (myWebView.getId() == R.id.bLoadForeground) {
                Intent startIntent = new Intent(this, ForegroundImageService.class);
                startIntent.setAction(ForegroundImageService.STARTFOREGROUND_ACTION);
                startIntent.putExtra(EXTRA_URL, url);
                startService(startIntent);
            }
        }

    }

    public void loadImage(View view) {


    }
}