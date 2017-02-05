package com.shadiz.android.icab.data.repositories.network.client.models.request.create_order;


import com.shadiz.android.icab.data.repositories.network.common.request.BaseModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceModelRequest;

/**
 * Created by oldman on 31.01.17.
 */

public class CreateOrderModelRequest extends BaseModelRequest {
    private MessageOfOrderModel message;

    public CreateOrderModelRequest(String device_uuid, String login, String device_platform, MessageOfOrderModel message) {
        super(device_uuid, login, device_platform);
        this.message = message;
    }
    public CreateOrderModelRequest(DeviceModelRequest deviceModelRequest, MessageOfOrderModel message) {
        super(deviceModelRequest);
        this.message = message;
    }
    public MessageOfOrderModel getMessage() {
        return message;
    }

    public void setMessage(MessageOfOrderModel message) {
        this.message = message;
    }
}
