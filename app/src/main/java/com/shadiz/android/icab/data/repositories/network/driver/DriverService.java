package com.shadiz.android.icab.data.repositories.network.driver;

import android.content.Context;

import com.google.gson.Gson;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.driver.models.request.current_order.ConfirmOrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.driver.models.response.current_confirm.OrderConfirmationModelResponse;

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
    public Call<OrderConfirmationModelResponse> setDriverOrderConfirmation(ConfirmOrderModelRequest confirmOrderModelRequest) {
        return driverApi.setDriverOrderConfirmation(confirmOrderModelRequest.getDevice_uuid(), confirmOrderModelRequest.getLogin(), confirmOrderModelRequest.getDevice_platform(), new Gson().toJson(confirmOrderModelRequest.getMessage()));
    }

    /**
     * driverServer_userWantsToOrderTaxi_agree
     *
     * @param confirmOrderModelRequest
     * @return
     */
    public Call<OrderConfirmationModelResponse> setOffToTheClient(ConfirmOrderModelRequest confirmOrderModelRequest) {
        return driverApi.setDriverOrderConfirmation(confirmOrderModelRequest.getDevice_uuid(), confirmOrderModelRequest.getLogin(), confirmOrderModelRequest.getDevice_platform(), new Gson().toJson(confirmOrderModelRequest.getMessage()));
    }

    /**
     * driverClient_orderStatusChanged_agree
     *
     * @param syncMessageModelRequest
     * @return
     */
    public Call<SyncMessageModelResponse> setStatusOrder(SyncMessageModelRequest syncMessageModelRequest) {
        return driverApi.setStatusOrder(syncMessageModelRequest.getDate_from(), syncMessageModelRequest.getDevice_uuid(), syncMessageModelRequest.getLogin(), syncMessageModelRequest.getDevice_platform());
    }

//    public Call<OrderConfirmationModelResponse> setOffToTheClient(ConfirmOrderModelRequest confirmOrderModelRequest) {
//        return driverApi.setDriverOrderConfirmation(confirmOrderModelRequest.getDevice_uuid(), confirmOrderModelRequest.getLogin(), confirmOrderModelRequest.getDevice_platform(), new Gson().toJson(confirmOrderModelRequest.getMessage()));
//    }
}
