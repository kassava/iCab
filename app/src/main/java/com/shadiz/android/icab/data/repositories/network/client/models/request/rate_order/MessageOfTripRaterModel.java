package com.shadiz.android.icab.data.repositories.network.client.models.request.rate_order;

/**
 * Created on 05.02.2017.
 */

public class MessageOfTripRaterModel {
    private String type;
    private int code1, code2, appear_type, user_to;

    /**
     *
     * @param type - clientServer_rateDriverAfterTrip_agree
     * @param code1
     * @param code2
     * @param appear_type
     * @param user_to
     */
    public MessageOfTripRaterModel(String type, int code1, int code2, int appear_type, int user_to) {
        this.type = type;
        this.code1 = code1;
        this.code2 = code2;
        this.appear_type = appear_type;
        this.user_to = user_to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCode1() {
        return code1;
    }

    public void setCode1(int code1) {
        this.code1 = code1;
    }

    public int getCode2() {
        return code2;
    }

    public void setCode2(int code2) {
        this.code2 = code2;
    }

    public int getAppear_type() {
        return appear_type;
    }

    public void setAppear_type(int appear_type) {
        this.appear_type = appear_type;
    }

    public int getUser_to() {
        return user_to;
    }

    public void setUser_to(int user_to) {
        this.user_to = user_to;
    }
}
