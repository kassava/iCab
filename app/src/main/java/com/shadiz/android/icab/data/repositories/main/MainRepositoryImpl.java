package com.shadiz.android.icab.data.repositories.main;


import com.shadiz.android.icab.ICabApp;
import com.shadiz.android.icab.data.repositories.network.client.ClientService;
import com.shadiz.android.icab.data.repositories.network.client.models.request.trip_info.ClientTripsInfoRequest;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.CanceledOrderResponseModel;
import com.shadiz.android.icab.data.repositories.network.client.models.response.rate_after_trip.ClientNewOrderCreatorResponseModel;
import com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info.TripInfoResponseModel;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageRequestModel;
import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.driver.DriverService;
import com.shadiz.android.icab.data.repositories.network.driver.models.request.current_order.StatusOrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.driver.models.request.trip_info.DriverTripInfoRequest;
import com.shadiz.android.icab.data.repositories.network.driver.models.response.current_confirm.StatusOrderResponseModel;
import com.shadiz.android.icab.data.repositories.network.driver.models.response.trip_info.DriverTripResponse;
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
    public Observable<TripInfoResponseModel> getClientTripsInfo(ClientTripsInfoRequest request) {
        return RxRetrofitUtils.wrapRetrofitCall(clientService.getClientTripsInfo(request));
    }

    @Override
    public Observable<ClientNewOrderCreatorResponseModel> getIdNewOrder(OrderModelRequest request) {
        return RxRetrofitUtils.wrapRetrofitCall(clientService.getNewTripId(request));
    }

    @Override
    public Observable<CanceledOrderResponseModel> getIdCanceledOrder(StatusOrderModelRequest request) {
        return RxRetrofitUtils.wrapRetrofitCall(clientService.getIdCanceledOrder(request));
    }

    @Override
    public Observable<SyncMessageModelResponse> getStatusOfClientOrders(SyncMessageRequestModel request) {
        return RxRetrofitUtils.wrapRetrofitCall(clientService.getStatusClientOrders(request));
    }

    @Override
    public Observable<SyncMessageModelResponse> getStatusDriversOrders(SyncMessageRequestModel request) {
        return RxRetrofitUtils.wrapRetrofitCall(driverService.getListNewOrders(request));
    }

    @Override
    public Observable<DriverTripResponse> getDriversTripsInfo(DriverTripInfoRequest request) {
        return RxRetrofitUtils.wrapRetrofitCall(driverService.getDriverTripsInfo(request));
    }

    @Override
    public Observable<StatusOrderResponseModel> getIdDriversAgreeToOrder(StatusOrderModelRequest request) {
        return RxRetrofitUtils.wrapRetrofitCall(driverService.getStatusDriverOrder(request));
    }

    @Override
    public Observable<StatusOrderResponseModel> getDriverCancelOrder(StatusOrderModelRequest request) {
        return RxRetrofitUtils.wrapRetrofitCall(driverService.getStatusDriverOrder(request));
    }


}
