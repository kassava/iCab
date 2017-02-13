package com.shadiz.android.icab.data.repositories.main;



import com.shadiz.android.icab.ICabApp;
import com.shadiz.android.icab.data.repositories.network.client.ClientService;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.NewOrderCreatorModelResponse;
import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.main.CarModel;
import com.shadiz.android.icab.data.repositories.network.main.DriverModel;
import com.shadiz.android.icab.utils.rx.RxRetrofitUtils;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Created on 28.01.2017.
 */

public class MainRepositoryImpl implements MainRepository {
    private ClientService taxiService;

    public MainRepositoryImpl() {
        taxiService = ICabApp.getApplicationComponent().getClientService();

    }

    @Override
    public Observable<DriverModel> getDrivers() {
        return Observable.timer(2, TimeUnit.SECONDS)
                .flatMap(aLong -> Observable.fromCallable(() ->
                        new DriverModel("aba", new CarModel("mers", "a123bn"), "4"))
                );
    }

    @Override
    public Observable<NewOrderCreatorModelResponse> getIdNewOrder(OrderModelRequest request) {
        return RxRetrofitUtils.wrapRetrofitCall(taxiService.getNewTripId(request));
    }


}
