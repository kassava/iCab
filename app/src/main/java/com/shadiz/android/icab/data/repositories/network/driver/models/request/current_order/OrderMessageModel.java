package com.shadiz.android.icab.data.repositories.network.driver.models.request.current_order;

/**
 * Created on 05.02.2017.
 */

public class OrderMessageModel {
    private String type;

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    private String code2;
    private int code1, appear_type, user_to;

    /**
     *
     * @param type - driverServer_userWantsToOrderTaxi_agree/driverServer_userWantsToOrderTaxi_disagree
     * @param code1
     * @param appear_type
     * @param user_to
     */
    public OrderMessageModel(String type, int code1, String code2, int appear_type, int user_to) {
        this.type = type;
        this.user_to = user_to;
        this.appear_type = appear_type;
        this.code1 = code1;
    }

    public OrderMessageModel() {
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
}
