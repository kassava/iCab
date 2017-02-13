package com.shadiz.android.icab.data.repositories.network.common.response.message_sync;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by oldman on 01.02.17.
 */

public class SyncMessageResult {
    @SerializedName("session_id")
    @Expose
    private String sessionId;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("messages")
    @Expose
    private List<MessagesModel> messages = null;

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

    public List<MessagesModel> getMessages() {
        return messages;
    }

    public void setMessages(List<MessagesModel> messages) {
        this.messages = messages;
    }
}
