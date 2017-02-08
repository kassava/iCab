package com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.BaseResult;

import java.util.ArrayList;

/**
 * Created by oldman on 06.02.17.
 */

public class TripInfoResult extends BaseResult {
    @SerializedName("activeTrip")
    @Expose
    ArrayList<ActiveTripModel> activeTrip;
    @SerializedName("postponedTrips")
    @Expose
    ArrayList<PostponedTripModel> postponedTrips;
    @SerializedName("acceptedPostponedTrips")
    @Expose
    ArrayList<ActiveTripModel> acceptedPostponedTrips;

    public ArrayList<ActiveTripModel> getActiveTrip() {
        return activeTrip;
    }

    public void setActiveTrip(ArrayList<ActiveTripModel> activeTrip) {
        this.activeTrip = activeTrip;
    }

    public ArrayList<ActiveTripModel> getAcceptedPostponedTrips() {
        return acceptedPostponedTrips;
    }

    public void setAcceptedPostponedTrips(ArrayList<ActiveTripModel> acceptedPostponedTrips) {
        this.acceptedPostponedTrips = acceptedPostponedTrips;
    }

    public ArrayList<PostponedTripModel> getPostponedTrips() {
        return postponedTrips;
    }

    public void setPostponedTrips(ArrayList<PostponedTripModel> postponedTrips) {
        this.postponedTrips = postponedTrips;
    }



}
