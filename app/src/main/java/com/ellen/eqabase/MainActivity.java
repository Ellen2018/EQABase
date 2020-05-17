package com.ellen.eqabase;

import android.view.View;
import android.widget.TextView;

import com.ellen.baselibrary.eqa.base.BaseActivity;
import com.ellen.baselibrary.eqa.loading.LoadingManger;

public class MainActivity extends BaseActivity {

    private LoadingManger loadingManger;
    private TextView textView;

    @Override
    protected View setView() {
        loadingManger = new LoadingManger(this,R.layout.view_empty,R.layout.view_loading,R.layout.activity_main,R.layout.view_failure);
        loadingManger.showContent();
        return loadingManger.getParentView();
    }

    @Override
    protected void setStatus() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        textView = loadingManger.findViewByLoading(R.id.tv_laoding);
        textView.setText("加载尼玛个蛋");
        loadingManger.showContent();
    }

}
