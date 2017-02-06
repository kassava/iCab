package com.shadiz.android.icab.data.repositories.network.client.models.request.rate_order;

/**
 * Created on 05.02.2017.
 */

public class MessageOfTripRaterModel {
    private String type;
    private int code1, code2;
    private String code3, code4;

    /**
     *
     * @param type - clientServer_rateDriverAfterTrip_agree
     * @param code1 - id поездки
     * @param code2 - рейтинг
     * @param code3
     * @param code4
     */
    public MessageOfTripRaterModel(String type, int code1, int code2, String code3, String code4) {
        this.type = type;
        this.code1 = code1;
        this.code2 = code2;
        this.code3 = code3;
        this.code4 = code4;
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

    public String getCode3() {
        return code3;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }

    public String getCode4() {
        return code4;
    }

    public void setCode4(String code4) {
        this.code4 = code4;
    }
}