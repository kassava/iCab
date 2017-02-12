package com.shadiz.android.icab.data.realm.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created on 11.02.2017.
 */

public class RealmCarInfoModel extends RealmObject {

    @PrimaryKey private String id;

    private String model;
    private String seats;
    private String regNumber;
    private String acceptedCards;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getAcceptedCards() {
        return acceptedCards;
    }

    public void setAcceptedCards(String acceptedCards) {
        this.acceptedCards = acceptedCards;
    }
}
