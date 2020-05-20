package com.ellen.baselibrary.eqa.loading.status;

public interface StatusChangeListener {

    void statusChange(Status oldStatus,Status newStatus);
    void cancel();

}
