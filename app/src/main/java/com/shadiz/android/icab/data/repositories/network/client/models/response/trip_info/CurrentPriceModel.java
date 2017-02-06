package com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by oldman on 06.02.17.
 */
public class CurrentPriceModel {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("start_time")
    @Expose
    private Date start_time;
    @SerializedName("end_time")
    @Expose
    private Date end_time;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("rate_1")
    @Expose
    private Integer rate_1;
    @SerializedName("rate_2")
    @Expose
    private Integer rate_2;
    @SerializedName("rate_3")
    @Expose
    private Integer rate_3;

    public CurrentPriceModel(String name, Date start_time, Date end_time, String currency, Integer rate_1, Integer rate_2, Integer rate_3) {
        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.currency = currency;
        this.rate_1 = rate_1;
        this.rate_2 = rate_2;
        this.rate_3 = rate_3;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getRate_1() {
        return rate_1;
    }

    public void setRate_1(Integer rate_1) {
        this.rate_1 = rate_1;
    }

    public Integer getRate_2() {
        return rate_2;
    }

    public void setRate_2(Integer rate_2) {
        this.rate_2 = rate_2;
    }

    public Integer getRate_3() {
        return rate_3;
    }

    public void setRate_3(Integer rate_3) {
        this.rate_3 = rate_3;
    }
}
