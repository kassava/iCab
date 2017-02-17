package com.shadiz.android.icab.data.repositories.network.common.request.order;


import com.shadiz.android.icab.data.repositories.network.common.BaseResponse;
import com.shadiz.android.icab.data.repositories.network.common.request.BaseModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceRequestModel;

/**
 * Created  on 31.01.17.
 */

public class OrderModelRequest extends BaseModelRequest {
    MessageOfOrderModel message;

    public OrderModelRequest(DeviceRequestModel modelRequest, MessageOfOrderModel message) {
        super(modelRequest);
        this.message = message;
    }

    public MessageOfOrderModel getMessage() {
        return message;
    }

    public void setMessage(MessageOfOrderModel message) {
        this.message = message;
    }
}