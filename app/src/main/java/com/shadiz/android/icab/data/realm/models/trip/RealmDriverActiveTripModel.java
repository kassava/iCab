package com.shadiz.android.icab.data.realm.models.trip;

import io.realm.RealmObject;

/**
 * Created on 11.02.2017.
 */

public class RealmDriverActiveTripModel extends RealmObject {

    private RealmDriverTripModel driverTrip;

    private String dateFinished;

    public RealmDriverTripModel getDriverTrip() {
        return driverTrip;
    }

    public void setDriverTrip(RealmDriverTripModel driverTrip) {
        this.driverTrip = driverTrip;
    }

    public String getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(String dateFinished) {
        this.dateFinished = dateFinished;
    }
}
