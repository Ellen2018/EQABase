package com.ellen.eqabase;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.ellen.baselibrary.eqa.base.BaseActivity;
import com.ellen.baselibrary.eqa.base.BaseRegister;
import com.ellen.baselibrary.eqa.save.file.AndroidFilePath;
import com.ellen.baselibrary.eqa.simpleapi.ActivityLifeListener.ActivityLifeListener;
import com.ellen.baselibrary.eqa.simpleapi.ActivityLifeListener.ActivityLifeListenerManager;
import com.ellen.baselibrary.eqa.simpleapi.NetListener.NetListener;
import com.ellen.baselibrary.eqa.simpleapi.NetListener.NetManager;
import com.ellen.baselibrary.eqa.uitil.PermissionUtils;
import com.ellen.eqabase.bean.Person;
import com.ellen.eqabase.save.MyLibrary;
import com.ellen.eqabase.save.PersonTable;

import java.io.File;

public class MainActivity extends BaseActivity implements BaseRegister {

    private PermissionUtils permissionUtils;
    private NetManager netManager;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setStatus() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

        //无须自己手动注销，无痕迹注册 & 注销
        netManager = new NetManager(this, new NetListener() {
            @Override
            public void wifiStatus() {
                Log.e("Ellen2018","网络状态:WiFi");
            }

            @Override
            public void flowStatus() {
                Log.e("Ellen2018","网络状态:流量模式");
            }

            @Override
            public void noNetStatus() {
                Log.e("Ellen2018","网络状态:无网络");
            }
        });

        permissionUtils = new PermissionUtils(this);
        permissionUtils.startCheckFileReadWritePermission(0, new PermissionUtils.PermissionCallback() {
            @Override
            public void success() {
                //创建数据库
                File file = new File(AndroidFilePath.getExternalPath(),"a1");
                Log.e("Ellen2018","目录:"+file.getAbsolutePath());
                file.mkdir();
                MyLibrary myLibrary = new MyLibrary(MainActivity.this, file.getAbsolutePath(),"person",1);

                PersonTable personTable = new PersonTable(myLibrary.getWriteDataBase(), Person.class);
                personTable.onCreateTableIfNotExits();
            }

            @Override
            public void failure() {
            }
        });
        ActivityLifeListenerManager activityLifeListenerManager = new ActivityLifeListenerManager();
        activityLifeListenerManager.startActivityLifeListener(this, new ActivityLifeListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onStop() {

            }

            @Override
            public void onDestroy() {

            }

            @Override
            public void onResume() {
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected boolean back() {
        Toast.makeText(this,"点击了返回键",Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionUtils.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }

    @Override
    public void register(View contentView) {
        Log.e("Ellen2018","回调1");
    }

    @Override
    public void unRegister(View contentView) {
        Log.e("Ellen2018","回调2");
    }
}
