package com.shadiz.android.icab.ui.main.presenter;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shadiz.android.icab.business.main.MainInteractor;
import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.LocationModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.model.CodesModel;
import com.shadiz.android.icab.data.repositories.network.common.request.DeviceModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.order.MessageOfOrderModel;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.RequirementToTheDriverModel;
import com.shadiz.android.icab.ui.main.models.FullDriverDataModel;
import com.shadiz.android.icab.ui.main.views.MainView;
import com.shadiz.android.icab.utils.rx.RxSchedulersAbs;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created on 28.01.2017.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;
    private MainInteractor mainInteractor;
    private RxSchedulersAbs rxSchedulersAbs;
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    public MainPresenterImpl(MainInteractor mainInteractor, RxSchedulersAbs rxSchedulersAbs) {
        this.mainInteractor = mainInteractor;
        this.rxSchedulersAbs = rxSchedulersAbs;
    }

    @Override
    public void bindView(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void unbindView() {
        mainView = null;
    }

    @Override
    public void clickToOrderButton() {
        mainView.showProgress();



        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        LocationModelRequest location = new LocationModelRequest(-122.084, 37.422, 12, "Luna");
        RequirementToTheDriverModel requirementToTheDriverModel = new RequirementToTheDriverModel("7000", 0, 5, 0);
        CodesModel codesModel = new CodesModel("", location, "", location, 1, "", 0, 1, 0, requirementToTheDriverModel);
        DeviceModelRequest deviceModelRequest = new DeviceModelRequest("3af83a99f6f8ad7", "3333333333", "android");
        MessageOfOrderModel messageModel = new MessageOfOrderModel();
        messageModel.setCode2(gson.toJson(location));
        messageModel.setCode4(gson.toJson(location));
        messageModel.setCode5("1");
        messageModel.setCode7("0");
        messageModel.setCode8("1");
        messageModel.setCode9("0");
        messageModel.setCode10(gson.toJson(requirementToTheDriverModel));
        messageModel.setAppear_type("0");
        messageModel.setUser_from("813");
        messageModel.setType("clientServer_userWantsToOrderTaxi_agree");


        OrderModelRequest createTripModel = new OrderModelRequest(messageModel, "3af83a99f6f8ad7", "3333333333", "android");
        SyncMessageModelRequest syncModel = new SyncMessageModelRequest(deviceModelRequest, "2017-02-03 04:54:57");

//        Subscription loadFreeDriversSubscription = mainInteractor.getTripId(createTripModel)
//                .compose(rxSchedulersAbs.getIOToMainTransformer())
//                .subscribe(this::handleCreateOrder, this::handleErrorLoadPersonalInfo);

//        compositeSubscription.add(loadFreeDriversSubscription);
        mainInteractor.getTripID(createTripModel);
//        mainInteractor.getStatusMessages(syncModel);
    }

    private void setFreeDriversToView(@NonNull FullDriverDataModel fullDriverDataModel) {
        mainView.showDrivers(fullDriverDataModel.toString());
    }

    private void handleCreateOrder(@NonNull int Id) {
        // view actions
//        setFreeDriversToView(fullDriverDataModel);
        // hide progress
        mainView.hideProgress();
    }

    private void handleErrorLoadPersonalInfo(Throwable throwable) {
        mainView.hideProgress();
        mainView.showError();
    }
}
