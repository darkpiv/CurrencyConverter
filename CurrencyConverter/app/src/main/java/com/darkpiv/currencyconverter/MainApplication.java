package com.darkpiv.currencyconverter;

import android.app.Application;
import android.content.Context;

/**
 * Created by darkpiv on 3/27/17.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
