package com.example.l4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);

        MyApplication myApplication = (MyApplication) getApplicationContext();
        if(myApplication.getBitmap() == null){
            Toast.makeText(this, "Error transmitting URL.", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageBitmap(myApplication.getBitmap());
        }
    }
}