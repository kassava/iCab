package com.shadiz.android.icab.data.repositories;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;
import com.shadiz.android.icab.data.realm.models.RealmClientModel;
import com.shadiz.android.icab.data.realm.models.RealmTable;
import com.shadiz.android.icab.data.realm.models.RealmTableFields;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created on 30.01.2017.
 */

public class RealmRepo extends BaseRepository {

    public RealmRepo(Context context) {
        super(context);
    }

    @Override
    public void removeClientObject() {
        // TODO: check this behaviour
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmQuery<RealmClientModel> query = realm.where(RealmClientModel.class);
        RealmResults<RealmClientModel> results = query.findAll();
        results.deleteFirstFromRealm();
        realm.commitTransaction();
    }

    @Override
    public void resetClientStartInfo() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        client.setMapPickupTime("");
        client.setMapStartPointPostLat(0);
        client.setMapStartPointPostLon(0);
        client.setMapStartPointPostGeocode("");
        client.setMapEndPointPostLat(0);
        client.setMapEndPointPostLon(0);
        client.setMapEndPointPostGeocode("");
        realm.commitTransaction();
    }

    @Override
    public void setClientKey(String key, String value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();

        if (key.equals(RealmTable.RealmClientModel.MAP_LAST_ACTION_TYPE)) {
            client.setMapLastActionType(value);
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_ORDER_TYPE)) {
            client.setMapOrderType(value);
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_COMMENT)) {
            client.setMapComment(value);
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_ORDER_DRIVER_POSITION)) {
            client.setMapOrderDriverPosition(value);
        }
        if (key.equals(RealmTable.RealmClientModel.LAST_SELECTED_DRIVER)) {
            client.setLastSelectedDriver(value);
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_PICKUP_TIME)) {
            client.setMapPickupTime(value);
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_SEATS)) {
            client.setMapSeats(value);
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_PRICE)) {
            client.setMapPrice(value);
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_TRIP_CURRENCY)) {
            client.setMapTripCurrency(value);
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_ORDER_ID)) {
            client.setMapOrderId(value);
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_TRIP_TIME)) {
            client.setMapTripTime(value);
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_TRIP_LENGTH)) {
            client.setMapTripLength(value);
        }

        realm.commitTransaction();
    }

    @Override
    public String getClientKey(String key) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();

        if (key.equals(RealmTable.RealmClientModel.MAP_COMMENT)) {
            return client.getMapComment();
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_ORDER_DRIVER_POSITION)) {
            return client.getMapOrderDriverPosition();
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_LAST_ACTION_TYPE)) {
            return client.getMapLastActionType();
        }
        if (key.equals(RealmTable.RealmClientModel.LAST_SELECTED_DRIVER)) {
            return client.getLastSelectedDriver();
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_ORDER_TYPE)) {
            return client.getMapOrderType();
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_PICKUP_TIME)) {
            return client.getMapPickupTime();
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_SEATS)) {
            return client.getMapSeats();
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_PRICE)) {
            return client.getMapPrice();
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_TRIP_CURRENCY)) {
            return client.getMapTripCurrency();
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_ORDER_ID)) {
            return client.getMapOrderId();
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_TRIP_LENGTH)) {
            return client.getMapTripLength();
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_TRIP_TIME)) {
            return client.getMapTripTime();
        }

        realm.commitTransaction();
        return "";
    }

    @Override
    public void setLatLngGeoCode(String key, LatLng ll, String geo) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();

        if (key.equals(RealmTable.RealmClientModel.MAP_START_POINT)) {
            client.setMapStartPointPostLat((float) ll.latitude);
            client.setMapStartPointPostLon((float) ll.longitude);
            client.setMapStartPointPostGeocode(geo);
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_END_POINT)) {
            client.setMapEndPointPostLat((float) ll.latitude);
            client.setMapEndPointPostLon((float) ll.longitude);
            client.setMapEndPointPostGeocode(geo);
        }

        realm.commitTransaction();
    }

    @Override
    public LatLng getLatLng(String key) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        LatLng ll = null;

        if (key.equals(RealmTable.RealmClientModel.MAP_START_POINT)) {
            ll = new LatLng(client.getMapStartPointPostLat(), client.getMapStartPointPostLon());
            if (ll.longitude == 0.0f || ll.latitude == 0.0f) {
                return null;
            }
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_END_POINT)) {
            ll = new LatLng(client.getMapEndPointPostLat(), client.getMapEndPointPostLon());
            if (ll.longitude == 0.0f || ll.latitude == 0.0f) {
                return null;
            }
        }

        realm.commitTransaction();
        return ll;
    }

    @Override
    public void setPickClientLatLng(LatLng ll) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();

        client.setPickClientLocationPostLat((float) ll.latitude);
        client.setPickClientLocationPostLon((float) ll.longitude);

        realm.commitTransaction();
    }

    @Override
    public LatLng getPickClientLatLng() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();

        LatLng ll = new LatLng(client.getPickClientLocationPostLat(),
                client.getPickClientLocationPostLon());

        realm.commitTransaction();
        return ll;
    }

    @Override
    public String getGeocode(String key) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();

        String geocode = null;
        if (key.equals(RealmTable.RealmClientModel.MAP_START_POINT)) {
            geocode = client.getMapStartPointPostGeocode();
        }
        if (key.equals(RealmTable.RealmClientModel.MAP_END_POINT)) {
            geocode = client.getMapEndPointPostGeocode();
        }
        if (geocode != null && geocode.equals("")) {
            geocode = "not set";
        }

        realm.commitTransaction();
        return geocode;
    }

    @Override
    public long getServiceStopTime() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();

        long stopServiceTime = tableFields.getStopServiceTime();
        if (stopServiceTime == 0) stopServiceTime = -1;

        realm.commitTransaction();
        return stopServiceTime;
    }

    @Override
    public void setServiceStopTime(long time) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();

        tableFields.setStopServiceTime(time);

        realm.commitTransaction();
    }

    @Override
    public void setLogin(String login) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();

        tableFields.setLogin(login);

        realm.commitTransaction();
    }

    @Override
    public String getLogin() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();

        String login = tableFields.getLogin();

        realm.commitTransaction();
        return login;
    }

    @Override
    public void setPostponedCount(int postponedCount) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();

        tableFields.setPostponedCount(postponedCount);

        realm.commitTransaction();
    }

    @Override
    public int getPostponedCount() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();

        int postponedCount = tableFields.getPostponedCount();

        realm.commitTransaction();
        return postponedCount;
    }

    @Override
    public void setLoginForRegister(String text) {

    }

    @Override
    public String getLoginForRegister() {
        return null;
    }

    @Override
    public String getToken() {
        return null;
    }

    @Override
    public void setToken(String text) {

    }

    @Override
    public int getDiscount() {
        return 0;
    }

    @Override
    public void setDiscount(int text) {

    }

    @Override
    public int getCarId() {
        return 0;
    }

    @Override
    public void setCarId(int id) {

    }

    @Override
    public long getLastUpdateTime() {
        return 0;
    }

    @Override
    public void setLastUpdateTime(long time) {

    }

    @Override
    public void setCreditCard(boolean isAvailable) {

    }

    @Override
    public boolean getCreditCard() {
        return false;
    }

    @Override
    public void setConnected(boolean connected) {

    }

    @Override
    public boolean getConnected() {
        return false;
    }

    @Override
    public void setLatitude(float lat) {

    }

    @Override
    public float getLatitude() {
        return 0;
    }

    @Override
    public void setLongtitude(float lon) {

    }

    @Override
    public float getLongtitude() {
        return 0;
    }

    @Override
    public void setCurrentMessageJson(String originalJsonString) {

    }

    @Override
    public String getCurrentMessageJson() {
        return null;
    }

    @Override
    public void setInviteMessageJson(String originalJsonString) {

    }

    @Override
    public String getInviteMessageJson() {
        return null;
    }

    @Override
    public void setLastCurrentTripAction(String action) {

    }

    @Override
    public String getLastCurrentTripAction() {
        return null;
    }

    @Override
    public void setVisibilityRadius(int mVisibilityRadius) {

    }

    @Override
    public int getVisibilityRadius() {
        return 0;
    }

    @Override
    public void setISOLanguage(String langIso) {

    }

    @Override
    public String getISOLanguage() {
        return null;
    }

    @Override
    public void setISOCountry(String countryIso) {

    }

    @Override
    public String getISOCountry() {
        return null;
    }

    @Override
    public void setLastNewsUpdate(String time) {

    }

    @Override
    public String getLastNewsUpdate() {
        return null;
    }

    @Override
    public void setCompleted(String value) {

    }

    @Override
    public String getCompleted() {
        return null;
    }

    @Override
    public void setkm_passed(String value) {

    }

    @Override
    public String getkm_passed() {
        return null;
    }

    @Override
    public void setcancelled_by_me(String value) {

    }

    @Override
    public String getcancelled_by_me() {
        return null;
    }

    @Override
    public void setcancelled_by_smth(String value) {

    }

    @Override
    public String getcancelled_by_smth() {
        return null;
    }

    @Override
    public void setcomission(String value) {

    }

    @Override
    public String getcomission() {
        return null;
    }

    @Override
    public void setStatsRating(String value) {

    }

    @Override
    public String getStatsRating() {
        return null;
    }

    @Override
    public void setStatsBigLikes(String value) {

    }

    @Override
    public String getStatsBigLikes() {
        return null;
    }

    @Override
    public void setStatsSmallLikes(String value) {

    }

    @Override
    public String getStatsSmallLikes() {
        return null;
    }

    @Override
    public void setStatisticStart(long value) {

    }

    @Override
    public long getStatisticStart() {
        return 0;
    }

    @Override
    public void setOrderStart(long value) {

    }

    @Override
    public long getOrderStart() {
        return 0;
    }

    @Override
    public void setStatisticEnd(long value) {

    }

    @Override
    public long getStatisticEnd() {
        return 0;
    }

    @Override
    public void clearStatisticDates() {

    }

    @Override
    public void setPostponedTimeStart(long value) {

    }

    @Override
    public long getPostponedTimeStart() {
        return 0;
    }

    @Override
    public void setPostponedTimeEnd(long value) {

    }

    @Override
    public long getPostponedTimeEnd() {
        return 0;
    }

    @Override
    public void setFilterDistance(String value) {

    }

    @Override
    public String getFilterDistance() {
        return null;
    }

    @Override
    public void setFilterRadius(String value) {

    }

    @Override
    public String getFilterRatingFrom() {
        return null;
    }

    @Override
    public void setFilterRatingFrom(String value) {

    }

    @Override
    public String getFilterRatingTo() {
        return null;
    }

    @Override
    public void setFilterRatingTo(String value) {

    }

    @Override
    public void setFilterCards(boolean b) {

    }

    @Override
    public boolean getFilterCards() {
        return false;
    }

    @Override
    public String getFilterRadius() {
        return null;
    }

    @Override
    public void setPostponedStart(long value) {

    }

    @Override
    public long getPostponedStart() {
        return 0;
    }

    @Override
    public void setPostponedEnd(long value) {

    }

    @Override
    public long getPostponedEnd() {
        return 0;
    }

    @Override
    public void setAppClient(boolean b) {

    }

    @Override
    public boolean getIsAppClient() {
        return false;
    }

    @Override
    public void setImageRegister(String value) {

    }

    @Override
    public String getImageRegister() {
        return null;
    }

    @Override
    public void setLastZoom(float lastZoom) {

    }

    @Override
    public float getLastZoom() {
        return 0;
    }

    @Override
    public void setDifBetweenServerTime(long dif) {

    }

    @Override
    public long getDifBetweenServerTime() {
        return 0;
    }
}
