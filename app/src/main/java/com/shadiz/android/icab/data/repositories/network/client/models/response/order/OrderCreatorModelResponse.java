package com.shadiz.android.icab.data.repositories.network.client.models.response.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.BaseResponse;

/**
 * Created by oldman on 01.02.17.
 */
public class OrderCreatorModelResponse extends BaseResponse {
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
