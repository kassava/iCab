package com.shadiz.android.icab.data.repositories.network.client.models.request.rate_order;

import com.shadiz.android.icab.data.repositories.network.common.request.BaseModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceModelRequest;

/**
 * Created on 05.02.2017.
 */

public class TripRaterRequest extends BaseModelRequest {
    private MessageOfTripRaterModel message;

    public MessageOfTripRaterModel getMessage() {
        return message;
    }

    public void setMessage(MessageOfTripRaterModel message) {
        this.message = message;
    }

    public TripRaterRequest(DeviceModelRequest modelRequest, MessageOfTripRaterModel message) {
        super(modelRequest);
        this.message = message;

    }
}
