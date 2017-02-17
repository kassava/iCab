package com.shadiz.android.icab.data.repositories.network.common.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by OldMan on 04.02.2017.
 */

public class BaseModelRequest {
    @SerializedName("device_uuid")
    private String device_uuid;
    @SerializedName("login")
    private String login;
    @SerializedName("device_platform")
    private String device_platform;

    public BaseModelRequest(String device_uuid, String login, String device_platform) {
        this.device_uuid = device_uuid;
        this.login = login;
        this.device_platform = device_platform;
    }

    public BaseModelRequest(DeviceRequestModel modelRequest) {
        this.device_uuid = modelRequest.getDevice_uuid();
        this.login = modelRequest.getLogin();
        this.device_platform = modelRequest.getDevice_platform();
    }

    public String getDevice_uuid() {
        return device_uuid;
    }

    public void setDevice_uuid(String device_uuid) {
        this.device_uuid = device_uuid;
    }

    public String getDevice_platform() {
        return device_platform;
    }

    public void setDevice_platform(String device_platform) {
        this.device_platform = device_platform;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
