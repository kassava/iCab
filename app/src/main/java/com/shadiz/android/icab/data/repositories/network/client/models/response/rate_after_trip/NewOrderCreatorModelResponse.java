package com.shadiz.android.icab.data.repositories.network.client.models.response.rate_after_trip;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.BaseResponse;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.OrderCreatorResult;

/**
 * Created by OldMan on 05.02.2017.
 */

public class NewOrderCreatorModelResponse extends BaseResponse {
    @SerializedName("result")
    @Expose
    private OrderCreatorResult result;

    public OrderCreatorResult getResult() {
        return result;
    }

    public void setResult(OrderCreatorResult result) {
        this.result = result;
    }
}
