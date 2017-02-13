package com.shadiz.android.icab.data.repositories.network.common.request.order;

import com.shadiz.android.icab.data.repositories.network.common.LocationModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.RequirementToTheDriverModel;

/**
 * Created on 31.01.17.
 */

public class MessageOfOrderModel {
    String type, message_body;
    String user_from;
    String user_to;
    String appear_type;
    String code1, code3, code6;
    String code5, code7, code8, code9;
    String code2, code4;
    String code10;
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

    public MessageOfOrderModel(String type, String message_body, String user_from, String user_to, String appear_type, String code1, String code3, String code6, String code5, String code7, String code8, String code9, String code2, String code4, String code10) {
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

    public String getAppear_type() {
        return appear_type;
    }

    public void setAppear_type(String appear_type) {
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

    public String getCode5() {
        return code5;
    }

    public void setCode5(String code5) {
        this.code5 = code5;
    }

    public String getCode7() {
        return code7;
    }

    public void setCode7(String code7) {
        this.code7 = code7;
    }

    public String getCode8() {
        return code8;
    }

    public void setCode8(String code8) {
        this.code8 = code8;
    }

    public String getCode9() {
        return code9;
    }

    public void setCode9(String code9) {
        this.code9 = code9;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public String getCode4() {
        return code4;
    }

    public void setCode4(String code4) {
        this.code4 = code4;
    }

    public String getCode10() {
        return code10;
    }

    public void setCode10(String code10) {
        this.code10 = code10;
    }
}
