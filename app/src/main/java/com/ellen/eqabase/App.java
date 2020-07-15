package com.ellen.eqabase;

import android.app.Application;
import android.util.Log;

import com.ellen.baselibrary.eqa.simpleapi.app.AppLifeListener;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new AppLifeListener() {
            @Override
            protected void onAppLaunch(boolean isColdLaunch) {
                if(isColdLaunch){
                    Log.e("Ellen2019","冷启动了");
                }else {
                    Log.e("Ellen2019","热启动");
                }
            }

            @Override
            protected void onSwitchBack() {
                Log.e("Ellen2019","切换到后台");
            }

            @Override
            protected void onSwitchFront() {
                Log.e("Ellen2019","切换到前台");
            }

            @Override
            protected void onCloseApp() {
                Log.e("Ellen2019","关闭了app");
            }
        });
    }
}
