package com.shadiz.android.icab.data.repositories;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;
import com.shadiz.android.icab.data.realm.models.RealmClientModel;

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
        client.setMapStartPointPostLat("");
        client.setMapStartPointPostLon("");
        client.setMapStartPointPostGeocode("");
        client.setMapEndPointPostLat("");
        client.setMapEndPointPostLon("");
        client.setMapEndPointPostGeocode("");
        realm.commitTransaction();
    }

    @Override
    public void setClientKey(String key, String value) {

    }

    @Override
    public void setLatLngGeoCode(String key, LatLng ll, String geo) {

    }

    @Override
    public LatLng getLatLng(String key) {
        return null;
    }

    @Override
    public void setPickClientLatLng(LatLng ll) {

    }

    @Override
    public LatLng getPickClientLatLng() {
        return null;
    }

    @Override
    public String getGeocode(String key) {
        return null;
    }

    @Override
    public String getClientKey(String key) {
        return null;
    }

    @Override
    public long getServiceStopTime() {
        return 0;
    }

    @Override
    public void setServiceStopTime(long time) {

    }

    @Override
    public void setLogin(String text) {

    }

    @Override
    public String getLogin() {
        return null;
    }

    @Override
    public void setPosponedCount(int postopnedCount) {

    }

    @Override
    public int getPosponedCount() {
        return 0;
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
