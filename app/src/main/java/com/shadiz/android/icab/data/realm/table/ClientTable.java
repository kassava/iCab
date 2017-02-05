package com.shadiz.android.icab.data.realm.table;

/**
 * Created on 05.02.2017.
 */

public interface ClientTable {

    String ID = "id";

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
