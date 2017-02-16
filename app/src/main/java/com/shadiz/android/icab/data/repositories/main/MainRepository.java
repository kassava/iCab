package com.shadiz.android.icab.data.repositories.main;


import com.shadiz.android.icab.data.repositories.network.client.models.request.trip_info.ClientTripsInfoRequest;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.CanceledOrderModelResponse;
import com.shadiz.android.icab.data.repositories.network.client.models.response.rate_after_trip.NewOrderCreatorModelResponse;
import com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info.TripInfoResponse;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.order.CancelOrderRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.main.DriverModel;

import rx.Observable;

/**
 * Created on 28.01.2017.
 */

public interface MainRepository {

    Observable<DriverModel> getDrivers();

    Observable<TripInfoResponse> getClientTripsInfo(ClientTripsInfoRequest request);

    Observable<NewOrderCreatorModelResponse> getIdNewOrder(OrderModelRequest request);

    Observable<CanceledOrderModelResponse> getIdCanceledOrder(CancelOrderRequest request);

    Observable<SyncMessageModelResponse> getStatusOfClientOrders(SyncMessageModelRequest request);

    Observable<SyncMessageModelResponse> getStatusDriversOrders(SyncMessageModelRequest request);

}
