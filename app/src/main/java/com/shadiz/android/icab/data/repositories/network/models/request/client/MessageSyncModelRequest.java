package com.shadiz.android.icab.data.repositories.network.models.request.client;

/**
 * Created by oldman on 01.02.17.
 */

public class MessageSyncModelRequest {
    String date_from, device_uuid, login, device_platform;

    /**
     *
     * @param date_from - дата с которой начать поиск новых сообщений, должна быть в SQL стандарте в UTC зоне
     * @param device_uuid
     * @param login
     * @param device_platform
     */
    public MessageSyncModelRequest(String date_from, String device_uuid, String login, String device_platform) {
        this.date_from = date_from;
        this.device_uuid = device_uuid;
        this.login = login;
        this.device_platform = device_platform;
    }

    public String getDate_from() {

        return date_from;
    }

    public void setDate_from(String date_from) {
        this.date_from = date_from;
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
}
