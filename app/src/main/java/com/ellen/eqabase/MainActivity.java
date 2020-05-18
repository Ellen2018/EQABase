package com.ellen.eqabase;

import android.widget.Toast;

import com.ellen.baselibrary.eqa.base.BaseActivity;

public class MainActivity extends BaseActivity {

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

    }

    @Override
    protected boolean back() {
        Toast.makeText(this,"点击了返回键",Toast.LENGTH_SHORT).show();
        return true;
    }
}
