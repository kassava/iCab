package com.shadiz.android.icab.data.repositories.network.models.request;

/**
 * Created by oldman on 31.01.17.
 */

public class LocationModel {
    double latitude, longitude, precision;

    public LocationModel(double latitude, double longitude, double precision, String geocode) {
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

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
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
