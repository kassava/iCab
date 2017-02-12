package com.shadiz.android.icab.data.realm.models.trip;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created on 11.02.2017.
 */

public class RealmTripModel extends RealmObject {

    @PrimaryKey private String id;

    private String mileage;
    private String pickTime;
    private String startedDate;
    private String seats;
    private String clientNote;
    private String pickupGeocode;
    private String destinationGeocode;
    private String lastMessageType;
    private String duration;
    private String pickupLongitude;
    private String pickupLatitude;
    private String destinationLongitude;
    private String destinationLatitude;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getPickTime() {
        return pickTime;
    }

    public void setPickTime(String pickTime) {
        this.pickTime = pickTime;
    }

    public String getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(String startedDate) {
        this.startedDate = startedDate;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getClientNote() {
        return clientNote;
    }

    public void setClientNote(String clientNote) {
        this.clientNote = clientNote;
    }

    public String getPickupGeocode() {
        return pickupGeocode;
    }

    public void setPickupGeocode(String pickupGeocode) {
        this.pickupGeocode = pickupGeocode;
    }

    public String getDestinationGeocode() {
        return destinationGeocode;
    }

    public void setDestinationGeocode(String destinationGeocode) {
        this.destinationGeocode = destinationGeocode;
    }

    public String getLastMessageType() {
        return lastMessageType;
    }

    public void setLastMessageType(String lastMessageType) {
        this.lastMessageType = lastMessageType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPickupLongitude() {
        return pickupLongitude;
    }

    public void setPickupLongitude(String pickupLongitude) {
        this.pickupLongitude = pickupLongitude;
    }

    public String getPickupLatitude() {
        return pickupLatitude;
    }

    public void setPickupLatitude(String pickupLatitude) {
        this.pickupLatitude = pickupLatitude;
    }

    public String getDestinationLongitude() {
        return destinationLongitude;
    }

    public void setDestinationLongitude(String destinationLongitude) {
        this.destinationLongitude = destinationLongitude;
    }

    public String getDestinationLatitude() {
        return destinationLatitude;
    }

    public void setDestinationLatitude(String destinationLatitude) {
        this.destinationLatitude = destinationLatitude;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
