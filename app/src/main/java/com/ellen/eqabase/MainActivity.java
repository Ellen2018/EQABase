package com.ellen.eqabase;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.ellen.baselibrary.eqa.base.BaseActivity;
import com.ellen.baselibrary.eqa.save.file.AndroidFailePath;
import com.ellen.baselibrary.eqa.uitil.PermissionUtils;

public class MainActivity extends BaseActivity {

    private PermissionUtils permissionUtils;

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
        permissionUtils = new PermissionUtils(this);
        permissionUtils.startCheckFileReadWritePermission(0, new PermissionUtils.PermissionCallback() {
            @Override
            public void success() {
                Log.e("Ellen2018", "外部存储目录:"+AndroidFailePath.getExternalPath());
                Log.e("Ellen2018", "内部存储目录:"+AndroidFailePath.getInternalPath(MainActivity.this));
            }

            @Override
            public void failure() {

            }
        });
    }

    @Override
    protected boolean back() {
        Toast.makeText(this,"点击了返回键",Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionUtils.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }
}
