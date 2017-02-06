package com.shadiz.android.icab.data.repositories.network.common.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by oldman on 06.02.17.
 */

public class CarModel {
    public CarModel(String model, Integer seats, String reg_number, Integer accepts_cards) {
        this.model = model;
        this.seats = seats;
        this.reg_number = reg_number;
        this.accepts_cards = accepts_cards;
    }

    public String getModel() {

        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getReg_number() {
        return reg_number;
    }

    public void setReg_number(String reg_number) {
        this.reg_number = reg_number;
    }

    public Integer getAccepts_cards() {
        return accepts_cards;
    }

    public void setAccepts_cards(Integer accepts_cards) {
        this.accepts_cards = accepts_cards;
    }

    @SerializedName("model")
    @Expose
    String model;
    @SerializedName("seats")
    @Expose
    Integer seats;
    @SerializedName("reg_number")
    @Expose
    String reg_number;
    @SerializedName("accepts_cards")
    @Expose
    Integer accepts_cards;
}
