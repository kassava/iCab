package com.shadiz.android.icab.data.realm.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created on 31.01.2017.
 */

public class RealmClientModel extends RealmObject {

    @PrimaryKey private String id;

    @Required private String mapLastActionType;
    @Required private String mapOrderType;
    @Required private String mapSelectedDriver;
    @Required private String mapPickupTime;
    @Required private String mapSeats;
    @Required private String mapComment;
    @Required private String mapTripLength;
    @Required private String mapTripTime;
    @Required private String mapPrice;
    @Required private String mapTripCurrency;
    @Required private String mapStartPoint;
    @Required private String mapEndPoint;
    @Required private String mapOrderId;
    @Required private String mapOrderDriverPosition;
    @Required private String mapOrderDriverInfo;
    @Required private long orderStart; // PREFS_ORDER_START
    @Required private float postLat;
    @Required private float postLon;
    @Required private String postGeocode;
    @Required private boolean isClientApp; // PREF_IS_CLIENT_APP
    @Required private String imageRegister; // PREF_IMAGE_REGISTER
    @Required private String filterRatingFrom; // PREF_FILTER_RATING_FROM
    @Required private String filterRatingTo; // PREF_FILTER_RATING_TO
    @Required private boolean filterCardsAvailable; // PREF_FILTER_CARDS_AVAILABLE
    @Required private String loginForRegister; // PREF_LOGIN_FOR_REGISTER
    @Required private float zoom; // PREF_ZOOM
    @Required private float pickClientLocation;
    @Required private float difBetweenServerTime;
    @Required private String lastSelectedDriver;

    @Required private String mapStartPointPostLat;
    @Required private String mapStartPointPostLon;
    @Required private String mapStartPointPostGeocode;
    @Required private String mapEndPointPostLat;
    @Required private String mapEndPointPostLon;
    @Required private String mapEndPointPostGeocode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMapLastActionType() {
        return mapLastActionType;
    }

    public void setMapLastActionType(String mapLastActionType) {
        this.mapLastActionType = mapLastActionType;
    }

    public String getMapOrderType() {
        return mapOrderType;
    }

    public void setMapOrderType(String mapOrderType) {
        this.mapOrderType = mapOrderType;
    }

    public String getMapSelectedDriver() {
        return mapSelectedDriver;
    }

    public void setMapSelectedDriver(String mapSelectedDriver) {
        this.mapSelectedDriver = mapSelectedDriver;
    }

    public String getMapPickupTime() {
        return mapPickupTime;
    }

    public void setMapPickupTime(String mapPickupTime) {
        this.mapPickupTime = mapPickupTime;
    }

    public String getMapSeats() {
        return mapSeats;
    }

    public void setMapSeats(String mapSeats) {
        this.mapSeats = mapSeats;
    }

    public String getMapComment() {
        return mapComment;
    }

    public void setMapComment(String mapComment) {
        this.mapComment = mapComment;
    }

    public String getMapTripLength() {
        return mapTripLength;
    }

    public void setMapTripLength(String mapTripLength) {
        this.mapTripLength = mapTripLength;
    }

    public String getMapTripTime() {
        return mapTripTime;
    }

    public void setMapTripTime(String mapTripTime) {
        this.mapTripTime = mapTripTime;
    }

    public String getMapPrice() {
        return mapPrice;
    }

    public void setMapPrice(String mapPrice) {
        this.mapPrice = mapPrice;
    }

    public String getMapTripCurrency() {
        return mapTripCurrency;
    }

    public void setMapTripCurrency(String mapTripCurrency) {
        this.mapTripCurrency = mapTripCurrency;
    }

    public String getMapStartPoint() {
        return mapStartPoint;
    }

    public void setMapStartPoint(String mapStartPoint) {
        this.mapStartPoint = mapStartPoint;
    }

    public String getMapEndPoint() {
        return mapEndPoint;
    }

    public void setMapEndPoint(String mapEndPoint) {
        this.mapEndPoint = mapEndPoint;
    }

    public String getMapOrderId() {
        return mapOrderId;
    }

    public void setMapOrderId(String mapOrderId) {
        this.mapOrderId = mapOrderId;
    }

    public String getMapOrderDriverPosition() {
        return mapOrderDriverPosition;
    }

    public void setMapOrderDriverPosition(String mapOrderDriverPosition) {
        this.mapOrderDriverPosition = mapOrderDriverPosition;
    }

