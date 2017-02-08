package com.shadiz.android.icab.data.repositories.network.common.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by oldman on 31.01.17.
 */

public class LocationModelResponse {
    @SerializedName("longitude")
    @Expose
    private double longitude;
    @SerializedName("latitude")
    @Expose
    private double latitude;
    @SerializedName("precision")
    @Expose
    private double precision;
    @SerializedName("bearing")
    @Expose
    private double bearing;
    @SerializedName("distance")
    @Expose
    private Integer distance;

    public LocationModelResponse(double longitude, double latitude, double precision, double bearing, Integer distance) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.precision = precision;
        this.bearing = bearing;
        this.distance = distance;
    }

    public double getLongitude() {

        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public double getBearing() {
        return bearing;
    }

    public void setBearing(double bearing) {
        this.bearing = bearing;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
