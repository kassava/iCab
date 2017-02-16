package com.shadiz.android.icab.data.repositories.network.common.request.order;

import com.shadiz.android.icab.data.repositories.network.driver.models.request.current_order.OrderMessageModel;

/**
 * Created on 09.02.17.
 */

public class CancelOrderMessageModel extends OrderMessageModel {
    private String code2;

    /**
     * @param type        - driverServer_userWantsToOrderTaxi_agree/driverServer_userWantsToOrderTaxi_disagree/clientServer_userWantsToCancelOrder_agree
     * @param code1
     * @param appear_type
     * @param user_to
     */
    public CancelOrderMessageModel(String type, int code1, String code2, int appear_type, int user_to) {
        super(type, code1, appear_type, user_to);
        this.code2 =code2;

    }
    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

}
