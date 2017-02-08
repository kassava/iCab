package com.shadiz.android.icab.data.repositories.network.client.models.request.create_order;

import com.shadiz.android.icab.data.repositories.network.common.model.CodesModel;

/**
 * Created on 31.01.17.
 */

public class MessageOfOrderModel {
    private String type, message_body;
    private Integer user_from;
    private Integer user_to;
    private Integer appear_type;
    private CodesModel codesModel;

    /**
     *
     * @param type
     * @param message_body
     * @param user_from
     * @param user_to
     * @param appear_type
     * @param codesModel
     */
    public MessageOfOrderModel(String type, String message_body, Integer user_from, Integer user_to, Integer appear_type, CodesModel codesModel) {
        this.type = type;
        this.message_body = message_body;
        this.user_from = user_from;
        this.user_to = user_to;
        this.appear_type = appear_type;
        this.codesModel = codesModel;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage_body() {
        return message_body;
    }

    public void setMessage_body(String message_body) {
        this.message_body = message_body;
    }

    public Integer getUser_from() {
        return user_from;
    }

    public void setUser_from(Integer user_from) {
        this.user_from = user_from;
    }

    public Integer getUser_to() {
        return user_to;
    }

    public void setUser_to(Integer user_to) {
        this.user_to = user_to;
    }

    public Integer getAppear_type() {
        return appear_type;
    }

    public void setAppear_type(Integer appear_type) {
        this.appear_type = appear_type;
    }

    public CodesModel getCodesModel() {
        return codesModel;
    }

    public void setCodesModel(CodesModel codesModel) {
        this.codesModel = codesModel;
    }




}
