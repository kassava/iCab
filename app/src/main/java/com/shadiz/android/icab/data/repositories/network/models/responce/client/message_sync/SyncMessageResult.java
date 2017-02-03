package com.shadiz.android.icab.data.repositories.network.models.responce.client.message_sync;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by oldman on 01.02.17.
 */

public class SyncMessageResult {
    @SerializedName("session_id")
    @Expose
    private String session_id;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("messages")
    @Expose
    private List<MessagesModel>  messages;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<MessagesModel> getMessageModel() {
        return messages;
    }

    public void setMessageModel(List<MessagesModel> messages) {
        this.messages = messages;
    }
}
