package com.shadiz.android.icab.data.repositories.network.driver;

import android.content.Context;

import com.google.gson.Gson;
import com.shadiz.android.icab.data.repositories.network.driver.models.request.confirm_order.ConfirmOrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.driver.models.response.order_confirm.OrderConfirmationModelResponse;

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

    public Call<OrderConfirmationModelResponse> setDriverOrderConfirmation(ConfirmOrderModelRequest confirmOrderModelRequest) {
        return driverApi.setDriverOrderConfirmation(confirmOrderModelRequest.getDevice_uuid(), confirmOrderModelRequest.getLogin(), confirmOrderModelRequest.getDevice_platform(), new Gson().toJson(confirmOrderModelRequest.getMessage()));
    }
}
