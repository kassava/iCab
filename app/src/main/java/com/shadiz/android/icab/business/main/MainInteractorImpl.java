package com.shadiz.android.icab.business.main;


import android.util.Log;

import com.shadiz.android.icab.ICabApp;
import com.shadiz.android.icab.data.repositories.main.MainRepository;
import com.shadiz.android.icab.data.repositories.network.TaxiService;
import com.shadiz.android.icab.data.repositories.network.models.request.client.MessageSyncModelRequest;
import com.shadiz.android.icab.data.repositories.network.models.request.client.TripModelRequest;
import com.shadiz.android.icab.data.repositories.network.models.responce.client.create_trip.TripModelResponse;
import com.shadiz.android.icab.data.repositories.network.models.responce.client.message_sync.SyncMessageModelResponce;
import com.shadiz.android.icab.data.repositories.network.models.responce.main.DriverModel;
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
    private TaxiService taxiService;

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
    public void getStatusMessages(MessageSyncModelRequest syncModel) {
        taxiService = ICabApp.getApplicationComponent().getTaxiService();
        Observable<SyncMessageModelResponce> syncMessageModelObservable = RxRetrofitUtils.wrapRetrofitCall(taxiService.getStatusMessage(syncModel));

        RxRetrofitUtils.wrapAsync(syncMessageModelObservable)
                .subscribe(responce -> {
                    Log.d("MainActivity", "Success " + responce.getStatus() + responce.getResult().getSession_id());
                }, exception -> {
                    Log.d("MainActivity", exception.getMessage());
                });
    }

    @Override
    public void getTripId(TripModelRequest request) {
        taxiService = ICabApp.getApplicationComponent().getTaxiService();
        Observable<TripModelResponse> getTripObservable = RxRetrofitUtils.wrapRetrofitCall(taxiService.getTripId(request));

        RxRetrofitUtils.wrapAsync(getTripObservable)
                .subscribe(response -> {
                    Log.d("MainActivity", "Success " + response.getStatus());
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
