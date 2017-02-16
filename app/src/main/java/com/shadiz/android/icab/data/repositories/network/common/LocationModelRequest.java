package com.shadiz.android.icab.data.repositories.network.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by oldman on 31.01.17.
 */

public class LocationModelRequest {
    String geocode;
    String latitude;
    String longitude;
    String precision;

    public LocationModelRequest(String latitude, String longitude, String precision, String geocode) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.precision = precision;
        this.geocode = geocode;
    }

    public String getGeocode() {
        return geocode;
    }

    public void setGeocode(String geocode) {
        this.geocode = geocode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }
}
