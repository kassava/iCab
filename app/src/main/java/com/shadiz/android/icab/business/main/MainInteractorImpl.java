package com.shadiz.android.icab.business.main;


import android.util.Log;

import com.shadiz.android.icab.ICabApp;
import com.shadiz.android.icab.data.repositories.main.MainRepository;
import com.shadiz.android.icab.data.repositories.network.TaxiService;
import com.shadiz.android.icab.data.repositories.network.models.request.CreateTripModel;
import com.shadiz.android.icab.data.repositories.network.models.request.MessageModel;
import com.shadiz.android.icab.data.repositories.network.models.response.main.DriverModel;
import com.shadiz.android.icab.data.repositories.network.models.response.TripModel;
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
    public void getTripId(CreateTripModel message) {
        taxiService = ICabApp.getApplicationComponent().getTaxiService();
        Observable<TripModel> weatherObservable = RxRetrofitUtils.wrapRetrofitCall(taxiService.getOrder(message));
//
        RxRetrofitUtils.wrapAsync(weatherObservable)
                .subscribe(tripModel -> {
                    Log.d("MainActivity", "Success " + tripModel.getSession_id());
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
