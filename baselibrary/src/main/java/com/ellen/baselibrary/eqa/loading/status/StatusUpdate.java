package com.ellen.baselibrary.eqa.loading.status;

public interface StatusUpdate {
    /**
     * 状态激活时调用
     */
    void active(Status status);

    /**
     * 状态反激活时调用
     */
    void deActive(Status status);
}