    public String getMapOrderDriverInfo() {
        return mapOrderDriverInfo;
    }

    public void setMapOrderDriverInfo(String mapOrderDriverInfo) {
        this.mapOrderDriverInfo = mapOrderDriverInfo;
    }

    public long getOrderStart() {
        return orderStart;
    }

    public void setOrderStart(long orderStart) {
        this.orderStart = orderStart;
    }

    public float getPostLat() {
        return postLat;
    }

    public void setPostLat(float postLat) {
        this.postLat = postLat;
    }

    public float getPostLon() {
        return postLon;
    }

    public void setPostLon(float postLon) {
        this.postLon = postLon;
    }

    public String getPostGeocode() {
        return postGeocode;
    }

    public void setPostGeocode(String postGeocode) {
        this.postGeocode = postGeocode;
    }

    public boolean getIsClientApp() {
        return isClientApp;
    }

    public void setIsClientApp(boolean isClientApp) {
        this.isClientApp = isClientApp;
    }

    public String getImageRegister() {
        return imageRegister;
    }

    public void setImageRegister(String imageRegister) {
        this.imageRegister = imageRegister;
    }

    public String getFilterRatingFrom() {
        return filterRatingFrom;
    }

    public void setFilterRatingFrom(String filterRatingFrom) {
        this.filterRatingFrom = filterRatingFrom;
    }

    public String getFilterRatingTo() {
        return filterRatingTo;
    }

    public void setFilterRatingTo(String filterRatingTo) {
        this.filterRatingTo = filterRatingTo;
    }

    public boolean getFilterCardsAvailable() {
        return filterCardsAvailable;
    }

    public void setFilterCardsAvailable(boolean filterCardsAvailable) {
        this.filterCardsAvailable = filterCardsAvailable;
    }

    public String getLoginForRegister() {
        return loginForRegister;
    }

    public void setLoginForRegister(String loginForRegister) {
        this.loginForRegister = loginForRegister;
    }

    public float getZoom() {
        return zoom;
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
    }

    public float getPickClientLocation() {
        return pickClientLocation;
    }

    public void setPickClientLocation(float pickClientLocation) {
        this.pickClientLocation = pickClientLocation;
    }

    public float getDifBetweenServerTime() {
        return difBetweenServerTime;
    }

    public void setDifBetweenServerTime(float difBetweenServerTime) {
        this.difBetweenServerTime = difBetweenServerTime;
    }

    public String getLastSelectedDriver() {
        return lastSelectedDriver;
    }

    public void setLastSelectedDriver(String lastSelectedDriver) {
        this.lastSelectedDriver = lastSelectedDriver;
    }


    public String getMapStartPointPostLat() {
        return mapStartPointPostLat;
    }

    public void setMapStartPointPostLat(String mapStartPointPostLat) {
        this.mapStartPointPostLat = mapStartPointPostLat;
    }

    public boolean isClientApp() {
        return isClientApp;
    }

    public void setClientApp(boolean clientApp) {
        isClientApp = clientApp;
    }

    public boolean isFilterCardsAvailable() {
        return filterCardsAvailable;
    }

    public String getMapStartPointPostLon() {
        return mapStartPointPostLon;
    }

    public void setMapStartPointPostLon(String mapStartPointPostLon) {
        this.mapStartPointPostLon = mapStartPointPostLon;
    }

    public String getMapStartPointPostGeocode() {
        return mapStartPointPostGeocode;
    }

    public void setMapStartPointPostGeocode(String mapStartPointPostGeocode) {
        this.mapStartPointPostGeocode = mapStartPointPostGeocode;
    }

    public String getMapEndPointPostLat() {
        return mapEndPointPostLat;
    }

    public void setMapEndPointPostLat(String mapEndPointPostLat) {
        this.mapEndPointPostLat = mapEndPointPostLat;
    }

    public String getMapEndPointPostLon() {
        return mapEndPointPostLon;
    }

    public void setMapEndPointPostLon(String mapEndPointPostLon) {
        this.mapEndPointPostLon = mapEndPointPostLon;
    }

    public String getMapEndPointPostGeocode() {
        return mapEndPointPostGeocode;
    }

    public void setMapEndPointPostGeocode(String mapEndPointPostGeocode) {
        this.mapEndPointPostGeocode = mapEndPointPostGeocode;
    }
}
