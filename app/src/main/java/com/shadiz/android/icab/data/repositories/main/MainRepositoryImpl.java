package com.shadiz.android.icab.data.repositories.main;


import com.shadiz.android.icab.ICabApp;
import com.shadiz.android.icab.data.repositories.network.client.ClientService;
import com.shadiz.android.icab.data.repositories.network.client.models.request.trip_info.ClientTripsInfoRequest;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.CanceledOrderModelResponse;
import com.shadiz.android.icab.data.repositories.network.client.models.response.rate_after_trip.NewOrderCreatorModelResponse;
import com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info.TripInfoResponse;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.order.CancelOrderRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.driver.DriverService;
import com.shadiz.android.icab.data.repositories.network.main.CarModel;
import com.shadiz.android.icab.data.repositories.network.main.DriverModel;
import com.shadiz.android.icab.utils.rx.RxRetrofitUtils;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Created on 28.01.2017.
 */

public class MainRepositoryImpl implements MainRepository {
    private ClientService clientService;
    private DriverService driverService;

    public MainRepositoryImpl() {
        clientService = ICabApp.getApplicationComponent().getClientService();
        driverService = ICabApp.getApplicationComponent().getDriverService();
    }

    @Override
    public Observable<DriverModel> getDrivers() {
        return Observable.timer(2, TimeUnit.SECONDS)
                .flatMap(aLong -> Observable.fromCallable(() ->
                        new DriverModel("aba", new CarModel("mers", "a123bn"), "4"))
                );
    }

    @Override
    public Observable<TripInfoResponse> getClientTripsInfo(ClientTripsInfoRequest request) {
        return RxRetrofitUtils.wrapRetrofitCall(clientService.getClientTripsInfo(request));
    }

    @Override
    public Observable<NewOrderCreatorModelResponse> getIdNewOrder(OrderModelRequest request) {
        return RxRetrofitUtils.wrapRetrofitCall(clientService.getNewTripId(request));
    }

    @Override
    public Observable<CanceledOrderModelResponse> getIdCanceledOrder(CancelOrderRequest request) {
        return RxRetrofitUtils.wrapRetrofitCall(clientService.getIdCanceledOrder(request));
    }

    @Override
    public Observable<SyncMessageModelResponse> getStatusOfClientOrders(SyncMessageModelRequest request) {
        return RxRetrofitUtils.wrapRetrofitCall(clientService.getStatusClientOrders(request));
    }

    @Override
    public Observable<SyncMessageModelResponse> getStatusDriversOrders(SyncMessageModelRequest request) {
        return RxRetrofitUtils.wrapRetrofitCall(driverService.getListNewOrders(request));
    }


}
