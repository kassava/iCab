package com.shadiz.android.icab.data.repositories.network.client;


import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shadiz.android.icab.data.repositories.network.client.models.request.rate_order.TripRaterRequest;
import com.shadiz.android.icab.data.repositories.network.client.models.request.trip_info.ClientTripsInfoRequest;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.CanceledOrderResponseModel;
import com.shadiz.android.icab.data.repositories.network.client.models.response.rate_after_trip.ClientNewOrderCreatorResponseModel;
import com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info.TripInfoResponseModel;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageRequestModel;
import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.driver.models.request.current_order.StatusOrderModelRequest;

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
     * Create trip - clientServer_userWantsToOrderTaxi_agree
     *
     * @param tripModelRequest
     * @return
     */
    public Call<ClientNewOrderCreatorResponseModel> getNewTripId(OrderModelRequest tripModelRequest) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        Log.d("ClientService", gson.toJson(tripModelRequest.getMessage()));
        return clientApi.getTripId(tripModelRequest.getDevice_uuid(), tripModelRequest.getLogin(), tripModelRequest.getDevice_platform(), gson.toJson(tripModelRequest.getMessage()));
    }

    /**
     * clientServer_userWantsToCancelOrder_agree
     *
     * @param cancelOrderModelRequest
     * @return
     */
    public Call<CanceledOrderResponseModel> getIdCanceledOrder(StatusOrderModelRequest cancelOrderModelRequest) {
        return clientApi.getIdCanceledOrder(cancelOrderModelRequest.getDevice_uuid(), cancelOrderModelRequest.getLogin(), cancelOrderModelRequest.getDevice_platform(), new Gson().toJson(cancelOrderModelRequest.getMessage()));
    }

    /**
     * Sync message
     *
     * @param messageSyncModelRequest
     * @return
     */
    public Call<SyncMessageModelResponse> getStatusClientOrders(SyncMessageRequestModel messageSyncModelRequest) {
        return clientApi.getStatusOrders(messageSyncModelRequest.getDate_from(), messageSyncModelRequest.getDevice_uuid(), messageSyncModelRequest.getLogin(), messageSyncModelRequest.getDevice_platform());
    }

    /**
     * clientServer_rateDriverAfterTrip_agree
     *
     * @param tripRaterRequest
     * @return
     */
    public Call<ClientNewOrderCreatorResponseModel> setRateDriverAfterTrip(TripRaterRequest tripRaterRequest) {
        return clientApi.setRateDriverAfterTrip(tripRaterRequest.getDevice_uuid(), tripRaterRequest.getLogin(), tripRaterRequest.getDevice_platform(), new Gson().toJson(tripRaterRequest.getMessage()));
    }

    /**
     * @param clientTripsInfoRequest
     * @return
     */
    public Call<TripInfoResponseModel> getClientTripsInfo(ClientTripsInfoRequest clientTripsInfoRequest) {
        return clientApi.getClientTripsInfo(clientTripsInfoRequest.getDevice_uuid(), clientTripsInfoRequest.getLogin(), clientTripsInfoRequest.getDevice_platform(), clientTripsInfoRequest.getTripFilter());
    }
}