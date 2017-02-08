package com.shadiz.android.icab.data.repositories.network.driver.models.response.trip_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by oldman on 08.02.17.
 */

public class TripResponse {
    @SerializedName("id")
    @Expose
    Integer id;
    @SerializedName("client_id")
    @Expose
    Integer client_id;
    @SerializedName("is_postponed")
    @Expose
    String is_postponed;
    @SerializedName("pickup_time")
    @Expose
    String pickup_time;
    @SerializedName("date_created")
    @Expose
    Date date_created;
    @SerializedName("date_updated")
    @Expose
    Date date_updated;
    @SerializedName("date_started")
    @Expose
    Date date_started;
    @SerializedName("date_finished")
    @Expose
    Date date_finished;
    @SerializedName("mileage")
    @Expose
    Integer mileage;
    @SerializedName("seats")
    @Expose
    Integer seats;
    @SerializedName("client_note")
    @Expose
    String client_note;
    @SerializedName("pickup_geocode")
    @Expose
    String pickup_geocode;
    @SerializedName("destination_geocode")
    @Expose
    String destination_geocode;
    @SerializedName("last_message_type")
    @Expose
    String last_message_type;
    @SerializedName("duration")
    @Expose
    Integer duration;
    @SerializedName("is_remote")
    @Expose
    String is_remote;
    @SerializedName("remote_phone")
    @Expose
    String remote_phone;
    @SerializedName("remote_name")
    @Expose
    String remote_name;
    @SerializedName("remote_paycc")
    @Expose
    String remote_paycc;
    @SerializedName("unique_driver")
    @Expose
    String unique_driver;
    @SerializedName("unique_sent")
    @Expose
    String unique_sent;
    @SerializedName("last_offered_driver")
    @Expose
    String last_offered_driver;
    @SerializedName("cost")
    @Expose
    String cost;
    @SerializedName("pickup_longitude")
    @Expose
    String pickup_longitude;
    @SerializedName("pickup_latitude")
    @Expose
    String pickup_latitude;
    @SerializedName("destination_longitude")
    @Expose
    String destination_longitude;
    @SerializedName("destination_latitude")
    @Expose
    String destination_latitude;
    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("client_info")
    @Expose
    ClientInfoModel client_info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public String getIs_postponed() {
        return is_postponed;
    }

    public void setIs_postponed(String is_postponed) {
        this.is_postponed = is_postponed;
    }

    public String getPickup_time() {
        return pickup_time;
    }

    public void setPickup_time(String pickup_time) {
        this.pickup_time = pickup_time;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(Date date_updated) {
        this.date_updated = date_updated;
    }

    public Date getDate_started() {
        return date_started;
    }

    public void setDate_started(Date date_started) {
        this.date_started = date_started;
    }

    public Date getDate_finished() {
        return date_finished;
    }

    public void setDate_finished(Date date_finished) {
        this.date_finished = date_finished;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getClient_note() {
        return client_note;
    }

    public void setClient_note(String client_note) {
        this.client_note = client_note;
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

    public String getLast_message_type() {
        return last_message_type;
    }

    public void setLast_message_type(String last_message_type) {
        this.last_message_type = last_message_type;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getIs_remote() {
        return is_remote;
    }

    public void setIs_remote(String is_remote) {
        this.is_remote = is_remote;
    }

    public String getRemote_phone() {
        return remote_phone;
    }

    public void setRemote_phone(String remote_phone) {
        this.remote_phone = remote_phone;
    }

    public String getRemote_name() {
        return remote_name;
    }

    public void setRemote_name(String remote_name) {
        this.remote_name = remote_name;
    }

    public String getRemote_paycc() {
        return remote_paycc;
    }

    public void setRemote_paycc(String remote_paycc) {
        this.remote_paycc = remote_paycc;
    }

    public String getUnique_driver() {
        return unique_driver;
    }

    public void setUnique_driver(String unique_driver) {
        this.unique_driver = unique_driver;
    }

    public String getUnique_sent() {
        return unique_sent;
    }

    public void setUnique_sent(String unique_sent) {
        this.unique_sent = unique_sent;
    }

    public String getLast_offered_driver() {
        return last_offered_driver;
    }

    public void setLast_offered_driver(String last_offered_driver) {
        this.last_offered_driver = last_offered_driver;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getPickup_longitude() {
        return pickup_longitude;
    }

    public void setPickup_longitude(String pickup_longitude) {
        this.pickup_longitude = pickup_longitude;
    }

    public String getPickup_latitude() {
        return pickup_latitude;
    }

    public void setPickup_latitude(String pickup_latitude) {
        this.pickup_latitude = pickup_latitude;
    }

    public String getDestination_longitude() {
        return destination_longitude;
    }

    public void setDestination_longitude(String destination_longitude) {
        this.destination_longitude = destination_longitude;
    }

    public String getDestination_latitude() {
        return destination_latitude;
    }

    public void setDestination_latitude(String destination_latitude) {
        this.destination_latitude = destination_latitude;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ClientInfoModel getClient_info() {
        return client_info;
    }

    public void setClient_info(ClientInfoModel client_info) {
        this.client_info = client_info;
    }

}
