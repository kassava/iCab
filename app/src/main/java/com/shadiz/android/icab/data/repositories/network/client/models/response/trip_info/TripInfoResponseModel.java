package com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.BaseResponse;

/**
 * Created by oldman on 06.02.17.
 */

public class TripInfoResponseModel extends BaseResponse {
    @SerializedName("result")
    @Expose
    private TripInfoResultModel result;

    public TripInfoResultModel getResult() {
        return result;
    }

    public void setResult(TripInfoResultModel result) {
        this.result = result;
    }
}
