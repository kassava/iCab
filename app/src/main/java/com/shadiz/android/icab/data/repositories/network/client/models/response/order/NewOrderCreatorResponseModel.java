package com.shadiz.android.icab.data.repositories.network.client.models.response.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.BaseResponse;

/**
 * Created on 01.02.17.
 */
public class NewOrderCreatorResponseModel {
    @SerializedName("result")
    @Expose
    private OrderCreatorResult result;
    @SerializedName("status")
    @Expose
    private String status;

    public OrderCreatorResult getResult() {
        return result;
    }

    public void setResult(OrderCreatorResult result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
