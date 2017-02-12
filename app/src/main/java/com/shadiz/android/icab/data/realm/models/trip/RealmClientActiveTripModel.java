package com.shadiz.android.icab.data.realm.models.trip;

import io.realm.RealmObject;

/**
 * Created on 11.02.2017.
 */

public class RealmClientActiveTripModel extends RealmObject {

    private RealmClientTripModel clientTrip;

    public RealmClientTripModel getClientTrip() {
        return clientTrip;
    }

    public void setClientTrip(RealmClientTripModel clientTrip) {
        this.clientTrip = clientTrip;
    }
}
