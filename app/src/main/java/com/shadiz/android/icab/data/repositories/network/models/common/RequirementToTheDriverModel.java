package com.shadiz.android.icab.data.repositories.network.models.common;

/**
 * Created by oldman on 31.01.17.
 */

public class RequirementToTheDriverModel {
    private Integer radius, rateFrom, rateTo, acceptCC;

    public RequirementToTheDriverModel(Integer radius, Integer rateFrom, Integer rateTo, Integer acceptCC) {
        this.radius = radius;
        this.rateFrom = rateFrom;
        this.rateTo = rateTo;
        this.acceptCC = acceptCC;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
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
