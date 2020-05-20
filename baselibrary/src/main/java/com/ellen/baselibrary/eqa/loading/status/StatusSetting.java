package com.ellen.baselibrary.eqa.loading.status;

import java.util.List;

public interface StatusSetting {

    void addStatus(Status status);
    void addStatus(List<Status> statuses);
    void removeStatus(Status status);
    void submitStatus(Status status);
    void cancel();

}
