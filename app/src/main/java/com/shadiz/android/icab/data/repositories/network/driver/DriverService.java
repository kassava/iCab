package com.shadiz.android.icab.data.repositories.network.driver;

import android.content.Context;

import com.google.gson.Gson;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageRequestModel;
import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.driver.models.request.current_order.StatusOrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.driver.models.request.trip_info.DriverTripInfoRequest;
import com.shadiz.android.icab.data.repositories.network.driver.models.response.current_confirm.StatusOrderResponseModel;
import com.shadiz.android.icab.data.repositories.network.driver.models.response.trip_info.DriverTripResponse;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by OldMan on 05.02.2017.
 */

public class DriverService {
    @Inject
    Context context;
    @Inject
    DriverApi driverApi;

    public DriverService(DriverApi driverApi) {
        this.driverApi = driverApi;
    }

    /**
     * driverServer_userWantsToOrderTaxi_agree
     *
     * @param confirmOrderModelRequest
     * @return
     */
    public Call<StatusOrderResponseModel> getStatusDriverOrder(StatusOrderModelRequest confirmOrderModelRequest) {
        return driverApi.getStatusDriverOrder(confirmOrderModelRequest.getDevice_uuid(), confirmOrderModelRequest.getLogin(), confirmOrderModelRequest.getDevice_platform(), new Gson().toJson(confirmOrderModelRequest.getMessage()));
    }

    /**
     * driverServer_taxiSetOffToTheClient_agree
     *
     * @param orderModelRequest
     * @return
     */
    public Call<StatusOrderResponseModel> setOffToTheClient(OrderModelRequest orderModelRequest) {
        return driverApi.getStatusDriverOrder(orderModelRequest.getDevice_uuid(), orderModelRequest.getLogin(), orderModelRequest.getDevice_platform(), new Gson().toJson(orderModelRequest.getMessage()));
    }

    /**
     * driverGetTripsInfo
     *
     * @param driverTripInfoRequest
     * @return
     */
    public Call<DriverTripResponse> getDriverTripsInfo(DriverTripInfoRequest driverTripInfoRequest) {
        return driverApi.getDriverTripsInfo(driverTripInfoRequest.getDevice_uuid(), driverTripInfoRequest.getLogin(),
                driverTripInfoRequest.getDevice_platform(), driverTripInfoRequest.getTripFilter(),
                driverTripInfoRequest.getTripClientInRadiusMeters(), driverTripInfoRequest.getTripMaxDistanceMeters());

    }

    /**
     * driverClient_orderStatusChanged_agree
     *
     * @param syncMessageModelRequest
     * @return
     */
    public Call<SyncMessageModelResponse> getListNewOrders(SyncMessageRequestModel syncMessageModelRequest) {
        return driverApi.getListDriverOrders(syncMessageModelRequest.getDate_from(), syncMessageModelRequest.getDevice_uuid(), syncMessageModelRequest.getLogin(), syncMessageModelRequest.getDevice_platform());
    }


}