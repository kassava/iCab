package com.shadiz.android.icab.data.repositories.network.models.responce.client.message_sync;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.models.common.BaseResponse;

/**
 * Created by oldman on 02.02.17.
 */

public class SyncMessageModelResponce extends BaseResponse {
    @SerializedName("result")
    @Expose
    private SyncMessageResult result;

    public SyncMessageResult getResult() {
        return result;
    }

    public void setResult(SyncMessageResult result) {
        this.result = result;
    }
}
