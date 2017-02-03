package com.shadiz.android.icab.data.repositories.network;


import android.content.Context;

import com.google.gson.Gson;
import com.shadiz.android.icab.data.repositories.network.models.request.client.MessageSyncModelRequest;
import com.shadiz.android.icab.data.repositories.network.models.request.client.TripModelRequest;
import com.shadiz.android.icab.data.repositories.network.models.responce.client.create_trip.TripModelResponse;
import com.shadiz.android.icab.data.repositories.network.models.responce.client.message_sync.SyncMessageModelResponce;
import com.shadiz.android.icab.data.repositories.network.models.responce.client.message_sync.SyncMessageResult;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created on 11.01.17.
 */

public class TaxiService {
    @Inject
    Context context;
    @Inject
    ClientApi taxiApi;

    public TaxiService(ClientApi taxiApi) {
        this.taxiApi = taxiApi;
    }

    /**
     * Create trip
     * @param tripModelRequest
     * @return
     */
    public Call<TripModelResponse> getTripId(TripModelRequest tripModelRequest) {
          return taxiApi.getTripId(tripModelRequest.getDevice_uuid(), tripModelRequest.getLogin(), tripModelRequest.getDevice_platform(), new Gson().toJson(tripModelRequest.getMessage()));
    }

    /**
     * Sync message
     * @param messageSyncModelRequest
     * @return
     */
    public Call<SyncMessageModelResponce> getStatusMessage(MessageSyncModelRequest messageSyncModelRequest) {
        return taxiApi.getStatusMessage(messageSyncModelRequest.getDate_from(), messageSyncModelRequest.getDevice_uuid(), messageSyncModelRequest.getLogin(), messageSyncModelRequest.getDevice_platform());
    }

}
