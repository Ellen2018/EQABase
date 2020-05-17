package com.ellen.eqabase;

import android.widget.RelativeLayout;

import com.ellen.baselibrary.eqa.base.BaseFragment;
import com.ellen.baselibrary.eqa.loading.LoadingManger;

public class LoadingFragment extends BaseFragment {

    private RelativeLayout relativeLayout;
    private LoadingManger loadingManger;

    @Override
    protected void initData() {
        loadingManger = new LoadingManger(getActivity(),relativeLayout,R.layout.view_empty,R.layout.fragment_content);
        loadingManger.showContent();
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
