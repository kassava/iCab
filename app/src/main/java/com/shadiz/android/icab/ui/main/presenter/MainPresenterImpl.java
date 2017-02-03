package com.shadiz.android.icab.ui.main.presenter;

import android.support.annotation.NonNull;

import com.shadiz.android.icab.business.main.MainInteractor;
import com.shadiz.android.icab.data.repositories.network.models.request.client.TripModelRequest;
import com.shadiz.android.icab.data.repositories.network.models.request.common.CodesModel;
import com.shadiz.android.icab.data.repositories.network.models.request.common.LocationModel;
import com.shadiz.android.icab.data.repositories.network.models.request.client.MessageModel;
import com.shadiz.android.icab.data.repositories.network.models.request.client.MessageSyncModelRequest;
import com.shadiz.android.icab.data.repositories.network.models.common.RequirementToTheDriverModel;
import com.shadiz.android.icab.ui.main.models.FullDriverDataModel;
import com.shadiz.android.icab.ui.main.views.MainView;
import com.shadiz.android.icab.utils.rx.RxSchedulersAbs;

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

        LocationModel location = new LocationModel(-122.084, 37.422, 12, "Luna");
        RequirementToTheDriverModel requirementToTheDriverModel = new RequirementToTheDriverModel(7000, 0, 5, 0);
        CodesModel codesModel = new CodesModel("", location, "", location, 1, "", 0, 1, 0, requirementToTheDriverModel);
        MessageModel messageModel = new MessageModel("", "", "clientServer_userWantsToOrderTaxi_agree","0",  "",  codesModel);
        TripModelRequest createTripModel = new TripModelRequest("3af83a99f6f8ad7", "3333333333", "android", messageModel);
        MessageSyncModelRequest syncModel = new MessageSyncModelRequest("2017-02-01 04:54:57", "3af83a99f6f8ad7", "3333333333", "android");
        mainInteractor.getTripId(createTripModel);
//        mainInteractor.getStatusMessages(syncModel);
    }

    private void setFreeDriversToView(@NonNull FullDriverDataModel fullDriverDataModel) {
        mainView.showDrivers(fullDriverDataModel.toString());
    }

    private void handleSuccessLoadPersonalInfo(@NonNull FullDriverDataModel fullDriverDataModel) {
        // view actions
        setFreeDriversToView(fullDriverDataModel);
        // hide progress
        mainView.hideProgress();
    }

    private void handleErrorLoadPersonalInfo(Throwable throwable) {
        mainView.hideProgress();
        mainView.showError();
    }
}
