package com.shadiz.android.icab.data.repositories.network.common.response.message_sync;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.response.LocationModelResponse;

import java.util.Date;

/**
 * Created on 01.02.17.
 */

public class MessagesModel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_from")
    @Expose
    private Integer user_from;
    @SerializedName("user_to")
    @Expose
    private Integer user_to;
    @SerializedName("appear_type")
    @Expose
    private Integer appear_type;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("expiretime")
    @Expose
    private String expiretime;
    @SerializedName("message_body")
    @Expose
    private String message_body;
    @SerializedName("code1")
    @Expose
    private Integer code1;
    @SerializedName("code2")
    @Expose
    private String code2;
    @SerializedName("code3")
    @Expose
    private Integer code3;
    @SerializedName("code4")
    @Expose
    private Integer code4;
    @SerializedName("code5")
    @Expose
    private LocationModelResponse code5;
    @SerializedName("code6")
    @Expose
    private float code6;
    @SerializedName("code7")
    @Expose
    private String code7;
    @SerializedName("code8")
    @Expose
    private Integer code8;
    @SerializedName("code9")
    @Expose
    private String code9;
    @SerializedName("code10")
    @Expose
    private String code10;
    @SerializedName("date_created")
    @Expose
    private Date date_created;
    @SerializedName("date_sent")
    @Expose
    private Date date_sent;

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

    public String getMessage_body() {
        return message_body;
    }

    public void setMessage_body(String message_body) {
        this.message_body = message_body;
    }

    public Integer getCode1() {
        return code1;
    }

    public void setCode1(Integer code1) {
        this.code1 = code1;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public Integer getCode3() {
        return code3;
    }

    public void setCode3(Integer code3) {
        this.code3 = code3;
    }

    public Integer getCode4() {
        return code4;
    }

    public void setCode4(Integer code4) {
        this.code4 = code4;
    }

    public LocationModelResponse getCode5() {
        return code5;
    }

    public void setCode5(LocationModelResponse code5) {
        this.code5 = code5;
    }

    public float getCode6() {
        return code6;
    }

    public void setCode6(float code6) {
        this.code6 = code6;
    }

    public String getCode7() {
        return code7;
    }

    public void setCode7(String code7) {
        this.code7 = code7;
    }

    public Integer getCode8() {
        return code8;
    }

    public void setCode8(Integer code8) {
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
