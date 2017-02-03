package com.shadiz.android.icab.data.repositories.network.models.request.client;

import com.shadiz.android.icab.data.repositories.network.models.request.common.CodesModel;

/**
 * Created on 31.01.17.
 */

public class MessageModel {
    private String user_from, user_to, type, appear_type, message_body;
    private CodesModel codesModel;

    public MessageModel(String user_from, String user_to, String type, String appear_type, String message_body, CodesModel codes) {
        this.user_from = user_from;
        this.user_to = user_to;
        this.type = type;
        this.appear_type = appear_type;
        this.message_body = message_body;
        this.codesModel = codes;
    }

    public CodesModel getCodes() {
        return codesModel;
    }

    public void setCodes(CodesModel model) {
        this.codesModel = model;
    }

    public String getUser_from() {
        return user_from;
    }

    public void setUser_from(String user_from) {
        this.user_from = user_from;
    }

    public String getUser_to() {
        return user_to;
    }

    public void setUser_to(String user_to) {
        this.user_to = user_to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAppear_type() {
        return appear_type;
    }

    public void setAppear_type(String appear_type) {
        this.appear_type = appear_type;
    }

    public String getMessage_body() {
        return message_body;
    }

    public void setMessage_body(String message_body) {
        this.message_body = message_body;
    }

}
