package com.shadiz.android.icab.data.repositories;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;
import com.shadiz.android.icab.dagger.Injector;
import com.shadiz.android.icab.data.realm.models.RealmClientModel;
import com.shadiz.android.icab.data.realm.models.RealmTableFields;
import com.shadiz.android.icab.data.realm.table.RealmTable;

import java.util.Calendar;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created on 30.01.2017.
 */

public class RealmRepo extends BaseRepository {

    @Inject
    Context context;

    private RealmConfiguration realmConfiguration;

    public RealmRepo() {
        Injector.getAppComponent().inject(this);
    }

    public void setup() {
        if (realmConfiguration == null) {
            Realm.init(context);
            realmConfiguration = new RealmConfiguration.Builder().build();
            Realm.setDefaultConfiguration(realmConfiguration);
        } else {
            throw new IllegalStateException("database already configured");
        }
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
    public void setLoginForRegister(String login) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        client.setLoginForRegister(login);

        realm.commitTransaction();
    }

    @Override
    public String getLoginForRegister() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        String login = client.getLoginForRegister();

        realm.commitTransaction();
        return login;
    }

    @Override
    public String getToken() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String token = tableFields.getToken();

        realm.commitTransaction();
        return token;
    }

    @Override
    public void setToken(String token) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setToken(token);

        realm.commitTransaction();
    }

    @Override
    public int getDiscount() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();

        int discount = tableFields.getDiscount();

        realm.commitTransaction();
        return discount;
    }

    @Override
    public void setDiscount(int discount) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setDiscount(discount);

        realm.commitTransaction();
    }

    @Override
    public int getCarId() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        int carId = tableFields.getCarId();

        realm.commitTransaction();
        return carId;
    }

    @Override
    public void setCarId(int id) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setCarId(id);

        realm.commitTransaction();
    }

    @Override
    public long getLastUpdateTime() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        long time = tableFields.getLastMessageTime();

        realm.commitTransaction();
        return time;
    }

    @Override
    public void setLastUpdateTime(long time) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setLastMessageTime(time);

        realm.commitTransaction();
    }

    @Override
    public void setCreditCard(boolean isAvailable) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setIsCreditCards(isAvailable);

        realm.commitTransaction();
    }

    @Override
    public boolean getCreditCard() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        boolean isCreditCards = tableFields.getIsCreditCards();

        realm.commitTransaction();
        return isCreditCards;
    }

    @Override
    public void setConnected(boolean connected) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setIsConnected(connected);

        realm.commitTransaction();
    }

    @Override
    public boolean getConnected() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        boolean isConnected = tableFields.getIsConnected();

        realm.commitTransaction();
        return isConnected;
    }

    @Override
    public void setLatitude(float lat) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setLat(lat);

        realm.commitTransaction();
    }

    @Override
    public float getLatitude() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        float lat = tableFields.getLat();

        realm.commitTransaction();
        return lat;
    }

    @Override
    public void setLongitude(float lng) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setLng(lng);

        realm.commitTransaction();
    }

    @Override
    public float getLongitude() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        float lng = tableFields.getLng();

        realm.commitTransaction();
        return lng;
    }

    @Override
    public void setCurrentMessageJson(String originalJsonString) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setMessageJson(originalJsonString);

        realm.commitTransaction();
    }

    @Override
    public String getCurrentMessageJson() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String jsonMessage = tableFields.getMessageJson();

        realm.commitTransaction();
        return jsonMessage;
    }

    @Override
    public void setInviteMessageJson(String originalJsonString) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setMessageJsonInvite(originalJsonString);

        realm.commitTransaction();
    }

    @Override
    public String getInviteMessageJson() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String jsonMessage = tableFields.getMessageJsonInvite();

        realm.commitTransaction();
        return jsonMessage;
    }

    @Override
    public void setLastCurrentTripAction(String action) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setTripAction(action);

        realm.commitTransaction();
    }

    @Override
    public String getLastCurrentTripAction() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String tripAction = tableFields.getTripAction();

        realm.commitTransaction();
        return tripAction;
    }

    @Override
    public void setVisibilityRadius(int visibilityRadius) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setVisibilityRadius(visibilityRadius);

        realm.commitTransaction();
    }

    @Override
    public int getVisibilityRadius() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        int radius = tableFields.getVisibilityRadius();

        realm.commitTransaction();
        return radius;
    }

    @Override
    public void setIsoLanguage(String langIso) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setIsoLanguage(langIso);

        realm.commitTransaction();
    }

    @Override
    public String getIsoLanguage() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String language = tableFields.getIsoLanguage();

        realm.commitTransaction();
        return language;
    }

    @Override
    public void setIsoCountry(String isoCountry) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setIsoCountry(isoCountry);

        realm.commitTransaction();
    }

    @Override
    public String getIsoCountry() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String country = tableFields.getIsoCountry();

        realm.commitTransaction();
        return country;
    }

    @Override
    public void setLastNewsUpdate(String time) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setLastNewsUpdate(time);

        realm.commitTransaction();
    }

    @Override
    public String getLastNewsUpdate() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String time = tableFields.getLastNewsUpdate();

        realm.commitTransaction();
        return time;
    }

    @Override
    public void setCompleted(String value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setCompleted(value);

        realm.commitTransaction();
    }

    @Override
    public String getCompleted() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String value = tableFields.getCompleted();

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setKmPassed(String value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setKmPassed(value);

        realm.commitTransaction();
    }

    @Override
    public String getKmPassed() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String value = tableFields.getKmPassed();

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setCancelledByMe(String value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setCancelledByMe(value);

        realm.commitTransaction();
    }

    @Override
    public String getCancelledByMe() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String value = tableFields.getCancelledByMe();

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setCancelledBySmth(String value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setCancelledBySmth(value);

        realm.commitTransaction();
    }

    @Override
    public String getCancelledBySmth() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String value = tableFields.getCancelledBySmth();

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setCommission(String value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setCommission(value);

        realm.commitTransaction();
    }

    @Override
    public String getCommission() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String value = tableFields.getCommission();

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setStatsRating(String value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setSetStatsRating(value);

        realm.commitTransaction();
    }

    @Override
    public String getStatsRating() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String value = tableFields.getSetStatsRating();

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setStatsBigLikes(String value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setBigLikes(value);

        realm.commitTransaction();
    }

    @Override
    public String getStatsBigLikes() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String value = tableFields.getBigLikes();

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setStatsSmallLikes(String value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setSmallLikes(value);

        realm.commitTransaction();
    }

    @Override
    public String getStatsSmallLikes() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String value = tableFields.getSmallLikes();

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setStatisticStart(long value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setStatsStart(value);

        realm.commitTransaction();
    }

    @Override
    public long getStatisticStart() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        long value = tableFields.getStatsStart();
        if (value == 0) {
            value = calendar.getTimeInMillis();
        }

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setOrderStart(long value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        client.setOrderStart(value);

        realm.commitTransaction();
    }

    @Override
    public long getOrderStart() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        long value = client.getOrderStart();

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setStatisticEnd(long value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setStatsEnd(value);

        realm.commitTransaction();
    }

    @Override
    public long getStatisticEnd() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        long value = tableFields.getStatsEnd();
        if (value == 0) {
            value = System.currentTimeMillis();
        }

        realm.commitTransaction();
        return value;
    }

    @Override
    public void clearStatisticDates() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setStatsEnd(0);

        realm.commitTransaction();
    }

    @Override
    public void setPostponedTimeStart(long value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setPostponedTimeStart(value);

        realm.commitTransaction();
    }

    @Override
    public long getPostponedTimeStart() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        long value = tableFields.getPostponedTimeStart();
        if (value == 0) {
            value = System.currentTimeMillis() - (1000 * 60 * 60 * 24 * 7);
        }

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setPostponedTimeEnd(long value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setPostponedTimeEnd(value);

        realm.commitTransaction();
    }

    @Override
    public long getPostponedTimeEnd() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        long value = tableFields.getPostponedTimeEnd();
        if (value == 0) {
            value = System.currentTimeMillis();
        }

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setFilterDistance(String value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setFilterDistance(value);

        realm.commitTransaction();
    }

    @Override
    public String getFilterDistance() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String value = tableFields.getFilterDistance();
        if (value.equals("")) {
            value = "5";
        }

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setFilterRadius(String value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setFilterRad(value);

        realm.commitTransaction();
    }

    @Override
    public String getFilterRatingFrom() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        String value = client.getFilterRatingFrom();
        if (value.equals("")) {
            value = "0";
        }

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setFilterRatingFrom(String value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        client.setFilterRatingFrom(value);

        realm.commitTransaction();
    }

    @Override
    public String getFilterRatingTo() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        String value = client.getFilterRatingTo();
        if (value.equals("")) {
            value = "5";
        }

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setFilterRatingTo(String value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        client.setFilterRatingTo(value);

        realm.commitTransaction();
    }

    @Override
    public void setFilterCards(boolean value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        client.setFilterCardsAvailable(value);

        realm.commitTransaction();
    }

    @Override
    public boolean getFilterCards() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        boolean value = client.getFilterCardsAvailable();

        realm.commitTransaction();
        return value;
    }

    @Override
    public String getFilterRadius() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        String value = tableFields.getFilterRad();

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setPostponedStart(long value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setPostStart(value);

        realm.commitTransaction();
    }

    @Override
    public long getPostponedStart() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        long value = tableFields.getPostStart();

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setPostponedEnd(long value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        tableFields.setPostEnd(value);

        realm.commitTransaction();
    }

    @Override
    public long getPostponedEnd() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmTableFields tableFields = realm.where(RealmTableFields.class).findFirst();
        long value = tableFields.getPostEnd();

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setAppClient(boolean value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        client.setIsClientApp(value);

        realm.commitTransaction();
    }

    @Override
    public boolean getIsAppClient() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        boolean value = client.getIsClientApp();

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setImageRegister(String value) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        client.setImageRegister(value);

        realm.commitTransaction();
    }

    @Override
    public String getImageRegister() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        String value = client.getImageRegister();

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setLastZoom(float lastZoom) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        client.setZoom(lastZoom);

        realm.commitTransaction();
    }

    @Override
    public float getLastZoom() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        float value = client.getZoom();
        if (value == 0) value = 12;

        realm.commitTransaction();
        return value;
    }

    @Override
    public void setDifBetweenServerTime(long dif) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        client.setDifBetweenServerTime(dif);

        realm.commitTransaction();
    }

    @Override
    public long getDifBetweenServerTime() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        long value = client.getDifBetweenServerTime();
        if (value == 0) value = -1;

        realm.commitTransaction();
        return value;
    }
}
