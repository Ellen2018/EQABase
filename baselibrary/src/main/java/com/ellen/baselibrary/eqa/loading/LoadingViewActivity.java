package com.ellen.baselibrary.eqa.loading;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 带加载View的Activity
 * 封装
 */
public abstract class LoadingViewActivity extends AppCompatActivity {

    protected RelativeLayout rootView;
    protected View loadingView;
    protected View contentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatus();
        init();
    }

    protected void setStatus(){}

    @Override
    public <T extends View> T findViewById(int id) {
        T t = loadingView.findViewById(id);
        if(t == null){
            t = contentView.findViewById(id);
        }
        if(t == null){
            t = super.findViewById(id);
        }
        return t;
    }

    private void init() {
        rootView = new RelativeLayout(this);
        setContentView(rootView);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) rootView.getLayoutParams();
        layoutParams.width = RelativeLayout.LayoutParams.MATCH_PARENT;
        layoutParams.height = RelativeLayout.LayoutParams.MATCH_PARENT;
        rootView.setLayoutParams(layoutParams);

        //内容View
        contentView = getViewByLayoutId(setContentViewLayoutId());
        rootView.addView(contentView);

        //加载的View
        loadingView = getViewByLayoutId(setLoadingViewLayoutId());
        rootView.addView(loadingView);
        
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected void showLoading(boolean isHideContentView){
        loadingView.setVisibility(View.VISIBLE);
        if(isHideContentView){
            contentView.setVisibility(View.GONE);
        }else {
            contentView.setVisibility(View.VISIBLE);
        }
        //更新loadingView ui
        updateLoadingUi();
    }

    protected void showContent(){
        loadingView.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
        updateContentUi();
    }

    private View getViewByLayoutId(int layoutId){
        View view = LayoutInflater.from(this).inflate(layoutId,null);
        return view;
    }

    protected abstract int setLoadingViewLayoutId();
    protected abstract int setContentViewLayoutId();
    protected void updateLoadingUi(){}
    protected void updateContentUi(){}
}
