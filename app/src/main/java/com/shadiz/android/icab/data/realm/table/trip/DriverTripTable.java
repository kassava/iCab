package com.shadiz.android.icab.data.realm.table.trip;

/**
 * Created on 11.02.2017.
 */

public interface DriverTripTable extends TripTable {

    String CLIENT_ID = "client_id";
    String IS_POSTPONED = "is_postponed";
    String DATE_CREATED = "date_created";
    String DATE_UPDATED = "date_updated";
    String IS_REMOTE = "is_remote";
    String CLIENT_INFO = "client_info";
    String REMOTE_PHONE = "remote_phone";
    String REMOTE_NAME = "remote_name";
    String REMOTE_PAYCC = "remote_paycc";
    String UNIQUE_DRIVER = "unique_driver";
    String UNIQUE_SENT = "unique_sent";
    String LAST_OFFERED_DRIVER = "last_offered_driver";
    String COST = "cost";
}
