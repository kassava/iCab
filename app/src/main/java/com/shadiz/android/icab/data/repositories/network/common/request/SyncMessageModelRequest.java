package com.shadiz.android.icab.data.repositories.network.common.request;

import com.shadiz.android.icab.data.repositories.network.common.request.BaseModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceModelRequest;

/**
 * Created by oldman on 01.02.17.
 */

public class SyncMessageModelRequest extends BaseModelRequest {
    String date_from;
    /**
     * @param date_from       - дата с которой начать поиск новых сообщений, должна быть в SQL стандарте в UTC зоне
     * @param device_uuid
     * @param login
     * @param device_platform
     */
    public SyncMessageModelRequest(String date_from, String device_uuid, String login, String device_platform) {
        super(device_uuid, login, device_platform);
        this.date_from = date_from;
    }
    public SyncMessageModelRequest(DeviceModelRequest deviceModelRequest, String date_from) {
        super(deviceModelRequest);
        this.date_from = date_from;
    }
    public String getDate_from() {
        return date_from;
    }
    public void setDate_from(String date_from) {
        this.date_from = date_from;
    }
}
