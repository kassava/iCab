package com.shadiz.android.icab.data.repositories.network.client.models.request.trip_info;

import com.shadiz.android.icab.data.repositories.network.common.request.BaseModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceModelRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 06.02.17.
 */

public class ClientTripsInfoRequest extends BaseModelRequest{
    private   ArrayList<String> tripFilter;

    public ArrayList<String> getTripFilter() {
        return tripFilter;
    }

    public void setTripFilter(ArrayList<String> tripFilter) {
        this.tripFilter = tripFilter;
    }

    public ClientTripsInfoRequest(DeviceModelRequest modelRequest, ArrayList<String> tripFilter) {
        super(modelRequest);
        this.tripFilter = tripFilter;
    }
}
