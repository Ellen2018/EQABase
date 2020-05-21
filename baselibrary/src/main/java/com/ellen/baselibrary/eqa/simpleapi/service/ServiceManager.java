package com.ellen.baselibrary.eqa.simpleapi.service;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;

import androidx.fragment.app.FragmentActivity;

import com.ellen.baselibrary.eqa.simpleapi.ActivityLifeListener.ActivityLifeListener;
import com.ellen.baselibrary.eqa.simpleapi.ActivityLifeListener.ActivityLifeListenerManager;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * service简化api
 * 使用之前请确保你的Service的生命周期跟随Activity
 */
public class ServiceManager {

    private WeakReference<Activity> activityWeakReference;
    private List<Class<? extends Service>> serviceList;
    private ActivityLifeListenerManager activityLifeListenerManager;

    public ServiceManager(Activity activity){
        activityWeakReference = new WeakReference<>(activity);
        activityLifeListenerManager = new ActivityLifeListenerManager();
        FragmentActivity fragmentActivity = (FragmentActivity) activity;
        activityLifeListenerManager.startActivityLifeListener(fragmentActivity, new ActivityLifeListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onStop() {

            }

            @Override
            public void onDestory() {
                //自动结束
               for(Class<? extends Service> serviceClass : serviceList){
                   stopService(serviceClass);
               }
            }

            @Override
            public void onResume() {

            }
        });
    }

    public  void startService(Class<? extends Service> serviceClass){
        Intent intent = new Intent(activityWeakReference.get(),serviceClass);
        if(serviceList == null){
            serviceList = new ArrayList<>();
        }
        serviceList.add(serviceClass);
        activityWeakReference.get().startService(intent);
    }

    public void stopService(Class<? extends Service> serviceClass){
        Intent intent = new Intent(activityWeakReference.get(),serviceClass);
        serviceList.remove(serviceClass);
        activityWeakReference.get().stopService(intent);
    }

}
