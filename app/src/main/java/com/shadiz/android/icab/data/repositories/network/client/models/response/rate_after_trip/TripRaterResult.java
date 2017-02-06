package com.shadiz.android.icab.data.repositories.network.client.models.response.rate_after_trip;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.BaseResult;

/**
 * Created by OldMan on 05.02.2017.
 */

public class TripRaterResult extends BaseResult {
    @SerializedName("newId")
    @Expose
    Integer newId;
    @SerializedName("duration")
    @Expose
    Integer  duration;
    @SerializedName("mileage")
    @Expose
    Integer  mileage;
    @SerializedName("cost")
    @Expose
    Float cost;
    @SerializedName("currency")
    @Expose
    String currency;

    /**
     * @param newId    - id поездки
     * @param duration -  длительность поездки в секундах
     * @param mileage  - длинна поездки в метрах
     * @param cost     -  стоимость поездки
     * @param currency - валюта стоимости поездки
     */
    public TripRaterResult(Integer newId, Integer duration, Integer mileage, Float cost, String currency) {
        this.newId = newId;
        this.duration = duration;
        this.mileage = mileage;
        this.cost = cost;
        this.currency = currency;
    }

    public Integer getNewId() {

        return newId;
    }

    public void setNewId(Integer newId) {
        this.newId = newId;
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

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
