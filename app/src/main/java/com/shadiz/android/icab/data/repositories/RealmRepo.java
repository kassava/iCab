package com.shadiz.android.icab.data.repositories;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;
import com.shadiz.android.icab.dagger.Injector;
import com.shadiz.android.icab.data.realm.models.RealmClientModel;
import com.shadiz.android.icab.data.realm.models.RealmTableFields;
import com.shadiz.android.icab.data.realm.table.ClientTable;

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
    private Realm realm;

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

        realm = Realm.getDefaultInstance();
        getRealmTableFieldsModel();
        getRealmClientModel();
    }

    /**
     * Create start realm recording if it don't exist.
     * @return Realm table fields object.
     */
    private RealmTableFields getRealmTableFieldsModel() {
        final RealmTableFields[] realmTableFields = {realm.where(RealmTableFields.class).findFirst()};
        if (realmTableFields[0] == null) {
            realm.executeTransaction(realm1 -> {
                realmTableFields[0] = new RealmTableFields();
                realmTableFields[0].setId("0");
                realm.copyToRealmOrUpdate(realmTableFields[0]);
            });
        }
        return  realmTableFields[0];
    }

    /**
     * Create start realm recording if it don't exist.
     * @return Realm client object.
     */
    private RealmClientModel getRealmClientModel() {
        final RealmClientModel[] realmClientModel = {realm.where(RealmClientModel.class).findFirst()};
        if (realmClientModel[0] == null) {
            realm.executeTransaction(realm1 -> {
                realmClientModel[0] = new RealmClientModel();
                realmClientModel[0].setId("0");
                realm.copyToRealmOrUpdate(realmClientModel[0]);
            });
        }
        return  realmClientModel[0];
    }

    @Override
    public void removeClientObject() {
        realm.executeTransaction(realm1 -> {
            RealmQuery<RealmClientModel> query = realm.where(RealmClientModel.class);
            RealmResults<RealmClientModel> results = query.findAll();
            results.deleteFirstFromRealm();
        });
    }

    @Override
    public void resetClientStartInfo() {
        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        realm.executeTransaction(realm1 -> {
            client.setMapPickupTime("");
            client.setMapStartPointPostLat(0);
            client.setMapStartPointPostLon(0);
            client.setMapStartPointPostGeocode("");
            client.setMapEndPointPostLat(0);
            client.setMapEndPointPostLon(0);
            client.setMapEndPointPostGeocode("");
        });
    }

    @Override
    public void setClientKey(String key, String value) {
        RealmClientModel client = getRealmClientModel();
        realm.executeTransaction(realm1 -> {
            if (key.equals(ClientTable.MAP_LAST_ACTION_TYPE)) {
                client.setMapLastActionType(value);
            }
            if (key.equals(ClientTable.MAP_ORDER_TYPE)) {
                client.setMapOrderType(value);
            }
            if (key.equals(ClientTable.MAP_COMMENT)) {
                client.setMapComment(value);
            }
            if (key.equals(ClientTable.MAP_ORDER_DRIVER_POSITION)) {
                client.setMapOrderDriverPosition(value);
            }
            if (key.equals(ClientTable.LAST_SELECTED_DRIVER)) {
                client.setLastSelectedDriver(value);
            }
            if (key.equals(ClientTable.MAP_PICKUP_TIME)) {
                client.setMapPickupTime(value);
            }
            if (key.equals(ClientTable.MAP_SEATS)) {
                client.setMapSeats(value);
            }
            if (key.equals(ClientTable.MAP_PRICE)) {
                client.setMapPrice(value);
            }
            if (key.equals(ClientTable.MAP_TRIP_CURRENCY)) {
                client.setMapTripCurrency(value);
            }
            if (key.equals(ClientTable.MAP_ORDER_ID)) {
                client.setMapOrderId(value);
            }
            if (key.equals(ClientTable.MAP_TRIP_TIME)) {
                client.setMapTripTime(value);
            }
            if (key.equals(ClientTable.MAP_TRIP_LENGTH)) {
                client.setMapTripLength(value);
            }
        });
    }

    @Override
    public String getClientKey(String key) {
        RealmClientModel client = realm.where(RealmClientModel.class).findFirst();
        if (key.equals(ClientTable.MAP_COMMENT)) {
            return client.getMapComment();
        }
        if (key.equals(ClientTable.MAP_ORDER_DRIVER_POSITION)) {
            return client.getMapOrderDriverPosition();
        }
        if (key.equals(ClientTable.MAP_LAST_ACTION_TYPE)) {
            return client.getMapLastActionType();
        }
        if (key.equals(ClientTable.LAST_SELECTED_DRIVER)) {
            return client.getLastSelectedDriver();
        }
        if (key.equals(ClientTable.MAP_ORDER_TYPE)) {
            return client.getMapOrderType();
        }
        if (key.equals(ClientTable.MAP_PICKUP_TIME)) {
            return client.getMapPickupTime();
        }
        if (key.equals(ClientTable.MAP_SEATS)) {
            return client.getMapSeats();
        }
        if (key.equals(ClientTable.MAP_PRICE)) {
            return client.getMapPrice();
        }
        if (key.equals(ClientTable.MAP_TRIP_CURRENCY)) {
            return client.getMapTripCurrency();
        }
        if (key.equals(ClientTable.MAP_ORDER_ID)) {
            return client.getMapOrderId();
        }
        if (key.equals(ClientTable.MAP_TRIP_LENGTH)) {
            return client.getMapTripLength();
        }
        if (key.equals(ClientTable.MAP_TRIP_TIME)) {
            return client.getMapTripTime();
        }
        return "";
    }

    @Override
    public void setLatLngGeoCode(String key, LatLng ll, String geo) {
        RealmClientModel client = getRealmClientModel();
        realm.executeTransaction(realm1 -> {
            if (key.equals(ClientTable.MAP_START_POINT)) {
                client.setMapStartPointPostLat((float) ll.latitude);
                client.setMapStartPointPostLon((float) ll.longitude);
                client.setMapStartPointPostGeocode(geo);
            }
            if (key.equals(ClientTable.MAP_END_POINT)) {
                client.setMapEndPointPostLat((float) ll.latitude);
                client.setMapEndPointPostLon((float) ll.longitude);
                client.setMapEndPointPostGeocode(geo);
            }
        });
    }

    @Override
    public LatLng getLatLng(String key) {
        RealmClientModel client = getRealmClientModel();
        LatLng ll = null;
        if (key.equals(ClientTable.MAP_START_POINT)) {
            ll = new LatLng(client.getMapStartPointPostLat(), client.getMapStartPointPostLon());
            if (ll.longitude == 0.0f || ll.latitude == 0.0f) {
                return null;
            }
        }
        if (key.equals(ClientTable.MAP_END_POINT)) {
            ll = new LatLng(client.getMapEndPointPostLat(), client.getMapEndPointPostLon());
            if (ll.longitude == 0.0f || ll.latitude == 0.0f) {
                return null;
            }
        }
        return ll;
    }

    @Override
    public void setPickClientLatLng(LatLng ll) {
        realm.executeTransaction(realm1 -> {
            getRealmClientModel().setPickClientLocationPostLat((float) ll.latitude);
            getRealmClientModel().setPickClientLocationPostLon((float) ll.longitude);
        });
    }

    @Override
    public LatLng getPickClientLatLng() {
        return new LatLng(getRealmClientModel().getPickClientLocationPostLat(),
                getRealmClientModel().getPickClientLocationPostLon());
    }

    @Override
    public String getGeocode(String key) {
        RealmClientModel client = getRealmClientModel();
        String geocode = null;
        if (key.equals(ClientTable.MAP_START_POINT)) {
            geocode = client.getMapStartPointPostGeocode();
        }
        if (key.equals(ClientTable.MAP_END_POINT)) {
            geocode = client.getMapEndPointPostGeocode();
        }
        if (geocode != null && geocode.equals("")) {
            geocode = "not set";
        }
        return geocode;
    }

    @Override
    public long getServiceStopTime() {
        return getRealmTableFieldsModel().getStopServiceTime();
    }

    @Override
    public void setServiceStopTime(long time) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setStopServiceTime(time));
    }

    @Override
    public void setLogin(String login) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setLogin(login));
    }

    @Override
    public String getLogin() {
        return getRealmTableFieldsModel().getLogin();
    }

    @Override
    public void setPostponedCount(int postponedCount) {
        realm.executeTransaction(realm1 ->
                getRealmTableFieldsModel().setPostponedCount(postponedCount));
    }

    @Override
    public int getPostponedCount() {
        return getRealmTableFieldsModel().getPostponedCount();
    }

    @Override
    public void setLoginForRegister(String login) {
        realm.executeTransaction(realm1 -> getRealmClientModel().setLoginForRegister(login));
    }

    @Override
    public String getLoginForRegister() {
        return getRealmClientModel().getLoginForRegister();
    }

    @Override
    public String getToken() {
        return getRealmTableFieldsModel().getToken();
    }

    @Override
    public void setToken(String token) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setToken(token));
    }

    @Override
    public int getDiscount() {
        return getRealmTableFieldsModel().getDiscount();
    }

    @Override
    public void setDiscount(int discount) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setDiscount(discount));
    }

    @Override
    public int getCarId() {
        return getRealmTableFieldsModel().getCarId();
    }

    @Override
    public void setCarId(int id) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setCarId(id));
    }

    @Override
    public long getLastUpdateTime() {
        return getRealmTableFieldsModel().getLastMessageTime();
    }

    @Override
    public void setLastUpdateTime(long time) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setLastMessageTime(time));
    }

    @Override
    public void setCreditCard(boolean isAvailable) {
        realm.executeTransaction(realm1 ->
                getRealmTableFieldsModel().setIsCreditCards(isAvailable));
    }

    @Override
    public boolean getCreditCard() {
        return getRealmTableFieldsModel().getIsCreditCards();
    }

    @Override
    public void setConnected(boolean connected) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setIsConnected(connected));
    }

    @Override
    public boolean getConnected() {
        return getRealmTableFieldsModel().getIsConnected();
    }

    @Override
    public void setLatitude(float lat) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setLat(lat));
    }

    @Override
    public float getLatitude() {
        return getRealmTableFieldsModel().getLat();
    }

    @Override
    public void setLongitude(float lng) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setLng(lng));
    }

    @Override
    public float getLongitude() {
        return getRealmTableFieldsModel().getLng();
    }

    @Override
    public void setCurrentMessageJson(String originalJsonString) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setMessageJson(originalJsonString));
    }

    @Override
    public String getCurrentMessageJson() {
        return getRealmTableFieldsModel().getMessageJson();
    }

    @Override
    public void setInviteMessageJson(String originalJsonString) {
        realm.executeTransaction(realm1 ->
                getRealmTableFieldsModel().setMessageJsonInvite(originalJsonString));
    }

    @Override
    public String getInviteMessageJson() {
        return getRealmTableFieldsModel().getMessageJsonInvite();
    }

    @Override
    public void setLastCurrentTripAction(String action) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setTripAction(action));
    }

    @Override
    public String getLastCurrentTripAction() {
        return getRealmTableFieldsModel().getTripAction();
    }

    @Override
    public void setVisibilityRadius(int radius) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setVisibilityRadius(radius));
    }

    @Override
    public int getVisibilityRadius() {
        return getRealmTableFieldsModel().getVisibilityRadius();
    }

    @Override
    public void setIsoLanguage(String langIso) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setIsoLanguage(langIso));
    }

    @Override
    public String getIsoLanguage() {
        return getRealmTableFieldsModel().getIsoLanguage();
    }

    @Override
    public void setIsoCountry(String isoCountry) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setIsoCountry(isoCountry));
    }

    @Override
    public String getIsoCountry() {
        return getRealmTableFieldsModel().getIsoCountry();
    }

    @Override
    public void setLastNewsUpdate(String time) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setLastNewsUpdate(time));
    }

    @Override
    public String getLastNewsUpdate() {
        return getRealmTableFieldsModel().getLastNewsUpdate();
    }

    @Override
    public void setCompleted(String value) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setCompleted(value));
    }

    @Override
    public String getCompleted() {
        return getRealmTableFieldsModel().getCompleted();
    }

    @Override
    public void setKmPassed(String value) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setKmPassed(value));
    }

    @Override
    public String getKmPassed() {
        return getRealmTableFieldsModel().getKmPassed();
    }

    @Override
    public void setCancelledByMe(String value) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setCancelledByMe(value));
    }

    @Override
    public String getCancelledByMe() {
        return getRealmTableFieldsModel().getCancelledByMe();
    }

    @Override
    public void setCancelledBySmth(String value) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setCancelledBySmth(value));
    }

    @Override
    public String getCancelledBySmth() {
        return getRealmTableFieldsModel().getCancelledBySmth();
    }

    @Override
    public void setCommission(String value) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setCommission(value));
    }

    @Override
    public String getCommission() {
        return getRealmTableFieldsModel().getCommission();
    }

    @Override
    public void setStatsRating(String value) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setSetStatsRating(value));
    }

    @Override
    public String getStatsRating() {
        return getRealmTableFieldsModel().getSetStatsRating();
    }

    @Override
    public void setStatsBigLikes(String value) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setBigLikes(value));
    }

    @Override
    public String getStatsBigLikes() {
        return getRealmTableFieldsModel().getBigLikes();
    }

    @Override
    public void setStatsSmallLikes(String value) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setSmallLikes(value));
    }

    @Override
    public String getStatsSmallLikes() {
        return getRealmTableFieldsModel().getSmallLikes();
    }

    @Override
    public void setStatisticStart(long value) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setStatsStart(value));
    }

    @Override
    public long getStatisticStart() {
        return getRealmTableFieldsModel().getStatsStart();
    }

    @Override
    public void setOrderStart(long value) {
        realm.executeTransaction(realm1 -> getRealmClientModel().setOrderStart(value));
    }

    @Override
    public long getOrderStart() {
        return getRealmClientModel().getOrderStart();
    }

    @Override
    public void setStatisticEnd(long value) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setStatsEnd(value));
    }

    @Override
    public long getStatisticEnd() {
        return getRealmTableFieldsModel().getStatsEnd();
    }

    @Override
    public void clearStatisticDates() {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setStatsEnd(-1));
    }

    @Override
    public void setPostponedTimeStart(long value) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setPostponedTimeStart(value));
    }

    @Override
    public long getPostponedTimeStart() {
        return getRealmTableFieldsModel().getPostponedTimeStart();
    }

    @Override
    public void setPostponedTimeEnd(long value) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setPostponedTimeEnd(value));
    }

    @Override
    public long getPostponedTimeEnd() {
        return getRealmTableFieldsModel().getPostponedTimeEnd();
    }

    @Override
    public void setFilterDistance(String value) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setFilterDistance(value));
    }

    @Override
    public String getFilterDistance() {
        return getRealmTableFieldsModel().getFilterDistance();
    }

    @Override
    public void setFilterRadius(String value) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setFilterRad(value));
    }

    @Override
    public String getFilterRatingFrom() {
        return getRealmClientModel().getFilterRatingFrom();
    }

    @Override
    public void setFilterRatingFrom(String value) {
        realm.executeTransaction(realm1 -> getRealmClientModel().setFilterRatingFrom(value));
    }

    @Override
    public String getFilterRatingTo() {
        return getRealmClientModel().getFilterRatingTo();
    }

    @Override
    public void setFilterRatingTo(String value) {
        realm.executeTransaction(realm1 -> getRealmClientModel().setFilterRatingTo(value));
    }

    @Override
    public void setFilterCards(boolean value) {
        realm.executeTransaction(realm1 -> getRealmClientModel().setFilterCardsAvailable(value));
    }

    @Override
    public boolean getFilterCards() {
        return getRealmClientModel().getFilterCardsAvailable();
    }

    @Override
    public String getFilterRadius() {
        return getRealmTableFieldsModel().getFilterRad();
    }

    @Override
    public void setPostponedStart(long value) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setPostStart(value));
    }

    @Override
    public long getPostponedStart() {
        return getRealmTableFieldsModel().getPostStart();
    }

    @Override
    public void setPostponedEnd(long value) {
        realm.executeTransaction(realm1 -> getRealmTableFieldsModel().setPostEnd(value));
    }

    @Override
    public long getPostponedEnd() {
        return getRealmTableFieldsModel().getPostEnd();
    }

    @Override
    public void setAppClient(boolean value) {
        realm.executeTransaction(realm1 -> getRealmClientModel().setIsClientApp(value));
    }

    @Override
    public boolean getIsAppClient() {
        return getRealmClientModel().getIsClientApp();
    }

    @Override
    public void setImageRegister(String value) {
        realm.executeTransaction(realm1 -> getRealmClientModel().setImageRegister(value));
    }

    @Override
    public String getImageRegister() {
        return getRealmClientModel().getImageRegister();
    }

    @Override
    public void setLastZoom(float lastZoom) {
        realm.executeTransaction(realm1 -> getRealmClientModel().setZoom(lastZoom));
    }

    @Override
    public float getLastZoom() {
        return getRealmClientModel().getZoom();
    }

    @Override
    public void setDifBetweenServerTime(long dif) {
        realm.executeTransaction(realm1 -> getRealmClientModel().setDifBetweenServerTime(dif));
    }

    @Override
    public long getDifBetweenServerTime() {
        return getRealmClientModel().getDifBetweenServerTime();
    }
}
