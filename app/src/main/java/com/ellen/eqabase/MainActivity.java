package com.ellen.eqabase;


import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.ellen.baselibrary.eqa.loading.LoadingViewActivity;

public class MainActivity extends LoadingViewActivity {

    private TextView tvLoading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLoading(true);
    }

    @Override
    protected void initData() {
        tvLoading.setText("尼玛加载中...");
    }

    @Override
    protected void initView() {
     tvLoading = findViewById(R.id.tv_laoding);
    }

    @Override
    protected int setLoadingViewLayoutId() {
        return R.layout.loading_view;
    }

    @Override
    protected int setContentViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void updateLoadingUi() {
        super.updateLoadingUi();
        tvLoading.setText("加载中..."+System.currentTimeMillis());
    }
}
