package com.ellen.baselibrary.eqa.loading;

public interface LoadingCallback {
    /**
     * 更新loading ui
     */
    void updateLoadingViewUi();

    /**
     * 更新empty ui
     */
    void updateEmptyViewUi();

    /**
     * 更新 content ui
     */
    void updateContentViewUi();

    /**
     * 更新失败视图
     */
    void updateFailureViewUi();

    /**
     * 隐藏content view时回调
     */
    void hideContentView();

    /**
     * 隐藏 loading view时回调
     */
    void hideLoadingView();

    /**
     * 隐藏空视图时回调
     */
    void hideEmptyView();

    /**
     * 隐藏失败视图
     */
    void hideFailureView();
}
