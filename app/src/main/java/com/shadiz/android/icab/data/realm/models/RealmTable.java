package com.shadiz.android.icab.data.realm.models;

/**
 * Created on 01.02.17.
 */

public interface RealmTable {

    String ID = "id";

    interface RealmClientModel {
        String MAP_LAST_ACTION_TYPE = "mapLastActionType";
        String MAP_ORDER_TYPE = "mapOrderType";
        String MAP_SELECTED_DRIVER = "mapSelectedDriver";
        String MAP_PICKUP_TIME = "mapPickupTime";
        String MAP_SEATS = "mapSeats";
        String MAP_COMMENT = "mapComment";
        String MAP_TRIP_LENGTH = "mapTripLength";
        String MAP_TRIP_TIME = "mapTripTime";
        String MAP_PRICE = "mapPrice";
        String MAP_TRIP_CURRENCY = "mapTripCurrency";
        String MAP_START_POINT = "mapStartPoint";
        String MAP_END_POINT = "mapEndPoint";
        String MAP_ORDER_ID = "mapOrderId";
        String MAP_ORDER_DRIVER_POSITION = "mapOrderDriverPosition";
        String MAP_ORDER_DRIVER_INFO = "mapOrderDriverInfo";
        String ORDER_START = "orderStart";
        String POST_LAT = "postLat";
        String POST_LON = "postLon";
        String POST_GEOCODE = "postGeocode";
        String IS_CLIENT_APP = "isClientApp";
        String IMAGE_REGISTER = "imageRegister";
        String FILTER_RATING_FROM = "filterRatingFrom";
        String FILTER_RATING_TO = "filterRatingTo";
        String FILTER_CARDS_AVAILABLE = "filterCardsAvailable";
        String LOGIN_FOR_REGISTER = "loginForRegister";
        String ZOOM = "zoom";
        String PICK_CLIENT_LOCATION = "pickClientLocation";
        String DIF_BETWEEN_SERVER_TIME = "difBetweenServerTime";
        String LAST_SELECTED_DRIVER = "lastSelectedDriver";

        String MAP_START_POINT_POST_LAT = "mapStartPointPostLat";
        String MAP_START_POINT_POST_LON = "mapStartPointPostLon";
        String MAP_START_POINT_POST_GEOCODE = "mapStartPointPostGeocode";
        String MAP_END_POINT_POST_LAT = "mapEndPointPostLat";
        String MAP_END_POINT_POST_LON = "mapEndPointPostLon";
        String MAP_END_POINT_POST_GEOCODE = "mapEndPointPostGeocode";
    }

    interface RealmTableFields {
        String COMMON_TAXI_DRIVER = "commonTaxiDriver";
        String LOGIN = "login";
        String TOKEN = "token";
        String DISCOUNT = "discount";
        String LAST_MESSAGE_TIME = "lastMassageTime";
        String STOP_SERVICE_TIME = "stopServiceTime";

        String IS_EMPTY = "isCreditCards";
        String IS_CREDIT_CARDS = "isConnected";
        String IS_CONNECTED = "postponedCount";

        String LAT = "lat"; // PREF_LAT
        String LNG = "lng"; // PREF_LNG
        String TRIP_ID = "tripId"; // TRIP_ID
        String MESSAGE_JSON = "messageJson"; // PREF_MESSAGE_JSON
        String TRIP_ACTION = "tripAction"; // PREF_TRIP_ACTION
        String MESSAGE_JSON_INVITE = "messageJsonInvite"; // PREF_MESSAGE_JSON_INVITE
        String VISIBILITY_RADUIS = "visibilityRadius"; // PREF_VISIBILITY_RADUIS
        String CAR_ID = "carId"; // PREF_CAR_ID
        String ISO_LANGUAGE = "isoLanguage"; // PREF_ISO_LANGUAGE
        String ISO_COUNTRY = "isoCountry"; // PREF_ISO_COUNTRY
        String LAST_NEWS_UPDATE = "lastNewsUpdate"; // PREF_LAST_NEWS_UPDATE
        String IS_COMPLETED = "isCompleted"; // PREF_COMPLETED
        String KM_PASSED = "kmPassed"; // PREF_KM_PASSED
        String CANCELLED_BY_ME = "cancelledByMe"; // PREF_CANCELLED_BY_ME
        String CANCELLED_BY_SMTH = "cancelledBySmth"; // PREF_CANCELLED_BY_SMTH
        String COMMISSION = "commission"; // PREF_COMISSION
        String SET_STATS_RATING = "setStatsRating"; // PREF_SET_STATS_RATING
        String BIG_LIKES = "bigLikes"; // PREFS_BIG_LIKES
        String SMALL_LIKES = "smallLikes"; // PREFS_SMALL_LIKES
        String STATS_START = "statsStart"; // PREFS_STATS_START
        String STATS_END = "statsEnd"; // PREF_STATS_END
        String POST_END = "postEnd"; // PREF_POST_END
        String POST_START = "postStart"; // PREF_POST_START
        String POSTPONED_TIME_END = "postponedTimeEnd"; // PREF_POSTPONED_TIME_END
        String POSTPONED_TIME_START = "postponedTimeStart"; // PREF_POSTPONED_TIME_START
        String FILTER_DISTANCE = "filterDistance"; // PREF_FILTER_DISTANCE
        String FILTER_RAD = "filterRad"; // PREF_FILTER_RAD
        String PICK_CLIENT_LOCATION_POST_LAT = "pickClientLocationPostLat";
        String PICK_CLIENT_LOCATION_POST_LON = "pickClientLocationPostLon";
    }
}
