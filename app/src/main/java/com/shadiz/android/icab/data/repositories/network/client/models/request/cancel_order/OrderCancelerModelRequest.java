package com.shadiz.android.icab.data.repositories.network.client.models.request.cancel_order;

import com.shadiz.android.icab.data.repositories.network.common.request.BaseModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceModelRequest;

/**
 * Created by OldMan on 04.02.2017.
 */

public class OrderCancelerModelRequest extends BaseModelRequest {
    private MessageOfOrderCancelerModel message;

    public MessageOfOrderCancelerModel getMessage() {
        return message;
    }

    public void setMessage(MessageOfOrderCancelerModel message) {
        this.message = message;
    }

    public OrderCancelerModelRequest(DeviceModelRequest deviceModelRequest, MessageOfOrderCancelerModel message) {
        super(deviceModelRequest);
        this.message = message;
    }
}