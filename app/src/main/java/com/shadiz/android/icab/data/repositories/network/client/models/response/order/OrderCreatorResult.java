package com.shadiz.android.icab.data.repositories.network.client.models.response.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.BaseResult;

/**
 * Created by 31.01.17.
 */

public class OrderCreatorResult {
    @SerializedName("trip_id")
    @Expose
    private Integer tripId;
    @SerializedName("session_id")
    @Expose
    private String sessionId;
    @SerializedName("login")
    @Expose
    private String login;

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
