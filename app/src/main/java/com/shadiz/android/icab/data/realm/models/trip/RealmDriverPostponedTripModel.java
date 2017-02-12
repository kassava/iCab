package com.shadiz.android.icab.data.realm.models.trip;

import io.realm.RealmObject;

/**
 * Created on 11.02.2017.
 */

public class RealmDriverPostponedTripModel extends RealmObject {

    private RealmDriverTripModel driverTrip;

    public RealmDriverTripModel getDriverTrip() {
        return driverTrip;
    }

    public void setDriverTrip(RealmDriverTripModel driverTrip) {
        this.driverTrip = driverTrip;
    }
}
