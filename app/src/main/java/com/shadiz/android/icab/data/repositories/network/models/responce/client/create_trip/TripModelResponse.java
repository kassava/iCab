package com.shadiz.android.icab.data.repositories.network.models.responce.client.create_trip;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.models.common.BaseResponse;

/**
 * Created by oldman on 01.02.17.
 */
public class TripModelResponse extends BaseResponse {
    @SerializedName("result")
    @Expose
    private TripResult result;

    public TripResult getResult() {
        return result;
    }

    public void setResult(TripResult result) {
        this.result = result;
    }
}
