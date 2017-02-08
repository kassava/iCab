package com.shadiz.android.icab.data.repositories.network.driver.models.response.trip_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info.TripInfoResult;
import com.shadiz.android.icab.data.repositories.network.common.BaseResponse;

/**
 * Created by oldman on 07.02.17.
 */

public class DriverTripResponse extends BaseResponse {
    @SerializedName("result")
    @Expose
    private TripInfoResult result;
   

}
