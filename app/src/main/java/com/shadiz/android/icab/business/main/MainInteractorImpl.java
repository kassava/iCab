package com.shadiz.android.icab.business.main;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shadiz.android.icab.ICabApp;
import com.shadiz.android.icab.data.repositories.main.MainRepository;
import com.shadiz.android.icab.data.repositories.network.client.ClientService;
import com.shadiz.android.icab.data.repositories.network.client.models.request.trip_info.ClientTripsInfoRequest;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.CanceledOrderResponseModel;
import com.shadiz.android.icab.data.repositories.network.client.models.response.rate_after_trip.ClientNewOrderCreatorResponseModel;
import com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info.ActiveTripModel;
import com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info.TripInfoResponseModel;
import com.shadiz.android.icab.data.repositories.network.common.LocationModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.RequirementToTheDriverModel;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceRequestModel;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageRequestModel;
import com.shadiz.android.icab.data.repositories.network.common.request.order.MessageOfOrderModel;
import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.driver.DriverService;
import com.shadiz.android.icab.data.repositories.network.driver.models.request.current_order.OrderMessageModel;
import com.shadiz.android.icab.data.repositories.network.driver.models.request.current_order.StatusOrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.driver.models.request.trip_info.DriverTripInfoRequest;
import com.shadiz.android.icab.data.repositories.network.driver.models.response.current_confirm.StatusOrderResponseModel;
import com.shadiz.android.icab.data.repositories.network.driver.models.response.trip_info.DriverTripResponse;
import com.shadiz.android.icab.data.repositories.network.main.DriverModel;
import com.shadiz.android.icab.ui.main.models.FullDriverDataModel;
import com.shadiz.android.icab.utils.rx.RxRetrofitUtils;
import com.shadiz.android.icab.utils.rx.RxSchedulersAbs;

