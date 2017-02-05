package com.shadiz.android.icab.data.repositories.network.client.models.response.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.BaseOrderResult;

/**
 * Created by 31.01.17.
 */

public class OrderCreatorResult extends BaseOrderResult {
    @SerializedName("trip_id")
    @Expose
    private String tripId;

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }
}
