package com.shadiz.android.icab.data.realm.models.trip;

import com.shadiz.android.icab.data.realm.models.RealmClientInfoModel;

import io.realm.RealmObject;

/**
 * Created on 11.02.2017.
 */

public class RealmDriverTripModel extends RealmObject {

    private RealmTripModel trip;

    private String clientId;
    private String isPostponed;
    private String dateCreated;
    private String dateUpdated;
    private String isRemote;
    private RealmClientInfoModel clientInfo;
    private String remotePhone;
    private String remoteName;

    public RealmTripModel getTrip() {
        return trip;
    }

    public void setTrip(RealmTripModel trip) {
        this.trip = trip;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getIsPostponed() {
        return isPostponed;
    }

    public void setIsPostponed(String isPostponed) {
        this.isPostponed = isPostponed;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getIsRemote() {
        return isRemote;
    }

    public void setIsRemote(String isRemote) {
        this.isRemote = isRemote;
    }

    public RealmClientInfoModel getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(RealmClientInfoModel clientInfo) {
        this.clientInfo = clientInfo;
    }

    public String getRemotePhone() {
        return remotePhone;
    }

    public void setRemotePhone(String remotePhone) {
        this.remotePhone = remotePhone;
    }

    public String getRemoteName() {
        return remoteName;
    }

    public void setRemoteName(String remoteName) {
        this.remoteName = remoteName;
    }

    public String getRemotePaycc() {
        return remotePaycc;
    }

    public void setRemotePaycc(String remotePaycc) {
        this.remotePaycc = remotePaycc;
    }

    public String getUniqueDriver() {
        return uniqueDriver;
    }

    public void setUniqueDriver(String uniqueDriver) {
        this.uniqueDriver = uniqueDriver;
    }

    public String getUniqueSent() {
        return uniqueSent;
    }

    public void setUniqueSent(String uniqueSent) {
        this.uniqueSent = uniqueSent;
    }

    public String getLastOffered_driver() {
        return lastOffered_driver;
    }

    public void setLastOffered_driver(String lastOffered_driver) {
        this.lastOffered_driver = lastOffered_driver;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    private String remotePaycc;
    private String uniqueDriver;
    private String uniqueSent;
    private String lastOffered_driver;
    private String cost;
}
