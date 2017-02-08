package com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.model.CarModel;
import com.shadiz.android.icab.data.repositories.network.common.response.BaseUserInfo;
import com.shadiz.android.icab.data.repositories.network.common.response.LocationModelResponse;

/**
 * Created by oldman on 06.02.17.
 */

public class DriverInfoModel extends BaseUserInfo {

    @SerializedName("current_discount")
    @Expose
    private Integer current_discount;
    @SerializedName("position")
    @Expose
    private LocationModelResponse position;
    @SerializedName("car_info")
    @Expose
    private CarModel car_info;
    @SerializedName("current_price")
    @Expose
    private CurrentPriceModel current_price;
    @SerializedName("phone")
    @Expose
    private Integer phone;
    @SerializedName("likes")
    @Expose
    private float likes;


    public Integer getCurrent_discount() {
        return current_discount;
    }

    public void setCurrent_discount(Integer current_discount) {
        this.current_discount = current_discount;
    }

    public float getLikes() {
        return likes;
    }

    public void setLikes(float likes) {
        this.likes = likes;
    }

    public CarModel getCar_info() {
        return car_info;
    }

    public void setCar_info(CarModel car_info) {
        this.car_info = car_info;
    }

    public CurrentPriceModel getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(CurrentPriceModel current_price) {
        this.current_price = current_price;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public LocationModelResponse getPosition() {
        return position;
    }

    public void setPosition(LocationModelResponse position) {
        this.position = position;
    }


}
