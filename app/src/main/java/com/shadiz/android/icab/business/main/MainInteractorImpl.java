package com.shadiz.android.icab.business.main;


import android.util.Log;

import com.shadiz.android.icab.ICabApp;
import com.shadiz.android.icab.data.repositories.main.MainRepository;
import com.shadiz.android.icab.data.repositories.network.client.ClientService;
import com.shadiz.android.icab.data.repositories.network.client.models.request.SyncMessageModelRequest;
import com.shadiz.android.icab.data.repositories.network.client.models.request.create_order.CreateOrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.OrderCreatorModelResponse;
import com.shadiz.android.icab.data.repositories.network.client.models.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.main.DriverModel;
import com.shadiz.android.icab.ui.main.models.FullDriverDataModel;
import com.shadiz.android.icab.utils.rx.RxRetrofitUtils;

import rx.Observable;

/**
 * Created on 28.01.2017.
 */

public class MainInteractorImpl implements MainInteractor {

    private static final String EMPTY_STRING = "";
    private static final String DEFAULT_VALUE = "unknown";

    private MainRepository mainRepository;
    private ClientService taxiService;

    public MainInteractorImpl(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    @Override
    public Observable<FullDriverDataModel> getFreeDrivers() {
        return mainRepository.getDrivers()
                .onErrorResumeNext(throwable -> Observable.error(
                        new MainInteractorException("Incorrect drivers info")
                )).map(this::convert);
    }

    @Override
    public void getStatusMessages(SyncMessageModelRequest syncModel) {
        taxiService = ICabApp.getApplicationComponent().getTaxiService();
        Observable<SyncMessageModelResponse> syncMessageModelObservable = RxRetrofitUtils.wrapRetrofitCall(taxiService.getStatusMessage(syncModel));

        RxRetrofitUtils.wrapAsync(syncMessageModelObservable)
                .subscribe(responce -> {
                    Log.d("MainActivity", "Success " + responce.getStatus() + " session " + responce.getResult().getSession_id());
                }, exception -> {
                    Log.d("MainActivity", exception.getMessage());
                });
    }

    @Override
    public void getTripId(CreateOrderModelRequest request, SyncMessageModelRequest syncModel) {
        taxiService = ICabApp.getApplicationComponent().getTaxiService();
        Observable<OrderCreatorModelResponse> getTripObservable = RxRetrofitUtils.wrapRetrofitCall(taxiService.getTripId(request));
        Observable<SyncMessageModelResponse> syncMessageModelObservable = RxRetrofitUtils.wrapRetrofitCall(taxiService.getStatusMessage(syncModel));

        RxRetrofitUtils.wrapAsync(getTripObservable)
                .subscribe(response -> {
                    Log.d("MainActivity", "Success " + response.getStatus());
                    RxRetrofitUtils.wrapAsync(syncMessageModelObservable)
                            .subscribe(responce -> {
                                Log.d("MainActivity", "Success " + responce.getStatus() + " session " + responce.getResult().getSession_id());
                            }, exception -> {
                                Log.d("MainActivity", exception.getMessage());
                            });
                }, exception -> {
                    Log.d("MainActivity", exception.getMessage());
                });
    }


    private FullDriverDataModel convert(DriverModel driverModel) {
        return new FullDriverDataModel(
                driverModel == null || driverModel.getName() == null ?
                        EMPTY_STRING : driverModel.getName(),
                driverModel == null || driverModel.getName() == null ?
                        EMPTY_STRING : driverModel.getCar().toString(),
                driverModel == null || driverModel.getRating() == null ?
                        EMPTY_STRING : driverModel.getRating()
        );
    }


}
