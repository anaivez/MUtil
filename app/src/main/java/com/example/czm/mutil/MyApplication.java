package com.example.czm.mutil;

import android.app.Application;

/**
 * @author czm
 * Desc:
 * @date 2020/1/2 0002
 **/
public class MyApplication extends Application {

    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}
