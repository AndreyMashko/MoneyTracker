package com.mashko.andrei.moneytracker;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by АДМИН on 23.10.2017.
 */

public class AppConfig extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
