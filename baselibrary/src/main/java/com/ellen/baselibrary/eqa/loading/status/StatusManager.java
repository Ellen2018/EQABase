package com.ellen.baselibrary.eqa.loading.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Loading机制状态管理类
 */
public class StatusManager implements StatusSetting {

    private Set<Status> setStatus;
    private Status currentStatus;
    private StatusChangeListener statusChangeListener;

    public void setStatusChangeListener(StatusChangeListener statusChangeListener) {
        this.statusChangeListener = statusChangeListener;
    }

    @Override
    public void addStatus(Status status) {
        if(setStatus == null){
            setStatus = new HashSet<>();
        }
        setStatus.add(status);
    }

    @Override
    public void addStatus(List<Status> statuses) {
        for(Status status:statuses){
            addStatus(status);
        }
    }

    @Override
    public void removeStatus(Status status) {
       setStatus.remove(status);
    }

    @Override
    public void submitStatus(Status status) {
       if(currentStatus == null){
           currentStatus = status;
           statusActive(null,currentStatus);
       }else {
           Status oldStatus = currentStatus;
           currentStatus = status;
           statusActive(oldStatus,currentStatus);
       }
    }

    private void statusActive(Status oldStatus, Status newStatus) {
        if(statusChangeListener != null){
            statusChangeListener.statusChange(oldStatus,newStatus);
        }
    }

    @Override
    public void cancel() {
        if(statusChangeListener != null){
            statusChangeListener.cancel();
        }
    }
}
