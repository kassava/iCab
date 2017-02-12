package com.shadiz.android.icab.data.realm.models.trip;

import io.realm.RealmObject;

/**
 * Created on 11.02.2017.
 */

public class RealmClientPostponedTripModel extends RealmObject {

    private RealmClientTripModel clientTrip;

    private String phone;

    public RealmClientTripModel getClientTrip() {
        return clientTrip;
    }

    public void setClientTrip(RealmClientTripModel clientTrip) {
        this.clientTrip = clientTrip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
