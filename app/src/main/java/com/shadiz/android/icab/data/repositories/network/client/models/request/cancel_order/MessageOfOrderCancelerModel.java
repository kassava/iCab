package com.shadiz.android.icab.data.repositories.network.client.models.request.cancel_order;

import com.shadiz.android.icab.data.repositories.network.common.request.BaseModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceModelRequest;

/**
 * Created by OldMan on 04.02.2017.
 */

public class MessageOfOrderCancelerModel extends BaseModelRequest {
    private String type, code2;
    private int code1, code3, code4;

    public MessageOfOrderCancelerModel(DeviceModelRequest deviceModelRequest, String type, String code2, int code1, int code3, int code4) {
        super(deviceModelRequest.getDevice_uuid(),
                deviceModelRequest.getLogin(),
                deviceModelRequest.getDevice_platform()
        );
        this.type = type;
        this.code2 = code2;
        this.code1 = code1;
        this.code3 = code3;
        this.code4 = code4;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public int getCode1() {
        return code1;
    }

    public void setCode1(int code1) {
        this.code1 = code1;
    }

    public int getCode3() {
        return code3;
    }

    public void setCode3(int code3) {
        this.code3 = code3;
    }

    public int getCode4() {
        return code4;
    }

    public void setCode4(int code4) {
        this.code4 = code4;
    }
}
