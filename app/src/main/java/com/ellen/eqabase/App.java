package com.ellen.eqabase;

import android.app.Application;

import com.ellen.baselibrary.eqa.simpleapi.app.AppLifeListener;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
       registerActivityLifecycleCallbacks(new AppLifeListener() {
           @Override
           protected void onAppLaunch() {

           }

           @Override
           protected void onSwitchBack() {

           }

           @Override
           protected void onSwitchLife() {

           }

           @Override
           protected void onCloseApp() {

           }
       });
    }
}
