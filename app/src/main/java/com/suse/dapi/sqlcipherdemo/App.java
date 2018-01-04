package com.suse.dapi.sqlcipherdemo;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Administrator on 2018/1/4.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this,"application");
    }// end m

}
