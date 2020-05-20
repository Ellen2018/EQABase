package com.ellen.baselibrary.eqa.loading.status;

/**
 * 状态
 */
public class Status{
    /**
     * 状态值
     */
    private int satusCode;

    public StatusUpdate statusUpdate;

    public int getSatusCode() {
        return satusCode;
    }

    public void setSatusCode(int satusCode) {
        this.satusCode = satusCode;
    }

    public void setStatusUpdate(StatusUpdate statusUpdate) {
        this.statusUpdate = statusUpdate;
    }


    public void active() {
        if (statusUpdate != null) {
            statusUpdate.active(this);
        }
    }

    public void deActive() {
        if (statusUpdate != null) {
            statusUpdate.deActive(this);
        }
    }
}
