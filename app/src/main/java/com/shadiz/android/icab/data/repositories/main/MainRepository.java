package com.shadiz.android.icab.data.repositories.main;


import com.shadiz.android.icab.data.repositories.network.client.models.request.trip_info.ClientTripsInfoRequest;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.CanceledOrderResponseModel;
import com.shadiz.android.icab.data.repositories.network.client.models.response.rate_after_trip.ClientNewOrderCreatorResponseModel;
import com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info.TripInfoResponseModel;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageRequestModel;
import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.driver.models.request.current_order.StatusOrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.driver.models.request.trip_info.DriverTripInfoRequest;
import com.shadiz.android.icab.data.repositories.network.driver.models.response.current_confirm.StatusOrderResponseModel;
import com.shadiz.android.icab.data.repositories.network.driver.models.response.trip_info.DriverTripResponse;
import com.shadiz.android.icab.data.repositories.network.main.DriverModel;

import rx.Observable;

/**
 * Created on 28.01.2017.
 */

public interface MainRepository {

    Observable<DriverModel> getDrivers();

    Observable<TripInfoResponseModel> getClientTripsInfo(ClientTripsInfoRequest request);

    Observable<ClientNewOrderCreatorResponseModel> getIdNewOrder(OrderModelRequest request);

    Observable<CanceledOrderResponseModel> getIdCanceledOrder(StatusOrderModelRequest request);

    Observable<SyncMessageModelResponse> getStatusOfClientOrders(SyncMessageRequestModel request);

    Observable<SyncMessageModelResponse> getStatusDriversOrders(SyncMessageRequestModel request);

    Observable<DriverTripResponse> getDriversTripsInfo(DriverTripInfoRequest request);

    Observable<StatusOrderResponseModel> getIdDriversAgreeToOrder(StatusOrderModelRequest request);

    Observable<StatusOrderResponseModel> getDriverCancelOrder(StatusOrderModelRequest statusOrderModelRequest);
}
