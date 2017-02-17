package com.shadiz.android.icab.data.repositories.network.client.models.request.trip_info;

import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.request.BaseModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceRequestModel;

import java.util.ArrayList;

/**
 * Created on 06.02.17.
 */

public class ClientTripsInfoRequest extends BaseModelRequest {
    @SerializedName("tripFilter")
    private ArrayList<String> tripFilter;

    public ArrayList<String> getTripFilter() {
        return tripFilter;
    }

    public void setTripFilter(ArrayList<String> tripFilter) {
        this.tripFilter = tripFilter;
    }

    public ClientTripsInfoRequest(DeviceRequestModel modelRequest, ArrayList<String> tripFilter) {
        super(modelRequest);
        this.tripFilter = tripFilter;
    }

//    public String getFilterList() {
//        String filter = null;
////        for (String s : getTripFilter())
////            if (filter == null)
////                filter = "[" + s;
////            else
////                filter += ", " + s;
////        "trip_filter": [
////        "activeTrip",
////                "postponedTrips"
////        ],
//        Gson gson = new Gson();
//        Type type = new TypeToken<List<Task>>() {}.getType();
//
//        return    gson.toJson(getTripFilter(), type);
//    }
}
