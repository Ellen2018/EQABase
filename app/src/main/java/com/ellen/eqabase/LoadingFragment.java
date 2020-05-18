package com.ellen.eqabase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;

import com.ellen.baselibrary.eqa.base.BaseFragment;
import com.ellen.baselibrary.eqa.loading.LoadingManger;
import com.ellen.baselibrary.eqa.simpleapi.broadcast.LocalAppBroadcastManager;

public class LoadingFragment extends BaseFragment {

    private RelativeLayout relativeLayout;
    private LoadingManger loadingManger;
    private LocalAppBroadcastManager broadcastManager;

    @Override
    protected void initData() {
        loadingManger = new LoadingManger(getActivity(), relativeLayout, R.layout.view_empty, R.layout.fragment_content);
        loadingManger.showByYouSelf(true,true,false,false);
        broadcastManager = new LocalAppBroadcastManager(getActivity());
        broadcastManager.register("1", new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        });
    }

    @Override
    protected void initView() {
        relativeLayout = findViewById(R.id.rl_parent);
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_loading;
    }
}
