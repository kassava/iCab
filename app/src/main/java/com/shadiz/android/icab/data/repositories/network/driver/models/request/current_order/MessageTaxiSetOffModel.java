package com.shadiz.android.icab.data.repositories.network.driver.models.request.current_order;

/**
 * Created by oldman on 08.02.17.
 */

public class MessageTaxiSetOffModel {
    private String type, appear_type;

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

    public int getCode1() {
        return code1;
    }

    public void setCode1(int code1) {
        this.code1 = code1;
    }

    public int getUser_to() {
        return user_to;
    }

    public void setUser_to(int user_to) {
        this.user_to = user_to;
    }

    private int code1, user_to;
}
