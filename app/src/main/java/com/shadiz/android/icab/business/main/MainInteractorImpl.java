package com.shadiz.android.icab.business.main;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shadiz.android.icab.ICabApp;
import com.shadiz.android.icab.data.repositories.main.MainRepository;
import com.shadiz.android.icab.data.repositories.network.client.ClientService;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.NewOrderCreatorModelResponse;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.CanceledOrderModelResponse;
import com.shadiz.android.icab.data.repositories.network.common.LocationModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.RequirementToTheDriverModel;
import com.shadiz.android.icab.data.repositories.network.common.model.CodesModel;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.order.CancelOrderMessageModel;
import com.shadiz.android.icab.data.repositories.network.common.request.order.CancelOrderRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.order.MessageOfOrderModel;
import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.driver.DriverService;
import com.shadiz.android.icab.data.repositories.network.main.DriverModel;
import com.shadiz.android.icab.ui.main.models.FullDriverDataModel;
import com.shadiz.android.icab.utils.rx.RxRetrofitUtils;
import com.shadiz.android.icab.utils.rx.RxSchedulersAbs;

import rx.Observable;

/**
 * Created on 28.01.2017.
 */

public class MainInteractorImpl implements MainInteractor {

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
    public void getStatusMessages(SyncMessageModelRequest syncModel) {
        clientService = ICabApp.getApplicationComponent().getClientService();
        Observable<SyncMessageModelResponse> syncMessageModelObservable = RxRetrofitUtils.wrapRetrofitCall(clientService.getStatusClientOrders(syncModel));
        RxSchedulersAbs.wrapAsync(syncMessageModelObservable)
                .subscribe(responce -> {
                    Log.d("MainInteractorImpl", "Success " + responce.getStatus() + " session " + responce.getResult().getSessionId());
//                    List<MessagesModel> messages = responce.getResult().getMessages();
//                    for(int i=0; i< messages.size(); i++ ) {
//                        locationModelResponse = gson.fromJson(messages.get(i).getCode2().toString(), LocationModelResponse.class);
//                        Log.d("MainInteractorImpl", messages.get(i).getCode2().toString());
//                    }
                }, exception -> {
                    Log.d("MainInteractorImpl", "exception " + exception.getMessage());
                });
    }


    @Override
    public Observable<Integer> getTripId() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        LocationModelRequest location = new LocationModelRequest("30.1511669158936", "59.8494987487793", "12", "Luna");
        RequirementToTheDriverModel requirementToTheDriverModel = new RequirementToTheDriverModel("7000", 0, 5, 0);
        CodesModel codesModel = new CodesModel("", location, "", location, 1, "", 0, 1, 0, requirementToTheDriverModel);
        DeviceModelRequest deviceModelRequest = new DeviceModelRequest("3af83a99f6f8ad7", "3333333333", "android");
        MessageOfOrderModel messageModel = new MessageOfOrderModel();
//        messageModel.setCode1("2278");
        messageModel.setCode2(gson.toJson(location));
        messageModel.setCode3("");
//        messageModel.setCode4(gson.toJson(location));
        messageModel.setCode5("1");
        messageModel.setCode7("0");
        messageModel.setCode8(1);
        messageModel.setCode9(0);
        messageModel.setCode10(gson.toJson(requirementToTheDriverModel));
        messageModel.setAppear_type(0);
        messageModel.setUser_from(813);
//        messageModel.setUser_to(823);
        messageModel.setType("clientServer_userWantsToOrderTaxi_agree");


        OrderModelRequest createTripModel = new OrderModelRequest(messageModel, "3af83a99f6f8ad7", "3333333333", "android");
        SyncMessageModelRequest syncModel = new SyncMessageModelRequest(deviceModelRequest, "2017-02-03 04:54:57");

        return mainRepository.getIdNewOrder(createTripModel)
                .onErrorResumeNext(throwable -> Observable.error(
                        new MainInteractorException("Error") ))
                .map(this::getIdOrder);
//
    }

    @Override
    public Observable<Integer> getIdCanceledOrder(CharSequence id) {
        DeviceModelRequest deviceModelRequest = new DeviceModelRequest("3af83a99f6f8ad7", "3333333333", "android");
        CancelOrderMessageModel cancelOrderMessageModel = new CancelOrderMessageModel("clientServer_userWantsToCancelOrder_agree", Integer.parseInt(id.toString()), "no", 0, 0);
        CancelOrderRequest cancelOrderRequest = new CancelOrderRequest(deviceModelRequest, cancelOrderMessageModel);

        return mainRepository.getIdCanceledOrder(cancelOrderRequest)
                .map(this::getIdCanceledOrder);
    }

    @Override
    public Observable<SyncMessageModelResponse> getStatusOfClientOrders() {
        DeviceModelRequest deviceModelRequest = new DeviceModelRequest("3af83a99f6f8ad7", "3333333333", "android");
        SyncMessageModelRequest syncModel = new SyncMessageModelRequest(deviceModelRequest, "2017-02-15 23:24:52");

        return mainRepository.getStatusOfClientOrders(syncModel);    }

    @Override
    public Observable<SyncMessageModelResponse> getStatusOfDriversOrders() {
        DeviceModelRequest deviceModelRequest = new DeviceModelRequest("b23631cf49347140", "5555555555", "android");
        SyncMessageModelRequest syncModel = new SyncMessageModelRequest(deviceModelRequest, "2017-02-15 23:24:52");

        return mainRepository.getStatusDriversOrders(syncModel);
//                .map(this::getIdCanceledOrder);
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

    private Integer getIdOrder(NewOrderCreatorModelResponse orderModelRequest) {
        return orderModelRequest.getResult().getTripId();
    }
    private Integer getIdCanceledOrder(CanceledOrderModelResponse canceledOrderModelResponse) {
        return canceledOrderModelResponse.getResult().getNewId();
    }
}
