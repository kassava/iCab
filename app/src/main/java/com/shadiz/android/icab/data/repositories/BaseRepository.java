package com.shadiz.android.icab.data.repositories;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created on 30.01.2017.
 */

public abstract class BaseRepository {

    public static final String COMMON_TAXI_DRIVER_PREFS = "common_taxi_driver_prefs";
    protected static final String PREF_LOGIN = "login_driver_string";
    protected static final String PREF_TOKEN = "login_driver_token";
    protected static final String PREF_DISCOUNT = "sale_driver";
    protected static final String PREF_LAST_MESSAGE_TIME = "last_message_time";
    protected static final String PREF_STOP_SERVICE_TIME = "stop_service_time";

    public static final String PREF_IS_EMPTY = " pref. is empty";
    protected static final String PREF_IS_CREDIT_CARDS = "credit_cards_is_available";
    protected static final String PREF_IS_CONNECTED = "PREF_IS_CONNECTED";
    public static final String PREF_POSTPONED_COUNT = "pref_postponed_count";

    public static final String PREF_LAT = "pref_lat";
    public static final String PREF_LNG = "pref_lon";
    public static final String PREF_TRIP_ID = "pref_trip_id";
    public static final String PREF_MESSAGE_JSON = "pref_message_json_current";
    public static final String PREF_TRIP_ACTION = "pref_trip_action";
    public static final String PREF_MESSAGE_JSON_INVITE = "pref_message_json_invite";
    public static final String PREF_VISIBILITY_RADUIS = "pref_visibility_raduis";
    public static final String PREF_CAR_ID = "pref_car_id";
    public static final String PREF_ISO_LANGUAGE = "pref_iso_language";
    public static final String PREF_ISO_COUNTRY = "pref_iso_country";
    public static final String PREF_LAST_NEWS_UPDATE = "pref_last_news_update";
    public static final String PREF_COMPLETED = "pref_completed";
    public static final String PREF_KM_PASSED = "pref_km_passed";
    public static final String PREF_CANCELLED_BY_ME = "pref_cancelled_by_me";
    public static final String PREF_CANCELLED_BY_SMTH = "pref_cancelled_by_smth";
    public static final String PREF_COMISSION = "pref_comission";
    public static final String PREF_SET_STATS_RATING = "pref_set_stats_rating";
    public static final String PREFS_BIG_LIKES = "prefs_big_likes";
    public static final String PREFS_SMALL_LIKES = "prefs_small_likes";
    public static final String PREFS_STATS_START = "prefs_stats_start";
    public static final String PREF_STATS_END = "pref_stats_end";
    public static final String PREF_POST_END = "pref_post_end";
    public static final String PREF_POST_START = "pref_post_start";
    public static final String PREF_POSTPONED_TIME_END = "pref_PostponedTime_end";
    public static final String PREF_POSTPONED_TIME_START = "pref_PostponedTime_start";
    public static final String PREF_FILTER_DISTANCE = "pref_filter_distance";
    public static final String PREF_FILTER_RAD = "pref_filter_rad";

    // RealmClientModel object field names
    public static final String MAP_LAST_ACTION_TYPE = "map_client_action_type";
    public static final String MAP_ORDER_TYPE = "map_client_order_type";
    public static final String MAP_SELECTED_DRIVER = "map_client_selected_driver";
    public static final String MAP_PICKUP_TIME = "map_client_pickup_time";
    public static final String MAP_SEATS = "map_client_seats";
    public static final String MAP_COMMENT = "map_client_comment";
    public static final String MAP_TRIP_LENGTH = "map_client_trip_length";
    public static final String MAP_TRIP_TIME = "map_client_trip_time";
    public static final String MAP_PRICE = "map_client_price";
    public static final String MAP_TRIP_CURRENCY = "map_client_currency";
    public static final String MAP_START_POINT = "map_client_start_point";
    public static final String MAP_END_POINT = "map_client_end_point";
    public static final String POST_LAT = "_lat";
    public static final String POST_LON = "_lon";
    public static final String POST_GEOCODE = "_geocode";
    public static final String PREF_IS_CLIENT_APP = "PREF_IS_CLIENT_APP";
    public static final String MAP_ORDER_ID = "MAP_ORDER_ID";
    public static final String MAP_ORDER_DRIVER_POSITION = "MAP_ORDER_DRIVER_POSITION";
    public static final String MAP_ORDER_DRIVER_INFO = "MAP_ORDER_DRIVER_INFO";
    public static final String PREFS_ORDER_START = "PREFS_ORDER_START";
    public static final String PREF_IMAGE_REGISTER = "PREF_IMAGE_REGISTER";
    public static final String PREF_FILTER_RATING_FROM = "PREF_FILTER_RATING_FROM";
    public static final String PREF_FILTER_RATING_TO = "PREF_FILTER_RATING_TO";
    public static final String PREF_FILTER_CARDS_AVAILABLE = "PREF_FILTER_CARDS_AVAILABLE";
    public static final String PREF_LOGIN_FOR_REGISTER = "PREF_LOGIN_FOR_REGISTER";
    public static final String PREF_ZOOM = "PREF_ZOOM";
    public static final String PICK_CLIENT_LOCATION = "PICK_CLIENT_LOCATION_";
    public static final String DIF_BETWEEN_SERVER_TIME = "DIF_BETWEEN_SERVER_TIME";
    public static String LAST_SELECTED_DRIVER = "LAST_SELECTED_DRIVER";

