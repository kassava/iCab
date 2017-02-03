package com.shadiz.android.icab.data.repositories.network.models.responce.client.create_trip;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by 31.01.17.
 */

public class TripResult {

    @SerializedName("session_id")
    @Expose
    private String sessionId;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("trip_id")
    @Expose
    private String tripId;

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

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }
}
