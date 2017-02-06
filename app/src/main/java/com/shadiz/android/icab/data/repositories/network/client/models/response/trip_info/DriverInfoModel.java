package com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.model.CarModel;
import com.shadiz.android.icab.data.repositories.network.common.model.LocationModel;

/**
 * Created by oldman on 06.02.17.
 */

public class DriverInfoModel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image_url")
    @Expose
    private String image_url;
    @SerializedName("current_discount")
    @Expose
    private Integer current_discount;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("car_info")
    @Expose
    private CarModel car_info;
    @SerializedName("current_price")
    @Expose
    private CurrentPriceModel current_price;
    @SerializedName("phone")
    @Expose
    private Integer phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Integer getCurrent_discount() {
        return current_discount;
    }

    public void setCurrent_discount(Integer current_discount) {
        this.current_discount = current_discount;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public LocationModel getPosition() {
        return position;
    }

    public void setPosition(LocationModel position) {
        this.position = position;
    }

    @SerializedName("likes")
    @Expose

    private Integer rating;
    @SerializedName("rating")
    @Expose
    private LocationModel position;
}
