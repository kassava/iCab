package com.shadiz.android.icab.data.repositories.network.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by OldMan on 05.02.2017.
 */

public class BaseResult {
    @SerializedName("session_id")
    @Expose
    private String sessionId;
    @SerializedName("login")
    @Expose
    private String login;

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
