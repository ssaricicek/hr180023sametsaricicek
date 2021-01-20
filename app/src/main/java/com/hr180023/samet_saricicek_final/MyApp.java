package com.hr180023.samet_saricicek_final;

import android.app.Application;
import android.content.Context;

public class MyApp  extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        MyApp.context = getApplicationContext();


    }

    public static Context getAppContext(){
        return MyApp.context;
    }
}