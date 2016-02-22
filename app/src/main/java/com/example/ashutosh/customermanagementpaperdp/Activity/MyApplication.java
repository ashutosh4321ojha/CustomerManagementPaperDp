package com.example.ashutosh.customermanagementpaperdp.Activity;

import android.app.Application;

import io.paperdb.Paper;

/**
 * Created by ashutosh on 2/18/2016.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Paper.init(getApplicationContext());
    }
}
