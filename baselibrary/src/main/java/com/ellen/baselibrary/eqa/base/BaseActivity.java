package com.ellen.baselibrary.eqa.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected View rootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatus();
        if(setLayoutId() == -1){
            rootView = setView();
            setContentView(rootView);
        }else {
            setContentView(setLayoutId());
        }
        //是否支持ButterKnife接口
        if(this instanceof ButterKnifeInterface){
            ButterKnifeInterface butterKnifeInterface = (ButterKnifeInterface) this;
            butterKnifeInterface.initButterKnife();
        }
        initView();
        initData();
        //横竖屏设置
        if(isSetVerticalScreen() != null){
            if(isSetVerticalScreen()){
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        }
    }

    @Override
    public void finish() {
        super.finish();
    }

    //设置状态栏
    protected abstract void setStatus();
    //设置布局id
    protected int setLayoutId(){
        return -1;
    }
    protected View setView(){
        return null;
    }
    protected abstract void initView();
    protected abstract void initData();
    //设置横竖屏,null->跟随系统,true->横屏,false->竖屏
    protected Boolean isSetVerticalScreen(){
        return null;
    }

    protected String getTag(){
        return getClass().getSimpleName();
    }

    //支持ButterKnife的接口
    public interface ButterKnifeInterface {
        void initButterKnife();
    }

    protected boolean back(){
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(back()){
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
