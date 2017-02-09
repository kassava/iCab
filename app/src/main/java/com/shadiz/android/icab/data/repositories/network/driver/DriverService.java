package com.shadiz.android.icab.data.repositories.network.driver;

import android.content.Context;

import com.google.gson.Gson;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.OrderCancelerModelResponse;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.driver.models.request.current_order.ConfirmOrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.order.CancelOrderRequest;
import com.shadiz.android.icab.data.repositories.network.driver.models.request.trip_info.DriverTripInfoRequest;
import com.shadiz.android.icab.data.repositories.network.driver.models.response.current_confirm.OrderConfirmationModelResponse;
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
    public Call<OrderConfirmationModelResponse> setDriverOrderConfirmation(ConfirmOrderModelRequest confirmOrderModelRequest) {
        return driverApi.setDriverOrderConfirmation(confirmOrderModelRequest.getDevice_uuid(), confirmOrderModelRequest.getLogin(), confirmOrderModelRequest.getDevice_platform(), new Gson().toJson(confirmOrderModelRequest.getMessage()));
    }

    /**
     * driverServer_userWantsToOrderTaxi_disagree
     *
     * @param disagreeConfirmOrderModelRequest
     * @return
     */
    public Call<OrderConfirmationModelResponse> setDriverOrderDisagreeConfirmation(ConfirmOrderModelRequest disagreeConfirmOrderModelRequest) {
        return driverApi.setDriverOrderConfirmation(disagreeConfirmOrderModelRequest.getDevice_uuid(), disagreeConfirmOrderModelRequest.getLogin(), disagreeConfirmOrderModelRequest.getDevice_platform(), new Gson().toJson(disagreeConfirmOrderModelRequest.getMessage()));
    }

    /**
     * driverServer_userWantsToCancelOrder_agree
     *
     * @param cancelOrderModelRequest
     * @return
     */
    public Call<OrderCancelerModelResponse> setCanceleCurrentOrder(CancelOrderRequest cancelOrderModelRequest) {
        return driverApi.setCanceledOrder(cancelOrderModelRequest.getDevice_uuid(), cancelOrderModelRequest.getLogin(), cancelOrderModelRequest.getDevice_platform(), new Gson().toJson(cancelOrderModelRequest.getMessage()));
    }

    /**
     * driverServer_taxiSetOffToTheClient_agree
     *
     * @param orderModelRequest
     * @return
     */
    public Call<OrderConfirmationModelResponse> setOffToTheClient(OrderModelRequest orderModelRequest) {
        return driverApi.setDriverOrderConfirmation(orderModelRequest.getDevice_uuid(), orderModelRequest.getLogin(), orderModelRequest.getDevice_platform(), new Gson().toJson(orderModelRequest.getMessage()));
    }
    /**
     * driverGetTripsInfo
     *
     * @param driverTripInfoRequest
     * @return
     */
    public Call<DriverTripResponse> getDriverTripsInfo(DriverTripInfoRequest driverTripInfoRequest) {
        return driverApi.getDriverTripsInfo(driverTripInfoRequest.getDevice_uuid(), driverTripInfoRequest.getLogin(),
                driverTripInfoRequest.getDevice_platform(), new Gson().toJson(driverTripInfoRequest.getTripFilter()),
                driverTripInfoRequest.getTripClientInRadiusMeters(), driverTripInfoRequest.getTripMaxDistanceMeters());

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


}
