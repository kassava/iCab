package com.shadiz.android.icab.data.repositories.network;

import android.content.Context;

import com.shadiz.android.icab.data.repositories.network.models.request.CreateTripModel;
import com.shadiz.android.icab.data.repositories.network.models.request.MessageModel;
import com.shadiz.android.icab.data.repositories.network.models.response.TripModel;

import javax.inject.Inject;

import retrofit2.Call;


/**
 * Created on 11.01.17.
 */

public class TaxiService {
    @Inject
    Context context;
    @Inject
    TaxiApi taxiApi;

    public TaxiService(TaxiApi taxiApi) {
        this.taxiApi = taxiApi;
    }

    public Call<TripModel> getOrder(CreateTripModel order) {
        return taxiApi.getTripId(order);
    }
}
