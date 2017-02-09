package com.shadiz.android.icab.data.repositories.network.client.models.response.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.BaseResult;

/**
 * Created by 31.01.17.
 */

public class OrderCreatorResult extends BaseResult {
    @SerializedName("newId")
    @Expose
    private Integer newId;
    @SerializedName("currency")
    @Expose
    private Integer currency;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("mileage")
    @Expose
    private Integer mileage;

    public Integer getNewId() {
        return newId;
    }

    public void setNewId(Integer newId) {
        this.newId = newId;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }
}
