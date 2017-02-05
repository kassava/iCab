package com.shadiz.android.icab.data.repositories.network.driver.models.request.confirm_order;

import com.shadiz.android.icab.data.repositories.network.common.request.BaseModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceModelRequest;

/**
 * Created on 05.02.2017.
 */

public class ConfirmOrderModelRequest extends BaseModelRequest {
    private MessageOrderModel message;

    public MessageOrderModel getMessage() {
        return message;
    }

    public void setMessage(MessageOrderModel message) {
        this.message = message;
    }

    public ConfirmOrderModelRequest(DeviceModelRequest modelRequest, MessageOrderModel message) {
        super(modelRequest);
        this.message = message;
    }
}
