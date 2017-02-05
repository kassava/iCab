package com.shadiz.android.icab.data.repositories.network.common;

/**
 * Created by oldman on 31.01.17.
 */

public class RequirementToTheDriverModel {
    private String radius;
    private Integer rateFrom, rateTo, acceptCC;

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
