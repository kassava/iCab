package com.shadiz.android.icab.data.repositories;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.android.gms.maps.model.LatLng;
import com.shadiz.android.icab.R;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created on 30.01.2017.
 */

public class PrefsRepo extends BaseRepository {

    private Context context;

    public PrefsRepo(Context context) {
        this.context = context;
    }

    public void removeClientObject() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().remove(MAP_LAST_ACTION_TYPE).apply();
        prefs.edit().remove(PREF_LOGIN).apply();
        prefs.edit().remove(PREF_LOGIN_FOR_REGISTER).apply();
        prefs.edit().remove(MAP_ORDER_TYPE).apply();
        prefs.edit().remove(MAP_SELECTED_DRIVER).apply();
        prefs.edit().remove(MAP_PICKUP_TIME).apply();
        prefs.edit().remove(MAP_SEATS).apply();
        prefs.edit().remove(MAP_COMMENT).apply();
        prefs.edit().remove(MAP_TRIP_LENGTH).apply();
        prefs.edit().remove(MAP_TRIP_TIME).apply();
        prefs.edit().remove(MAP_PRICE).apply();
        prefs.edit().remove(MAP_ORDER_ID).apply();
        prefs.edit().remove(MAP_ORDER_DRIVER_POSITION).apply();
        prefs.edit().remove(MAP_ORDER_DRIVER_INFO).apply();
        prefs.edit().remove(MAP_LAST_ACTION_TYPE).apply();
        prefs.edit().remove(LAST_SELECTED_DRIVER).apply();
    }

    public void resetClientStartInfo() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().remove(MAP_PICKUP_TIME).apply();
        prefs.edit().remove(MAP_START_POINT + POST_LAT).apply();
        prefs.edit().remove(MAP_START_POINT + POST_LON).apply();
        prefs.edit().remove(MAP_START_POINT + POST_GEOCODE).apply();
        prefs.edit().remove(MAP_END_POINT + POST_LAT).apply();
        prefs.edit().remove(MAP_END_POINT + POST_LON).apply();
        prefs.edit().remove(MAP_END_POINT + POST_GEOCODE).apply();
    }

    public void setClientKey(String key, String value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(key, value).apply();
    }

    public void setLatLngGeoCode(String key, LatLng ll, String geo) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putFloat(key + POST_LAT, (float) ll.latitude).apply();
        prefs.edit().putFloat(key + POST_LON, (float) ll.longitude).apply();
        prefs.edit().putString(key + POST_GEOCODE, geo).apply();
    }

    public LatLng getLatLng(String key) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        LatLng ll = new LatLng(prefs.getFloat(key + POST_LAT, 0.0f),
                prefs.getFloat(key + POST_LON, 0.0f));
        if (ll.longitude == 0.0f || ll.latitude == 0.0f) {
            return null;
        }
        return ll;
    }

    public void setPickClientLatLng(LatLng ll) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putFloat(PICK_CLIENT_LOCATION + POST_LAT, (float) ll.latitude).apply();
        prefs.edit().putFloat(PICK_CLIENT_LOCATION + POST_LON, (float) ll.longitude).apply();
    }

    public LatLng getPickClientLatLng() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return new LatLng(prefs.getFloat(PICK_CLIENT_LOCATION + POST_LAT, 0.0f), prefs.getFloat(PICK_CLIENT_LOCATION + POST_LON, 0.0f));
    }

    public String getGeocode(String key) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(key + POST_GEOCODE, context.getString(R.string.not_set));
    }

    public String getClientKey(String key) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(key, "");
    }

    public long getServiceStopTime() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getLong(PREF_STOP_SERVICE_TIME, -1);
    }

    public void setServiceStopTime(long time) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putLong(PREF_STOP_SERVICE_TIME, time).apply();
    }

    public void setLogin(String text) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_LOGIN, text).apply();
    }

    public String getLogin() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_LOGIN, "");
    }

    public void setPostponedCount(int postponedCount) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putInt(PREF_POSTPONED_COUNT, postponedCount).apply();
    }

    public int getPostponedCount() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getInt(PREF_POSTPONED_COUNT, 0);
    }

    public void setLoginForRegister(String text) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_LOGIN_FOR_REGISTER, text).apply();
    }

    public String getLoginForRegister() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_LOGIN_FOR_REGISTER, "");
    }

    public String getToken() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_TOKEN, "");
    }

    public void setToken(String text) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_TOKEN, text).apply();
    }

    public int getDiscount() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getInt(PREF_DISCOUNT, 0);
    }

    public void setDiscount(int text) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putInt(PREF_DISCOUNT, text).apply();
    }

    public int getCarId() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context
                .MODE_PRIVATE);
        return prefs.getInt(PREF_CAR_ID, -1);
    }

    public void setCarId(int id) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putInt(PREF_CAR_ID, id).apply();
    }

    public long getLastUpdateTime() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getLong(PREF_LAST_MESSAGE_TIME, -1);
    }

    public void setLastUpdateTime(long time) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putLong(PREF_LAST_MESSAGE_TIME, time).apply();
    }

    public void setCreditCard(boolean isAvailable) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(PREF_IS_CREDIT_CARDS, isAvailable).apply();
    }

    public boolean getCreditCard() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getBoolean(PREF_IS_CREDIT_CARDS, false);
    }

    public void setConnected(boolean connected) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(PREF_IS_CONNECTED, connected).apply();
    }

    public boolean getConnected() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getBoolean(PREF_IS_CONNECTED, false);
    }

    public void setLatitude(float lat) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putFloat(PREF_LAT, lat).apply();
    }

    public float getLatitude() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getFloat(PREF_LAT, 0); // LocationManager.DEF_LAT
    }

    public void setLongitude(float lon) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putFloat(PREF_LNG, lon).apply();
    }

    public float getLongitude() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getFloat(PREF_LNG, 0); // Location.DEF_LON
    }

    public void setCurrentMessageJson(String originalJsonString) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_MESSAGE_JSON, originalJsonString).apply();
    }

    public String getCurrentMessageJson() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_MESSAGE_JSON, null);
    }

    public void setInviteMessageJson(String originalJsonString) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_MESSAGE_JSON_INVITE, originalJsonString).apply();
    }

    public String getInviteMessageJson() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_MESSAGE_JSON_INVITE, null);
    }

    public void setLastCurrentTripAction(String action) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_TRIP_ACTION, action).apply();
    }

    public String getLastCurrentTripAction() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_TRIP_ACTION, null);
    }

    public void setVisibilityRadius(int mVisibilityRadius) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putInt(PREF_VISIBILITY_RADUIS, mVisibilityRadius).apply();
    }

    public int getVisibilityRadius() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getInt(PREF_VISIBILITY_RADUIS, 5000);
    }

    public void setIsoLanguage(String langIso) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_ISO_LANGUAGE, langIso).apply();
    }

    public String getIsoLanguage() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_ISO_LANGUAGE, Locale.getDefault().getLanguage().toLowerCase());
    }

    public void setIsoCountry(String countryIso) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_ISO_COUNTRY, countryIso).apply();
    }

    public String getIsoCountry() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_ISO_COUNTRY, Locale.getDefault().getISO3Country());
    }


    public void setLastNewsUpdate(String time) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_LAST_NEWS_UPDATE, time).apply();
    }

    public String getLastNewsUpdate() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_LAST_NEWS_UPDATE, "2015-01-01 15:40:51");
    }

    public void setCompleted(String value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_COMPLETED, value).apply();
    }

    public String getCompleted() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_COMPLETED, "-");
    }

    public void setKmPassed(String value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_KM_PASSED, value).apply();
    }

    public String getKmPassed() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_KM_PASSED, "-");
    }

    public void setCancelledByMe(String value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_CANCELLED_BY_ME, value).apply();
    }

    public String getCancelledByMe() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_CANCELLED_BY_ME, "-");
    }

    public void setCancelledBySmth(String value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_CANCELLED_BY_SMTH, value).apply();
    }

    public String getCancelledBySmth() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_CANCELLED_BY_SMTH, "-");
    }

    public void setCommission(String value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_COMISSION, value).apply();
    }

    public String getCommission() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_COMISSION, "-");
    }

    public void setStatsRating(String value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_SET_STATS_RATING, value).apply();

    }

    public String getStatsRating() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_SET_STATS_RATING, "0");
    }

    public void setStatsBigLikes(String value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREFS_BIG_LIKES, value).apply();

    }

    public String getStatsBigLikes() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREFS_BIG_LIKES, "0");
    }

    public void setStatsSmallLikes(String value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREFS_SMALL_LIKES, value).apply();
    }

    public String getStatsSmallLikes() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREFS_SMALL_LIKES, "0");
    }

    public void setStatisticStart(long value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putLong(PREFS_STATS_START, value).apply();
    }

    public long getStatisticStart() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        return prefs.getLong(PREFS_STATS_START, calendar.getTimeInMillis());
    }

    public void setOrderStart(long value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putLong(PREFS_ORDER_START, value).apply();
    }

    public long getOrderStart() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getLong(PREFS_ORDER_START, -1);
    }

    public void setStatisticEnd(long value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putLong(PREF_STATS_END, value).apply();

    }

    public long getStatisticEnd() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getLong(PREF_STATS_END, System.currentTimeMillis());
    }

    public void clearStatisticDates() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().remove(PREF_STATS_END).remove(PREFS_STATS_START).apply();
    }

    public void setPostponedTimeStart(long value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putLong(PREF_POSTPONED_TIME_START, value).apply();
    }

    public long getPostponedTimeStart() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getLong(PREF_POSTPONED_TIME_START, System.currentTimeMillis() -
                (1000 * 60 * 60 * 24 * 7)); //7 days backport
    }

    public void setPostponedTimeEnd(long value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putLong(PREF_POSTPONED_TIME_END, value).apply();

    }

    public long getPostponedTimeEnd() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getLong(PREF_POSTPONED_TIME_END, System.currentTimeMillis());
    }

    public void setFilterDistance(String value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_FILTER_DISTANCE, value).apply();
    }

    public String getFilterDistance() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_FILTER_DISTANCE, "5");
    }

    public void setFilterRadius(String value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_FILTER_RAD, value).apply();

    }

    public String getFilterRatingFrom() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_FILTER_RATING_FROM, "0");
    }

    public void setFilterRatingFrom(String value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_FILTER_RATING_FROM, value).apply();

    }

    public String getFilterRatingTo() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_FILTER_RATING_TO, "5");
    }

    public void setFilterRatingTo(String value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_FILTER_RATING_TO, value).apply();
    }

    public void setFilterCards(boolean b) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(PREF_FILTER_CARDS_AVAILABLE, b).apply();

    }

    public boolean getFilterCards() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getBoolean(PREF_FILTER_CARDS_AVAILABLE, false);
    }

    public String getFilterRadius() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_FILTER_RAD, "5");
    }

    public void setPostponedStart(long value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putLong(PREF_POST_START, value).apply();

    }

    public long getPostponedStart() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getLong(PREF_POST_START, 0);
    }

    public void setPostponedEnd(long value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putLong(PREF_POST_END, value).apply();

    }

    public long getPostponedEnd() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getLong(PREF_POST_END, System.currentTimeMillis());
    }

    public void setAppClient(boolean b) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(PREF_IS_CLIENT_APP, b).apply();
    }

    public boolean getIsAppClient() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getBoolean(PREF_IS_CLIENT_APP, false);
    }

    public void setImageRegister(String value) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putString(PREF_IMAGE_REGISTER, value).apply();
    }

    public String getImageRegister() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(PREF_IMAGE_REGISTER, "");
    }

    public void setLastZoom(float lastZoom) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putFloat(PREF_ZOOM, lastZoom).apply();
    }

    public float getLastZoom() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getFloat(PREF_ZOOM, 12);
    }

    public void setDifBetweenServerTime(long dif) {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        prefs.edit().putFloat(DIF_BETWEEN_SERVER_TIME, dif).apply();
    }

    public long getDifBetweenServerTime() {
        SharedPreferences prefs = context.getSharedPreferences(COMMON_TAXI_DRIVER_PREFS, Context.MODE_PRIVATE);
        return prefs.getLong(DIF_BETWEEN_SERVER_TIME, -1);
    }
}
