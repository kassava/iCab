package com.shadiz.android.icab.data.repositories.network.common.request.order;


import com.shadiz.android.icab.data.repositories.network.common.request.BaseModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceModelRequest;

/**
 * Created  on 31.01.17.
 */

public class OrderModelRequest {
    MessageOfOrderModel message;
    String device_uuid, login, device_platform;

    public OrderModelRequest(MessageOfOrderModel message, String device_uuid, String login, String device_platform) {
        this.message = message;
        this.device_uuid = device_uuid;
        this.login = login;
        this.device_platform = device_platform;
    }

    public String getDevice_uuid() {

        return device_uuid;
    }

    public void setDevice_uuid(String device_uuid) {
        this.device_uuid = device_uuid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDevice_platform() {
        return device_platform;
    }

    public void setDevice_platform(String device_platform) {
        this.device_platform = device_platform;
    }

//    public OrderModelRequest(DeviceModelRequest deviceModelRequest, MessageOfOrderModel message) {
//        super(deviceModelRequest);
//        this.message = message;
//    }
    public MessageOfOrderModel getMessage() {
        return message;
    }

    public void setMessage(MessageOfOrderModel message) {
        this.message = message;
    }
}