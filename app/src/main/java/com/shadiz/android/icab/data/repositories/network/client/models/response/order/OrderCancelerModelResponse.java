package com.shadiz.android.icab.data.repositories.network.client.models.response.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.BaseResponse;
import com.shadiz.android.icab.data.repositories.network.common.response.NewIdOrderResult;

/**
 * Created by OldMan on 05.02.2017.
 */

public class OrderCancelerModelResponse extends BaseResponse {
    @SerializedName("result")
    @Expose
    private NewIdOrderResult result;

    public NewIdOrderResult getResult() {
        return result;
    }

    public void setResult(NewIdOrderResult result) {
        this.result = result;
    }
}
