package com.shadiz.android.icab.data.repositories.network.common.request.order;

import com.shadiz.android.icab.data.repositories.network.common.request.BaseModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.order.CancelOrderMessageModel;

/**
 * Created by oldman on 08.02.17.
 */

public class CancelOrderRequest extends BaseModelRequest {

    private CancelOrderMessageModel messageTaxiSetOffModel;

    public CancelOrderMessageModel getMessage() {
        return messageTaxiSetOffModel;
    }

    public void setMessage(CancelOrderMessageModel messageTaxiSetOffModel) {
        this.messageTaxiSetOffModel = messageTaxiSetOffModel;
    }

    /**
     * driverServer_taxiSetOffToTheClient_agree
     * @param modelRequest
     * @param cancelOrderMessageModel
     */
    public CancelOrderRequest(DeviceModelRequest modelRequest, CancelOrderMessageModel cancelOrderMessageModel) {
        super(modelRequest);
        this.messageTaxiSetOffModel = cancelOrderMessageModel;
    }
}
