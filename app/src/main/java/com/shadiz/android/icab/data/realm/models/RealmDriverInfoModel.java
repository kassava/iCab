package com.shadiz.android.icab.data.realm.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created on 11.02.2017.
 */

public class RealmDriverInfoModel extends RealmObject {

    @PrimaryKey String id;

    private String name;
    private String imageUrl;
    private String currentDiscount;
    private String likes;
    private RealmCarInfoModel carInfo;
    private RealmCurrentPriceModel currentPrice;
    private String phone;
    private String rating;
    private RealmPositionModel position;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCurrentDiscount() {
        return currentDiscount;
    }

    public void setCurrentDiscount(String currentDiscount) {
        this.currentDiscount = currentDiscount;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public RealmCarInfoModel getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(RealmCarInfoModel carInfo) {
        this.carInfo = carInfo;
    }

    public RealmCurrentPriceModel getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(RealmCurrentPriceModel currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public RealmPositionModel getPosition() {
        return position;
    }

    public void setPosition(RealmPositionModel position) {
        this.position = position;
    }
}
