package com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by oldman on 06.02.17.
 */

public class ActiveTrip {
    @SerializedName("id")
    @Expose
    Integer id;
    @SerializedName("current_discount")
    @Expose
    Integer current_discount;
    @SerializedName("client_note")
    @Expose
    String client_note;
    @SerializedName("seats")
    @Expose
    Integer seats;
    @SerializedName("mileage")
    @Expose
    String mileage;
    @SerializedName("pickup_geocode")
    @Expose
    String pickup_geocode;
    @SerializedName("destination_geocode")
    @Expose
    String destination_geocode;
    @SerializedName("duration")
    @Expose
    String duration;
    @SerializedName("pickup_longitude")
    @Expose
    double pickup_longitude;
    @SerializedName("pickup_latitude")
    @Expose
    double pickup_latitude;
    @SerializedName("destination_longitude")
    @Expose
    double destination_longitude;
    @SerializedName("destination_latitude")
    @Expose
    double destination_latitude;
    @SerializedName("date_started")
    @Expose
    Date date_started;
    @SerializedName("pickup_time")
    @Expose
    String pickup_time;
    @SerializedName("order_time")
    @Expose
    Date order_time;
    @SerializedName("last_message_type")
    @Expose
    String last_message_type;
    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("driver_info")
    @Expose
    DriverInfoModel driver_info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurrent_discount() {
        return current_discount;
    }

    public void setCurrent_discount(Integer current_discount) {
        this.current_discount = current_discount;
    }

    public String getClient_note() {
        return client_note;
    }

    public void setClient_note(String client_note) {
        this.client_note = client_note;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getPickup_geocode() {
        return pickup_geocode;
    }

    public void setPickup_geocode(String pickup_geocode) {
        this.pickup_geocode = pickup_geocode;
    }

    public String getDestination_geocode() {
        return destination_geocode;
    }

    public void setDestination_geocode(String destination_geocode) {
        this.destination_geocode = destination_geocode;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getPickup_longitude() {
        return pickup_longitude;
    }

    public void setPickup_longitude(double pickup_longitude) {
        this.pickup_longitude = pickup_longitude;
    }

    public double getPickup_latitude() {
        return pickup_latitude;
    }

    public void setPickup_latitude(double pickup_latitude) {
        this.pickup_latitude = pickup_latitude;
    }

    public double getDestination_longitude() {
        return destination_longitude;
    }

    public void setDestination_longitude(double destination_longitude) {
        this.destination_longitude = destination_longitude;
    }

    public double getDestination_latitude() {
        return destination_latitude;
    }

    public void setDestination_latitude(double destination_latitude) {
        this.destination_latitude = destination_latitude;
    }

    public Date getDate_started() {
        return date_started;
    }

    public void setDate_started(Date date_started) {
        this.date_started = date_started;
    }

    public String getPickup_time() {
        return pickup_time;
    }

    public void setPickup_time(String pickup_time) {
        this.pickup_time = pickup_time;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public String getLast_message_type() {
        return last_message_type;
    }

    public void setLast_message_type(String last_message_type) {
        this.last_message_type = last_message_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DriverInfoModel getDriver_info() {
        return driver_info;
    }

    public void setDriver_info(DriverInfoModel driver_info) {
        this.driver_info = driver_info;
    }
}
