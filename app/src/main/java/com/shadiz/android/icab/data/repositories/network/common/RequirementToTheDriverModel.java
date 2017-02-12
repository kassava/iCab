package com.shadiz.android.icab.data.repositories.network.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by oldman on 31.01.17.
 */

public class RequirementToTheDriverModel {
    @SerializedName("acceptCC")
    @Expose
    private Integer acceptCC;
    @SerializedName("radius")
    @Expose
    private String radius;
    @SerializedName("rateFrom")
    @Expose
    private Integer rateFrom;
    @SerializedName("rateTo")
    @Expose
    private Integer rateTo;

    public RequirementToTheDriverModel(String radius, Integer rateFrom, Integer rateTo, Integer acceptCC) {
        this.radius = radius;
        this.rateFrom = rateFrom;
        this.rateTo = rateTo;
        this.acceptCC = acceptCC;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public Integer getRateFrom() {
        return rateFrom;
    }

    public void setRateFrom(Integer rateFrom) {
        this.rateFrom = rateFrom;
    }

    public Integer getRateTo() {
        return rateTo;
    }

    public void setRateTo(Integer rateTo) {
        this.rateTo = rateTo;
    }

    public Integer getAcceptCC() {
        return acceptCC;
    }

    public void setAcceptCC(Integer acceptCC) {
        this.acceptCC = acceptCC;
    }
}
