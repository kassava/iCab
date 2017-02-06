package com.shadiz.android.icab.data.repositories.network.common.response.message_sync;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * Created by oldman on 01.02.17.
 */

public class MessagesModel {
    @Expose
    private Integer id;
    @Expose
    private Integer user_from;
    @Expose
    private Integer user_to;
    @Expose
    private Integer appear_type;
    @Expose
    private String type;
    @Expose
    private String expiretime;
    @Expose
    private String message_body;
    @Expose
    private String code1;
    @Expose
    private String code2;
    @Expose
    private String code3;
    @Expose
    private String code4;
    @Expose
    private String code5;
    @Expose
    private String code6;
    @Expose
    private String code7;
    @Expose
    private String code8;
    @Expose
    private String code9;
    @Expose
    private String code10;
    @Expose
    private Date date_created;
    @Expose
    private Date  date_sent;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    public String getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(String expiretime) {
        this.expiretime = expiretime;
    }

    public String getMessage_body() {
        return message_body;
    }

    public void setMessage_body(String message_body) {
        this.message_body = message_body;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
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

    public String getCode5() {
        return code5;
    }

    public void setCode5(String code5) {
        this.code5 = code5;
    }

    public String getCode6() {
        return code6;
    }

    public void setCode6(String code6) {
        this.code6 = code6;
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

    public String getCode10() {
        return code10;
    }

    public void setCode10(String code10) {
        this.code10 = code10;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_sent() {
        return date_sent;
    }

    public void setDate_sent(Date date_sent) {
        this.date_sent = date_sent;
    }
}
