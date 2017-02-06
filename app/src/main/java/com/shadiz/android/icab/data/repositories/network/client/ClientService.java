package com.shadiz.android.icab.data.repositories.network.client;


import android.content.Context;

import com.google.gson.Gson;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageModelRequest;
import com.shadiz.android.icab.data.repositories.network.client.models.request.cancel_order.OrderCancelerModelRequest;
import com.shadiz.android.icab.data.repositories.network.client.models.request.create_order.CreateOrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.client.models.request.rate_order.TripRaterRequest;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.OrderCancelerModelResponse;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.OrderCreatorModelResponse;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.client.models.response.rate_after_trip.TripRaterResponse;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created on 11.01.17.
 */

public class ClientService {
    @Inject
    Context context;
    @Inject
    ClientApi clientApi;

    public ClientService(ClientApi taxiApi) {
        this.clientApi = taxiApi;
    }
    /**
     * Create trip
     * @param tripModelRequest
     * @return
     */
    public Call<OrderCreatorModelResponse> getTripId(CreateOrderModelRequest tripModelRequest) {
          return clientApi.getTripId(tripModelRequest.getDevice_uuid(), tripModelRequest.getLogin(), tripModelRequest.getDevice_platform(), new Gson().toJson(tripModelRequest.getMessage()));
    }
    /**
     * Sync message
     * @param messageSyncModelRequest
     * @return
     */
    public Call<SyncMessageModelResponse> getStatusMessage(SyncMessageModelRequest messageSyncModelRequest) {
        return clientApi.getStatusMessage(messageSyncModelRequest.getDate_from(), messageSyncModelRequest.getDevice_uuid(), messageSyncModelRequest.getLogin(), messageSyncModelRequest.getDevice_platform());
    }
    /**
     * userWantsToCancelOrder_agree
     * @param cancelOrderModelRequest
     * @return
     */
    public Call<OrderCancelerModelResponse> setCanceledOrderResult(OrderCancelerModelRequest cancelOrderModelRequest) {
        return clientApi.setCanceledOrder(cancelOrderModelRequest.getDevice_uuid(), cancelOrderModelRequest.getLogin(), cancelOrderModelRequest.getDevice_platform(), new Gson().toJson(cancelOrderModelRequest.getMessage()));
    }
    /**
     * userWantsToCancelOrder_agree
     * @param tripRaterRequest
     * @return
     */
    public Call<TripRaterResponse> setRateDriverAfterTrip(TripRaterRequest tripRaterRequest) {
        return clientApi.setRateDriverAfterTrip(tripRaterRequest.getDevice_uuid(), tripRaterRequest.getLogin(), tripRaterRequest.getDevice_platform(), new Gson().toJson(tripRaterRequest.getMessage()));
    }
}
