package com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.BaseResponse;

/**
 * Created by oldman on 06.02.17.
 */

public class TripInfoResponse extends BaseResponse {
    @SerializedName("result")
    @Expose
    private TripInfoResult result;

    public TripInfoResult getResult() {
        return result;
    }

    public void setResult(TripInfoResult result) {
        this.result = result;
    }
}