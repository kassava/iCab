package com.shadiz.android.icab.data.realm.models.trip;

import com.shadiz.android.icab.data.realm.models.RealmDriverInfoModel;

import io.realm.RealmObject;

/**
 * Created on 11.02.2017.
 */

public class RealmClientTripModel extends RealmObject {

    private String currentDiscount;
    private String orderTime;
    private RealmDriverInfoModel driverInfo;

    public String getCurrentDiscount() {
        return currentDiscount;
    }

    public void setCurrentDiscount(String currentDiscount) {
        this.currentDiscount = currentDiscount;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public RealmDriverInfoModel getDriverInfo() {
        return driverInfo;
    }

    public void setDriverInfo(RealmDriverInfoModel driverInfo) {
        this.driverInfo = driverInfo;
    }
}
