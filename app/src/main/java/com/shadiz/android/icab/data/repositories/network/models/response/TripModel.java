package com.shadiz.android.icab.data.repositories.network.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by 31.01.17.
 */

public class TripModel {
    @SerializedName("session_id")
    @Expose
    String session_id;

    @SerializedName("login")
    @Expose

    Integer login;
    @SerializedName("trip_id")
    @Expose
    Integer trip_id;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public Integer getLogin() {
        return login;
    }

    public void setLogin(Integer login) {
        this.login = login;
    }

    public Integer getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(Integer trip_id) {
        this.trip_id = trip_id;
    }
}
