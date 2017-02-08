package com.shadiz.android.icab.data.repositories.network.driver.models.request.trip_info;

import com.shadiz.android.icab.data.repositories.network.common.request.BaseModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceModelRequest;

import java.util.ArrayList;

/**
 * Created on 07.02.17.
 */

public class DriverTripInfoRequest extends BaseModelRequest {
    private ArrayList<String> tripFilter;
    private Integer tripClientInRadiusMeters;
    private Integer tripMaxDistanceMeters;

    public DriverTripInfoRequest(DeviceModelRequest modelRequest, ArrayList<String> tripFilter, Integer tripClientInRadiusMeters, Integer tripMaxDistanceMeters) {
        super(modelRequest);
        this.tripFilter = tripFilter;
        this.tripClientInRadiusMeters = tripClientInRadiusMeters;
        this.tripMaxDistanceMeters = tripMaxDistanceMeters;
    }

    public Integer getTripMaxDistanceMeters() {
        return tripMaxDistanceMeters;
    }

    public ArrayList<String> getTripFilter() {
        return tripFilter;
    }

    public void setTripFilter(ArrayList<String> tripFilter) {
        this.tripFilter = tripFilter;
    }

    public void setTripMaxDistanceMeters(Integer tripMaxDistanceMeters) {
        this.tripMaxDistanceMeters = tripMaxDistanceMeters;
    }

    public Integer getTripClientInRadiusMeters() {
        return tripClientInRadiusMeters;
    }

    public void setTripClientInRadiusMeters(Integer tripClientInRadiusMeters) {
        this.tripClientInRadiusMeters = tripClientInRadiusMeters;
    }



}
