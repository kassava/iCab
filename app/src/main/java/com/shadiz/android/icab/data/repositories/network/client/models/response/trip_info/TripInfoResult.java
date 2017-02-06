package com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.BaseResult;

import java.util.List;

/**
 * Created by oldman on 06.02.17.
 */

public class TripInfoResult extends BaseResult {
    @SerializedName("activeTrip")
    @Expose
    List<ActiveTrip> activeTrip;
    public List<ActiveTrip> getActiveTrip() {
        return activeTrip;
    }

    public void setActiveTrip(List<ActiveTrip> activeTrip) {
        this.activeTrip = activeTrip;
    }


}
