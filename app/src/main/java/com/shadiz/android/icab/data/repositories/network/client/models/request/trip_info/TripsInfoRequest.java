package com.shadiz.android.icab.data.repositories.network.client.models.request.trip_info;

import com.shadiz.android.icab.data.repositories.network.common.request.BaseModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceModelRequest;

import java.util.List;

/**
 * Created on 06.02.17.
 */

public class TripsInfoRequest extends BaseModelRequest{
    List<String> tripFilter;

    public List<String> getTripFilter() {
        return tripFilter;
    }

    public void setTripFilter(List<String> tripFilter) {
        this.tripFilter = tripFilter;
    }

    public TripsInfoRequest(DeviceModelRequest modelRequest, List<String> tripFilter) {
        super(modelRequest);
        this.tripFilter = tripFilter;
    }
}
