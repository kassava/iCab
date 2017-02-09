package com.shadiz.android.icab.data.repositories.network.common;

/**
 * Created by oldman on 31.01.17.
 */

public class LocationModelRequest {
    double latitude, longitude;
    int precision;
    public LocationModelRequest(double latitude, double longitude, int precision, String geocode) {
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

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
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

    String geocode;

}