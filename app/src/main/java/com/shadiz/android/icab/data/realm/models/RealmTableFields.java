package com.shadiz.android.icab.data.realm.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created on 31.01.2017.
 */

public class RealmTableFields extends RealmObject {

    @PrimaryKey private String id;

    @Required private String commonTaxiDriver; // COMMON_TAXI_DRIVER_PREFS
    @Required private String login; // PREF_LOGIN
    @Required private String token; // PREF_TOKEN
    @Required private int discount; // PREF_DISCOUNT
    @Required private long lastMassageTime; // PREF_LAST_MESSAGE_TIME
    @Required private long stopServiceTime; // PREF_STOP_SERVICE_TIME

    @Required private boolean isCreditCards; // PREF_IS_CREDIT_CARDS
    @Required private boolean isConnected; // PREF_IS_CONNECTED
    @Required private int postponedCount; // PREF_POSTPONED_COUNT

    @Required private float lat; // PREF_LAT
    @Required private float lng; // PREF_LNG
    @Required private String tripId; // TRIP_ID
    @Required private String messageJson; // PREF_MESSAGE_JSON
    @Required private String tripAction; // PREF_TRIP_ACTION
    @Required private String messageJsonInvite; // PREF_MESSAGE_JSON_INVITE
    @Required private int visibilityRadius; // PREF_VISIBILITY_RADUIS
    @Required private int carId; // PREF_CAR_ID
    @Required private String isoLanguage; // PREF_ISO_LANGUAGE
    @Required private String isoCountry; // PREF_ISO_COUNTRY
    @Required private String lastNewsUpdate; // PREF_LAST_NEWS_UPDATE
    @Required private String isCompleted; // PREF_COMPLETED
    @Required private String kmPassed; // PREF_KM_PASSED
    @Required private String cancelledByMe; // PREF_CANCELLED_BY_ME
    @Required private String cancelledBySmth; // PREF_CANCELLED_BY_SMTH
    @Required private String commission; // PREF_COMISSION
    @Required private String setStatsRating; // PREF_SET_STATS_RATING
    @Required private String bigLikes; // PREFS_BIG_LIKES
    @Required private String smallLikes; // PREFS_SMALL_LIKES
    @Required private long statsStart; // PREFS_STATS_START
    @Required private long statsEnd; // PREF_STATS_END
    @Required private long postEnd; // PREF_POST_END
    @Required private long postStart; // PREF_POST_START
    @Required private long postponedTimeEnd; // PREF_POSTPONED_TIME_END
    @Required private long postponedTimeStart; // PREF_POSTPONED_TIME_START
    @Required private String filterDistance; // PREF_FILTER_DISTANCE
    @Required private String filterRad; // PREF_FILTER_RAD

    public String getLastNewsUpdate() {
        return lastNewsUpdate;
    }

    public void setLastNewsUpdate(String lastNewsUpdate) {
        this.lastNewsUpdate = lastNewsUpdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommonTaxiDriver() {
        return commonTaxiDriver;
    }

    public void setCommonTaxiDriver(String commonTaxiDriver) {
        this.commonTaxiDriver = commonTaxiDriver;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public long getLastMassageTime() {
        return lastMassageTime;
    }

    public void setLastMassageTime(long lastMassageTime) {
        this.lastMassageTime = lastMassageTime;
    }

    public long getStopServiceTime() {
        return stopServiceTime;
    }

    public void setStopServiceTime(long stopServiceTime) {
        this.stopServiceTime = stopServiceTime;
    }

    public boolean getIsCreditCards() {
        return isCreditCards;
    }

    public void setIsCreditCards(boolean isCreditCards) {
        this.isCreditCards = isCreditCards;
    }

    public boolean getIsConnected() {
        return isConnected;
    }

    public void setIsConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public int getPostponedCount() {
        return postponedCount;
    }

    public void setPostponedCount(int postponedCount) {
        this.postponedCount = postponedCount;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getMessageJson() {
        return messageJson;
    }

    public void setMessageJson(String messageJson) {
        this.messageJson = messageJson;
    }

    public String getTripAction() {
        return tripAction;
    }

    public void setTripAction(String tripAction) {
        this.tripAction = tripAction;
    }

    public String getMessageJsonInvite() {
        return messageJsonInvite;
    }

    public void setMessageJsonInvite(String messageJsonInvite) {
        this.messageJsonInvite = messageJsonInvite;
    }

    public int getVisibilityRadius() {
        return visibilityRadius;
    }

    public void setVisibilityRadius(int visibilityRadius) {
        this.visibilityRadius = visibilityRadius;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getIsoLanguage() {
        return isoLanguage;
    }

    public void setIsoLanguage(String isoLanguage) {
        this.isoLanguage = isoLanguage;
    }

    public String getIsoCountry() {
        return isoCountry;
    }

    public void setIsoCountry(String isoCountry) {
        this.isoCountry = isoCountry;
    }

    public String getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(String isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getKmPassed() {
        return kmPassed;
    }

    public void setKmPassed(String kmPassed) {
        this.kmPassed = kmPassed;
    }

    public String getCancelledByMe() {
        return cancelledByMe;
    }

    public void setCancelledByMe(String cancelledByMe) {
        this.cancelledByMe = cancelledByMe;
    }

    public String getCancelledBySmth() {
        return cancelledBySmth;
    }

    public void setCancelledBySmth(String cancelledBySmth) {
        this.cancelledBySmth = cancelledBySmth;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getSetStatsRating() {
        return setStatsRating;
    }

    public void setSetStatsRating(String setStatsRating) {
        this.setStatsRating = setStatsRating;
    }

    public String getBigLikes() {
        return bigLikes;
    }

    public void setBigLikes(String bigLikes) {
        this.bigLikes = bigLikes;
    }

    public String getSmallLikes() {
        return smallLikes;
    }

    public void setSmallLikes(String smallLikes) {
        this.smallLikes = smallLikes;
    }

    public long getStatsStart() {
        return statsStart;
    }

    public void setStatsStart(long statsStart) {
        this.statsStart = statsStart;
    }

    public long getStatsEnd() {
        return statsEnd;
    }

    public void setStatsEnd(long statsEnd) {
        this.statsEnd = statsEnd;
    }

    public long getPostEnd() {
        return postEnd;
    }

    public void setPostEnd(long postEnd) {
        this.postEnd = postEnd;
    }

    public long getPostStart() {
        return postStart;
    }

    public void setPostStart(long postStart) {
        this.postStart = postStart;
    }

    public long getPostponedTimeEnd() {
        return postponedTimeEnd;
    }

    public void setPostponedTimeEnd(long postponedTimeEnd) {
        this.postponedTimeEnd = postponedTimeEnd;
    }

    public long getPostponedTimeStart() {
        return postponedTimeStart;
    }

    public void setPostponedTimeStart(long postponedTimeStart) {
        this.postponedTimeStart = postponedTimeStart;
    }

    public String getFilterDistance() {
        return filterDistance;
    }

    public void setFilterDistance(String filterDistance) {
        this.filterDistance = filterDistance;
    }

    public String getFilterRad() {
        return filterRad;
    }

    public void setFilterRad(String filterRad) {
        this.filterRad = filterRad;
    }
}