import java.util.ArrayList;

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
    public void getStatusMessages(SyncMessageRequestModel syncModel) {
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
    public Observable<String> getClientTripsInfo() {
        DeviceRequestModel deviceModelRequest = new DeviceRequestModel("3af83a99f6f8ad7", "3333333333", "android");
        ArrayList<String> filter = new ArrayList<>();
        filter.add("activeTrip");
        filter.add("postponedTrips");
        ClientTripsInfoRequest clientTripsInfoRequest = new ClientTripsInfoRequest(deviceModelRequest, filter);
        return mainRepository.getClientTripsInfo(clientTripsInfoRequest)
                .map(this::getClientTripInfo);
    }


    @Override
    public Observable<Integer> getClientTripId() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        LocationModelRequest location = new LocationModelRequest("30.1511669158936", "59.8494987487793", "12", "Luna");
        RequirementToTheDriverModel requirementToTheDriverModel = new RequirementToTheDriverModel("7000", 0, 5, 0);
        DeviceRequestModel deviceModelRequest = new DeviceRequestModel("3af83a99f6f8ad7", "3333333333", "android");
        MessageOfOrderModel messageModel = new MessageOfOrderModel();
        messageModel.setCode2(gson.toJson(location));
        messageModel.setCode5("1");
        messageModel.setCode7("0");
        messageModel.setCode8(1);
        messageModel.setCode9(0);
        messageModel.setCode10(gson.toJson(requirementToTheDriverModel));
        messageModel.setAppear_type(0);
        messageModel.setUser_from(813);
        messageModel.setType("clientServer_userWantsToOrderTaxi_agree");
        OrderModelRequest createTripModel = new OrderModelRequest(deviceModelRequest, messageModel);
        return mainRepository.getIdNewOrder(createTripModel)
                .onErrorResumeNext(throwable -> Observable.error(
                        new MainInteractorException("Error")))
                .map(this::getIdOrder);
    }

    @Override
    public Observable<Integer> getClientIdCanceledOrder(CharSequence id) {
        DeviceRequestModel deviceModelRequest = new DeviceRequestModel("3af83a99f6f8ad7", "3333333333", "android");
        OrderMessageModel cancelOrderMessageModel = new OrderMessageModel("clientServer_userWantsToCancelOrder_agree", Integer.parseInt(id.toString()), "no", 0, 0);
        StatusOrderModelRequest cancelOrderRequest = new StatusOrderModelRequest(deviceModelRequest, cancelOrderMessageModel);
        return mainRepository.getIdCanceledOrder(cancelOrderRequest)
                .map(this::getIdCanceledOrder);
    }

    @Override
    public Observable<SyncMessageModelResponse> getClientStatusOfOrders() {
        DeviceRequestModel deviceModelRequest = new DeviceRequestModel("3af83a99f6f8ad7", "3333333333", "android");
        SyncMessageRequestModel syncMessageRequestModel = new SyncMessageRequestModel(deviceModelRequest, "2017-02-15 23:24:52");
        return mainRepository.getStatusOfClientOrders(syncMessageRequestModel);
    }

    @Override
    public Observable<SyncMessageModelResponse> getStatusOfDriversOrders() {
        DeviceRequestModel deviceModelRequest = new DeviceRequestModel("b23631cf49347140", "5555555555", "android");
        SyncMessageRequestModel syncMessageRequestModel = new SyncMessageRequestModel(deviceModelRequest, "2017-02-15 23:24:52");
        return mainRepository.getStatusDriversOrders(syncMessageRequestModel);
//                .map(this::getClientIdCanceledOrder);
    }

    @Override
    public Observable<String> getDriverTripsInfo() {
        DeviceRequestModel deviceModelRequest = new DeviceRequestModel("b23631cf49347140", "5555555555", "android");
        ArrayList<String> filter = new ArrayList<>();
        filter.add("activeTrip");
        filter.add("postponedTrips");
        filter.add("acceptedPostponedTrips");
        DriverTripInfoRequest driverTripInfoRequest = new DriverTripInfoRequest(deviceModelRequest, filter, 10000, 10000);
        return mainRepository.getDriversTripsInfo(driverTripInfoRequest)
                .map(this::getDriverTripInfo);
    }

    @Override
    public Observable<Integer> getDriverAgreeToOrder(CharSequence id) {
        DeviceRequestModel deviceModelRequest = new DeviceRequestModel("b23631cf49347140", "5555555555", "android");
        OrderMessageModel messageModel = new OrderMessageModel();
        messageModel.setCode1(Integer.parseInt(id.toString()));
        messageModel.setAppear_type(0);
        messageModel.setUser_to(813);
        messageModel.setType("driverServer_userWantsToOrderTaxi_agree");
        StatusOrderModelRequest confirmOrderModelRequest = new StatusOrderModelRequest(deviceModelRequest, messageModel);
        return mainRepository.getIdDriversAgreeToOrder(confirmOrderModelRequest)
                .map(this::getIdDriverOrder);
    }

    @Override
    public Observable<Integer> getDriverDisagreeToOrder(CharSequence id) {
        DeviceRequestModel deviceModelRequest = new DeviceRequestModel("b23631cf49347140", "5555555555", "android");
        OrderMessageModel messageModel = new OrderMessageModel();
        messageModel.setCode1(Integer.parseInt(id.toString()));
        messageModel.setAppear_type(0);
        messageModel.setUser_to(813);
        messageModel.setType("driverServer_userWantsToOrderTaxi_disagree");
        StatusOrderModelRequest confirmOrderModelRequest = new StatusOrderModelRequest(deviceModelRequest, messageModel);
        return mainRepository.getIdDriversAgreeToOrder(confirmOrderModelRequest)
                .map(this::getIdDriverOrder);
    }

    @Override
    public Observable<Integer> getDriverCancelOrder(CharSequence id) {
        DeviceRequestModel deviceModelRequest = new DeviceRequestModel("b23631cf49347140", "5555555555", "android");
        OrderMessageModel messageModel = new OrderMessageModel();
        messageModel.setCode1(Integer.parseInt(id.toString()));
        messageModel.setCode2("bad test");
        messageModel.setAppear_type(0);
        messageModel.setType("driverServer_userWantsToCancelOrder_agree");
        StatusOrderModelRequest statusOrderModelRequest = new StatusOrderModelRequest(deviceModelRequest, messageModel);
        return mainRepository.getDriverCancelOrder(statusOrderModelRequest)
                .map(this::getIdDriverOrder);
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

    private String getClientTripInfo(TripInfoResponseModel tripInfoResponse) {
        ArrayList<ActiveTripModel> response = tripInfoResponse.getResult().getActiveTrip();
        if (response.get(0) != null)
            return tripInfoResponse.getResult().getActiveTrip().get(0).toString();
        return null;
    }

    private String getDriverTripInfo(DriverTripResponse tripInfoResponse) {
        ArrayList<ActiveTripModel> response = tripInfoResponse.getResult().getActiveTrip();
        if (response.get(0) != null)
            return tripInfoResponse.getResult().getActiveTrip().get(0).toString();
        return null;
    }


    private Integer getIdOrder(ClientNewOrderCreatorResponseModel clientNewOrderCreatorResponseModel) {
        return clientNewOrderCreatorResponseModel.getResult().getTripId();
    }

    private Integer getIdDriverOrder(StatusOrderResponseModel orderConfirmationResponseModel) {
        return orderConfirmationResponseModel.getResult().getNewId();
    }

    private Integer getIdCanceledOrder(CanceledOrderResponseModel canceledOrderModelResponse) {
        return canceledOrderModelResponse.getResult().getNewId();
    }
}
