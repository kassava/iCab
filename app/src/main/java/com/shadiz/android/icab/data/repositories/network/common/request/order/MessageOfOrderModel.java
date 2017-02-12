package com.shadiz.android.icab.data.repositories.network.common.request.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.LocationModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.RequirementToTheDriverModel;
import com.shadiz.android.icab.data.repositories.network.common.model.CodesModel;

/**
 * Created on 31.01.17.
 */

public class MessageOfOrderModel {
    String type, message_body;
    Integer user_from;
    Integer user_to;
    Integer appear_type;
    String code1, code3, code6;
    int code5, code7, code8, code9;
    LocationModelRequest code2, code4;
    RequirementToTheDriverModel code10;
//    \"type\" : \"clientServer_userWantsToOrderTaxi_agree\", " +
//            " \"appear_type\" : 0, " +
//            " \"code10\" : \"{  \\\"acceptCC\\\" : false,  \\\"rateFrom\\\" : 0,  \\\"rateTo\\\" : 5,  \\\"radius\\\" : 5000}\"," +
//            "  \"code2\" : \"{  \\\"precision\\\" : -0.5,  \\\"longitude\\\" : 27.58569996803999,  \\\"latitude\\\" : 53.92142000367544,  \\" +
//            "\"geocode\\\" : \\\"vulica Bielamorskaja, 8, Minsk\\\"}\",  \"code5\" : 1,  \"user_to\" : 0}"

//    /**
//     * @param type
//     * @param message_body
//     * @param user_from
//     * @param user_to
//     * @param appear_type
//     * @param codesModel
//     */


    public MessageOfOrderModel() {
    }

    public MessageOfOrderModel(String type, String message_body, Integer user_from, Integer user_to, Integer appear_type, String code1, String code3, String code6, int code5, int code7, int code8, int code9, LocationModelRequest code2, LocationModelRequest code4, RequirementToTheDriverModel code10) {
        this.type = type;
        this.message_body = message_body;
        this.user_from = user_from;
        this.user_to = user_to;
        this.appear_type = appear_type;
        this.code1 = code1;
        this.code3 = code3;
        this.code6 = code6;
        this.code5 = code5;
        this.code7 = code7;
        this.code8 = code8;
        this.code9 = code9;
        this.code2 = code2;
        this.code4 = code4;
        this.code10 = code10;
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


    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getCode3() {
        return code3;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }

    public String getCode6() {
        return code6;
    }

    public void setCode6(String code6) {
        this.code6 = code6;
    }

    public int getCode5() {
        return code5;
    }

    public void setCode5(int code5) {
        this.code5 = code5;
    }

    public int getCode7() {
        return code7;
    }

    public void setCode7(int code7) {
        this.code7 = code7;
    }

    public int getCode8() {
        return code8;
    }

    public void setCode8(int code8) {
        this.code8 = code8;
    }

    public int getCode9() {
        return code9;
    }

    public void setCode9(int code9) {
        this.code9 = code9;
    }

    public LocationModelRequest getCode2() {
        return code2;
    }

    public void setCode2(LocationModelRequest code2) {
        this.code2 = code2;
    }

    public LocationModelRequest getCode4() {
        return code4;
    }

    public void setCode4(LocationModelRequest code4) {
        this.code4 = code4;
    }

    public RequirementToTheDriverModel getCode10() {
        return code10;
    }

    public void setCode10(RequirementToTheDriverModel code10) {
        this.code10 = code10;
    }
}
