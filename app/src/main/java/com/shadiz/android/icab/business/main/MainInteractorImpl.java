package com.shadiz.android.icab.business.main;


import android.util.Log;

import com.shadiz.android.icab.ICabApp;
import com.shadiz.android.icab.data.NetworkManager;
import com.shadiz.android.icab.data.repositories.main.MainRepository;
import com.shadiz.android.icab.data.repositories.network.client.ClientService;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.OrderCreatorModelResponse;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.main.DriverModel;
import com.shadiz.android.icab.ui.main.models.FullDriverDataModel;
import com.shadiz.android.icab.utils.rx.RxRetrofitUtils;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created on 28.01.2017.
 */

public class MainInteractorImpl implements MainInteractor {

    private static final String EMPTY_STRING = "";
    private static final String DEFAULT_VALUE = "unknown";

    private MainRepository mainRepository;
    @Inject
    NetworkManager networkManager;

    public MainInteractorImpl(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
        networkManager = ICabApp.getApplicationComponent().getNetworkManager();
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

    }

    @Override
    public void getTripId(OrderModelRequest request) {
         networkManager.createNewOrderFromClient(request);
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
