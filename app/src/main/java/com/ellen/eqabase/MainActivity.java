package com.ellen.eqabase;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ellen.baselibrary.eqa.loading.LoadingManger;
import com.ellen.baselibrary.eqa.loading.UpdateUiCallback;

public class MainActivity extends AppCompatActivity {

    private LoadingManger loadingManger;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadingManger = new LoadingManger(this,R.layout.view_empty,R.layout.view_loading,R.layout.activity_main,R.layout.view_failure);
        loadingManger.setUpdateUiCallback(new UpdateUiCallback() {
            @Override
            public void updateLoadingViewUi() {
                textView.setText("加载中...尼玛个锤子");
                Log.e("Ellen2018","更新加载视图");
            }

            @Override
            public void updateEmptyViewUi() {
                Log.e("Ellen2018","更新空视图");
            }

            @Override
            public void updateContentViewUi() {
                Log.e("Ellen2018","更新内容视图");
            }

            @Override
            public void updateFailureViewUi() {

            }

        });
        setContentView(loadingManger.getParentView());
        textView = loadingManger.findViewByLoading(R.id.tv_laoding);
        loadingManger.showContent();
    }
}
