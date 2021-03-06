package com.shadiz.android.icab.data.realm.models;

import java.util.Locale;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created on 31.01.2017.
 */

public class RealmTableFields extends RealmObject {

    @PrimaryKey private String id;

    @Required private String commonTaxiDriver = "common_driver"; // COMMON_TAXI_DRIVER_PREFS
    @Required private String login = ""; // PREF_LOGIN
    @Required private String token = ""; // PREF_TOKEN
    private int discount = 0; // PREF_DISCOUNT
    private long lastMessageTime = -1; // PREF_LAST_MESSAGE_TIME
    private long stopServiceTime = -1; // PREF_STOP_SERVICE_TIME

    private boolean isCreditCards = false; // PREF_IS_CREDIT_CARDS
    private boolean isConnected = false; // PREF_IS_CONNECTED
    private int postponedCount = 0; // PREF_POSTPONED_COUNT

    private float lat = 0; // PREF_LAT
    private float lng = 0; // PREF_LNG
    @Required private String tripId = ""; // TRIP_ID
    @Required private String messageJson = ""; // PREF_MESSAGE_JSON
    @Required private String tripAction = ""; // PREF_TRIP_ACTION
    @Required private String messageJsonInvite = ""; // PREF_MESSAGE_JSON_INVITE
    private int visibilityRadius = 5000; // PREF_VISIBILITY_RADUIS
    private int carId = -1; // PREF_CAR_ID
    @Required private String isoLanguage = Locale.getDefault().getLanguage().toLowerCase(); // PREF_ISO_LANGUAGE
    @Required private String isoCountry = Locale.getDefault().getISO3Country(); // PREF_ISO_COUNTRY
    @Required private String lastNewsUpdate = "2015-01-01 15:40:51"; // PREF_LAST_NEWS_UPDATE
    @Required private String completed = "-"; // PREF_COMPLETED
    @Required private String kmPassed = "-"; // PREF_KM_PASSED
    @Required private String cancelledByMe = "-"; // PREF_CANCELLED_BY_ME
    @Required private String cancelledBySmth = "-"; // PREF_CANCELLED_BY_SMTH
    @Required private String commission = "-"; // PREF_COMISSION
    @Required private String setStatsRating = "0"; // PREF_SET_STATS_RATING
    @Required private String bigLikes = "0"; // PREFS_BIG_LIKES
    @Required private String smallLikes = "0"; // PREFS_SMALL_LIKES
    private long statsStart = System.currentTimeMillis(); // PREFS_STATS_START
    private long statsEnd = System.currentTimeMillis(); // PREF_STATS_END
    private long postEnd = System.currentTimeMillis(); // PREF_POST_END
    private long postStart = 0; // PREF_POST_START
    private long postponedTimeEnd = System.currentTimeMillis(); // PREF_POSTPONED_TIME_END
    private long postponedTimeStart = System.currentTimeMillis() - (1000 * 60 * 60 * 24 * 7); // 7 days backport. PREF_POSTPONED_TIME_START
    @Required private String filterDistance = "5"; // PREF_FILTER_DISTANCE
    @Required private String filterRad = "5"; // PREF_FILTER_RAD

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

    public long getLastMessageTime() {
        return lastMessageTime;
    }

    public void setLastMessageTime(long lastMessageTime) {
        this.lastMessageTime = lastMessageTime;
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

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
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
        if (statsEnd == -1) statsEnd = System.currentTimeMillis();
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
