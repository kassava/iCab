package com.shadiz.android.icab.data.repositories.network.models.request.client;


/**
 * Created by oldman on 31.01.17.
 */

public class TripModelRequest {
    private String device_uuid, login, device_platform;
    private MessageModel message;

    public TripModelRequest(String device_uuid, String login, String device_platform, MessageModel message) {
        this.device_uuid = device_uuid;
        this.login = login;
        this.device_platform = device_platform;
        this.message = message;
    }

    public MessageModel getMessage() {

        return message;
    }

    public void setMessage(MessageModel message) {
        this.message = message;
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

    public String getDevice_uuid() {
        return device_uuid;
    }

    public void setDevice_uuid(String device_uuid) {
        this.device_uuid = device_uuid;
    }


}
