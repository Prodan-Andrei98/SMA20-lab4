package com.example.l4;

import android.app.IntentService;
import android.content.Intent;

public class MyIntentService extends IntentService {



    /**
     * @param name
     * @deprecated
     */
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent){
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}

