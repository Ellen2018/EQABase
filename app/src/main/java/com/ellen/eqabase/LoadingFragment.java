package com.ellen.eqabase;

import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ellen.baselibrary.eqa.base.BaseFragment;
import com.ellen.baselibrary.eqa.loading.LoadingCallback;
import com.ellen.baselibrary.eqa.loading.LoadingManger;
import com.ellen.baselibrary.eqa.loading.ShowBean;

public class LoadingFragment extends BaseFragment {

    private RelativeLayout relativeLayout;
    private TextView tvContentView,tvEmptyView,tvLoadingView,tvFailureView;
    private LoadingManger loadingManger;

    @Override
    protected void initData() {
        loadingManger = new LoadingManger(getActivity(),tvContentView,tvEmptyView,tvLoadingView,tvFailureView);
        loadingManger.setLoadingCallback(new LoadingCallback() {
            @Override
            public void show(ShowBean showBean) {
                if(showBean.isShowContent()){
                    Log.e("Ellen2018","显示内容");
                }
                if(showBean.isShowEmpty()){
                    Log.e("Ellen2018","显示空视图");
                }
                if(showBean.isShowLoading()){
                    Log.e("Ellen2018","显示加载视图");
                }
                if(showBean.isShowFailure()){
                    Log.e("Ellen2018","显示失败视图");
                }
            }
        });
        loadingManger.showLoading();
    }

    @Override
    protected void initView() {
        relativeLayout = findViewById(R.id.rl_parent);
        tvContentView = findViewById(R.id.tv_content);
        tvEmptyView = findViewById(R.id.tv_empty);
        tvLoadingView = findViewById(R.id.tv_loading);
        tvFailureView = findViewById(R.id.tv_failure);
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_loading;
    }
}
