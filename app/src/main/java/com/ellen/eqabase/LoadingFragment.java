package com.ellen.eqabase;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ellen.baselibrary.eqa.base.BaseFragment;
import com.ellen.baselibrary.eqa.loading.LoadingManger;
import com.ellen.baselibrary.eqa.loading.status.Status;
import com.ellen.baselibrary.eqa.loading.status.StatusManager;
import com.ellen.baselibrary.eqa.loading.status.StatusUpdate;

public class LoadingFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout relativeLayout;
    private TextView tvContentView, tvEmptyView, tvLoadingView, tvFailureView;
    private LoadingManger loadingManger;
    private TextView tv1,tv2,tv3,tv4;

    private StatusManager statusManager;
    private Status contentStatus, emptyStatus, loadingStatus, failureStatus;
    private StatusUpdate statusUpdate = new StatusUpdate() {
        @Override
        public void active(Status status) {
            if(status == contentStatus){
                tvContentView.setVisibility(View.VISIBLE);
                tvLoadingView.setVisibility(View.VISIBLE);
            }else if(status == emptyStatus){
                tvEmptyView.setVisibility(View.VISIBLE);
            }else if(status == loadingStatus){
                tvLoadingView.setVisibility(View.VISIBLE);
            }else if(status == failureStatus){
                tvFailureView.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void deActive(Status status) {
            if(status == contentStatus){
                tvContentView.setVisibility(View.GONE);
                tvLoadingView.setVisibility(View.GONE);
            }else if(status == emptyStatus){
                tvEmptyView.setVisibility(View.GONE);
            }else if(status == loadingStatus){
                tvLoadingView.setVisibility(View.GONE);
            }else if(status == failureStatus){
                tvFailureView.setVisibility(View.GONE);
            }
        }
    };

    @Override
    protected void initData() {
        statusManager = new StatusManager();
        contentStatus = new Status();
        contentStatus.setStatusUpdate(statusUpdate);
        statusManager.addStatus(contentStatus);
        statusManager.addStatus(emptyStatus = new Status());
        emptyStatus.setStatusUpdate(statusUpdate);
        statusManager.addStatus(loadingStatus = new Status());
        loadingStatus.setStatusUpdate(statusUpdate);
        statusManager.addStatus(failureStatus = new Status());
        failureStatus.setStatusUpdate(statusUpdate);
        statusManager.submitStatus(contentStatus);
    }

    @Override
    protected void initView() {
        relativeLayout = findViewById(R.id.rl_parent);
        tvContentView = findViewById(R.id.tv_content);
        tvEmptyView = findViewById(R.id.tv_empty);
        tvLoadingView = findViewById(R.id.tv_loading);
        tvFailureView = findViewById(R.id.tv_failure);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        findViewById(R.id.tv5).setOnClickListener(this);
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_loading;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv1:
                statusManager.submitStatus(contentStatus);
                break;
            case R.id.tv2:
                statusManager.submitStatus(emptyStatus);
                break;
            case R.id.tv3:
                statusManager.submitStatus(loadingStatus);
                break;
            case R.id.tv4:
                statusManager.submitStatus(failureStatus);
                break;
            case R.id.tv5:
                statusManager.cancel();
                break;
        }
    }
}
