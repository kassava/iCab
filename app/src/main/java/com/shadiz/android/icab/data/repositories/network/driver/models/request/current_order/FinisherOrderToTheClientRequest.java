package com.shadiz.android.icab.data.repositories.network.driver.models.request.current_order;

import com.shadiz.android.icab.data.repositories.network.common.request.BaseModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceModelRequest;

/**
 * Created by oldman on 08.02.17.
 */

public class FinisherOrderToTheClientRequest extends BaseModelRequest {

    private MessageTaxiSetOffModel messageTaxiSetOffModel;

    public MessageTaxiSetOffModel getMessage() {
        return messageTaxiSetOffModel;
    }

    public void setMessage(MessageTaxiSetOffModel messageTaxiSetOffModel) {
        this.messageTaxiSetOffModel = messageTaxiSetOffModel;
    }

    /**
     * driverServer_taxiSetOffToTheClient_agree
     * @param modelRequest
     * @param messageTaxiSetOffModel
     */
    public FinisherOrderToTheClientRequest(DeviceModelRequest modelRequest, MessageTaxiSetOffModel messageTaxiSetOffModel) {
        super(modelRequest);
        this.messageTaxiSetOffModel = messageTaxiSetOffModel;
    }
}
