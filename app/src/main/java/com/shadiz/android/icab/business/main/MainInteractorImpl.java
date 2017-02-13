package com.shadiz.android.icab.business.main;


import android.util.Log;

import com.shadiz.android.icab.ICabApp;
import com.shadiz.android.icab.business.main.listener.OrderListener;
import com.shadiz.android.icab.data.repositories.main.MainRepository;
import com.shadiz.android.icab.data.repositories.network.client.ClientService;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.NewOrderCreatorModelResponse;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.MessagesModel;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.driver.DriverService;
import com.shadiz.android.icab.data.repositories.network.main.DriverModel;
import com.shadiz.android.icab.ui.main.models.FullDriverDataModel;
import com.shadiz.android.icab.utils.rx.RxRetrofitUtils;
import com.shadiz.android.icab.utils.rx.RxSchedulersAbs;

import java.util.List;

import rx.Observable;

/**
 * Created on 28.01.2017.
 */

public class MainInteractorImpl implements MainInteractor, OrderListener {

    private static final String EMPTY_STRING = "";
    private static final String DEFAULT_VALUE = "unknown";

    private MainRepository mainRepository;
    private ClientService clientService;
    private DriverService driverService;

    public MainInteractorImpl(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
        clientService = ICabApp.getApplicationComponent().getClientService();
        driverService = ICabApp.getApplicationComponent().getDriverService();
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
        clientService = ICabApp.getApplicationComponent().getClientService();
        Observable<SyncMessageModelResponse> syncMessageModelObservable = RxRetrofitUtils.wrapRetrofitCall(clientService.getStatusMessage(syncModel));
        RxSchedulersAbs.wrapAsync(syncMessageModelObservable)
                .subscribe(responce -> {
                    Log.d("MainInteractorImpl", "Success " + responce.getStatus() + " session ");
                    List<MessagesModel> messages = responce.getResult().getMessages();
                    for(int i=0; i< messages.size(); i++ ) {
//                        locationModelResponse = gson.fromJson(messages.get(i).getCode2().toString(), LocationModelResponse.class);
                        Log.d("MainInteractorImpl", messages.get(i).getCode2().toString());
                    }
                }, exception -> {
                    Log.d("MainInteractorImpl", "exception " + exception.getMessage());
                });
    }

    @Override
    public Observable<String> getTripId(OrderModelRequest request) {
        return mainRepository.getIdNewOrder(request)
                .onErrorResumeNext(throwable -> Observable.error(
                        new MainInteractorException("Incorrect drivers info")
                )).map(this::getIdOrder);

    }
    @Override
    public void getTripID(OrderModelRequest request) {
        RxSchedulersAbs.wrapAsync(mainRepository.getIdNewOrder(request))
                .subscribe(response -> {
                    Log.d("MainActivity", "Success " + response.getStatus() + " " + response.getResult().getTripId());
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

    private String getIdOrder(NewOrderCreatorModelResponse orderModelRequest) {
        return orderModelRequest.getResult().getTripId(); }

    @Override
    public void onSetNewIdOrder(NewOrderCreatorModelResponse newOrderCreatorModelResponse) {

    }

    @Override
    public void onErrorRequest(Throwable exception) {
        Log.d("MainInteractorImpl", exception.getMessage());

    }
}