    protected Context context;

    public BaseRepository(Context context) {
        this.context = context;
    }

    public abstract void removeClientObject();

    public abstract void resetClientStartInfo();

    public abstract void setClientKey(String key, String value);

    public abstract void setLatLngGeoCode(String key, LatLng ll, String geo);

    public abstract LatLng getLatLng(String key);

    public abstract void setPickClientLatLng(LatLng ll);

    public abstract LatLng getPickClientLatLng();

    public abstract String getGeocode(String key);

    public abstract String getClientKey(String key);

    public abstract long getServiceStopTime();

    public abstract void setServiceStopTime(long time);

    public abstract void setLogin(String text);

    public abstract String getLogin();

    public abstract void setPostponedCount(int postponedCount);

    public abstract int getPostponedCount();

    public abstract void setLoginForRegister(String text);

    public abstract String getLoginForRegister();

    public abstract String getToken();

    public abstract void setToken(String text);

    public abstract int getDiscount();

    public abstract void setDiscount(int text);

    public abstract int getCarId();

    public abstract void setCarId(int id);

    public abstract long getLastUpdateTime();

    public abstract void setLastUpdateTime(long time);

    public abstract void setCreditCard(boolean isAvailable);

    public abstract boolean getCreditCard();

    public abstract void setConnected(boolean connected);

    public abstract boolean getConnected();

    public abstract void setLatitude(float lat);

    public abstract float getLatitude();

    public abstract void setLongitude(float lon);

    public abstract float getLongitude();

    public abstract void setCurrentMessageJson(String originalJsonString);

    public abstract String getCurrentMessageJson();

    public abstract void setInviteMessageJson(String originalJsonString);

    public abstract String getInviteMessageJson();

    public abstract void setLastCurrentTripAction(String action);

    public abstract String getLastCurrentTripAction();

    public abstract void setVisibilityRadius(int mVisibilityRadius);

    public abstract int getVisibilityRadius();

    public abstract void setIsoLanguage(String langIso) ;

    public abstract String getIsoLanguage() ;

    public abstract void setIsoCountry(String countryIso);

    public abstract String getIsoCountry();

    public abstract void setLastNewsUpdate(String time);

    public abstract String getLastNewsUpdate();

    public abstract void setCompleted(String value);

    public abstract String getCompleted();

    public abstract void setKmPassed(String value);

    public abstract String getKmPassed();

    public abstract void setCancelledByMe(String value);

    public abstract String getCancelledByMe();

    public abstract void setCancelledBySmth(String value);

    public abstract String getCancelledBySmth();

    public abstract void setCommission(String value);

    public abstract String getCommission();

    public abstract void setStatsRating(String value);

    public abstract String getStatsRating();

    public abstract void setStatsBigLikes(String value);

    public abstract String getStatsBigLikes();

    public abstract void setStatsSmallLikes(String value);

    public abstract String getStatsSmallLikes();

    public abstract void setStatisticStart(long value);

    public abstract long getStatisticStart();

    public abstract void setOrderStart(long value);

    public abstract long getOrderStart();

    public abstract void setStatisticEnd(long value);

    public abstract long getStatisticEnd();

    public abstract void clearStatisticDates();

    public abstract void setPostponedTimeStart(long value);

    public abstract long getPostponedTimeStart();

    public abstract void setPostponedTimeEnd(long value);

    public abstract long getPostponedTimeEnd();

    public abstract void setFilterDistance(String value);

    public abstract String getFilterDistance();

    public abstract void setFilterRadius(String value);

    public abstract String getFilterRatingFrom();

    public abstract void setFilterRatingFrom(String value);

    public abstract String getFilterRatingTo();

    public abstract void setFilterRatingTo(String value);

    public abstract void setFilterCards(boolean b);

    public abstract boolean getFilterCards();

    public abstract String getFilterRadius();

    public abstract void setPostponedStart(long value);

    public abstract long getPostponedStart();

    public abstract void setPostponedEnd(long value);

    public abstract long getPostponedEnd();

    public abstract void setAppClient(boolean b);

    public abstract boolean getIsAppClient();

    public abstract void setImageRegister(String value);

    public abstract String getImageRegister();

    public abstract void setLastZoom(float lastZoom);

    public abstract float getLastZoom();

    public abstract void setDifBetweenServerTime(long dif);

    public abstract long getDifBetweenServerTime();
}
