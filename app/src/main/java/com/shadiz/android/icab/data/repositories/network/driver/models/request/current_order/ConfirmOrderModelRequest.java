package com.shadiz.android.icab.data.repositories.network.driver.models.request.current_order;

import com.shadiz.android.icab.data.repositories.network.common.request.BaseModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceModelRequest;

/**
 * Created on 05.02.2017.
 */

public class ConfirmOrderModelRequest extends BaseModelRequest {
    private OrderMessageModel message;

    public OrderMessageModel getMessage() {
        return message;
    }

    public void setMessage(OrderMessageModel message) {
        this.message = message;
    }

    public ConfirmOrderModelRequest(DeviceModelRequest modelRequest, OrderMessageModel message) {
        super(modelRequest);
        this.message = message;
    }
}
