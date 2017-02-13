package com.shadiz.android.icab.data.repositories.network.common.response.message_sync;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created on 01.02.17.
 */

public class MessagesModel {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("user_from")
    @Expose
    private Integer userFrom;
    @SerializedName("user_to")
    @Expose
    private String userTo;
    @SerializedName("appear_type")
    @Expose
    private String appearType;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("expiretime")
    @Expose
    private String expiretime;
    @SerializedName("message_body")
    @Expose
    private Object messageBody;
    @SerializedName("code1")
    @Expose
    private String code1;
    @SerializedName("code2")
    @Expose
    private String code2;
    @SerializedName("code3")
    @Expose
    private Object code3;
    @SerializedName("code4")
    @Expose
    private Object code4;
    @SerializedName("code5")
    @Expose
    private Object code5;
    @SerializedName("code6")
    @Expose
    private Object code6;
    @SerializedName("code7")
    @Expose
    private Object code7;
    @SerializedName("code8")
    @Expose
    private Object code8;
    @SerializedName("code9")
    @Expose
    private Object code9;
    @SerializedName("code10")
    @Expose
    private Object code10;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("date_sent")
    @Expose
    private String dateSent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(Integer userFrom) {
        this.userFrom = userFrom;
    }

    public String getUserTo() {
        return userTo;
    }

    public void setUserTo(String userTo) {
        this.userTo = userTo;
    }

    public String getAppearType() {
        return appearType;
    }

    public void setAppearType(String appearType) {
        this.appearType = appearType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(String expiretime) {
        this.expiretime = expiretime;
    }

    public Object getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(Object messageBody) {
        this.messageBody = messageBody;
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

    public Object getCode3() {
        return code3;
    }

    public void setCode3(Object code3) {
        this.code3 = code3;
    }

    public Object getCode4() {
        return code4;
    }

    public void setCode4(Object code4) {
        this.code4 = code4;
    }

    public Object getCode5() {
        return code5;
    }

    public void setCode5(Object code5) {
        this.code5 = code5;
    }

    public Object getCode6() {
        return code6;
    }

    public void setCode6(Object code6) {
        this.code6 = code6;
    }

    public Object getCode7() {
        return code7;
    }

    public void setCode7(Object code7) {
        this.code7 = code7;
    }

    public Object getCode8() {
        return code8;
    }

    public void setCode8(Object code8) {
        this.code8 = code8;
    }

    public Object getCode9() {
        return code9;
    }

    public void setCode9(Object code9) {
        this.code9 = code9;
    }

    public Object getCode10() {
        return code10;
    }

    public void setCode10(Object code10) {
        this.code10 = code10;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateSent() {
        return dateSent;
    }

    public void setDateSent(String dateSent) {
        this.dateSent = dateSent;
    }

}