package com.shadiz.android.icab.ui.main.presenter;

import android.support.annotation.NonNull;

import com.shadiz.android.icab.business.main.MainInteractor;
import com.shadiz.android.icab.data.repositories.network.models.request.CodesModel;
import com.shadiz.android.icab.data.repositories.network.models.request.CreateTripModel;
import com.shadiz.android.icab.data.repositories.network.models.request.LocationModel;
import com.shadiz.android.icab.data.repositories.network.models.request.MessageModel;
import com.shadiz.android.icab.data.repositories.network.models.request.RequirementToTheDriverModel;
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

//        Subscription loadFreeDriversSubscription = mainInteractor.getFreeDrivers()
//                .compose(rxSchedulersAbs.getIOToMainTransformer())
//                .subscribe(this::handleSuccessLoadPersonalInfo, this::handleErrorLoadPersonalInfo);
//        compositeSubscription.add(loadFreeDriversSubscription);
//        "message": "{\"user_from\":\"\",\"user_to\":\"\",\"appear_type\":\"0\",\"type\":\"clientServer_userWantsToOrderTaxi_agree\"," +
//                "\"message_body\":\"\",\"code1\":\"\",\"code2\":\"{\\\"latitude\\\":\\\"53.92280578613281\\\",\\\"longitude\\\":\\\"27.58755111694336\\\"," +
//                "\\\"geocode\\\":\\\"vulica Bielamorskaja 6, Minsk, Belarus\\\",\\\"precision\\\":\\\"15\\\"}\",\"code3\":\"\",\"code4\":\"\",\"code5\":\"1\"," +
//                "\"code6\":\"\",\"code7\":\"\",\"code8\":\"1\",\"code9\":\"\",\"code10\":\"{\\\"radius\\\":\\\"5000\\\",\\\"rateFrom\\\":0,\\\"rateTo\\\":5," +
//                "\\\"acceptCC\\\":\\\"0\\\"}\"}",
        LocationModel location = new LocationModel(-122.084, 37.422, 12, "Luna");
        RequirementToTheDriverModel requirementToTheDriverModel = new RequirementToTheDriverModel(7000, 0, 5, 0);
        CodesModel codesModel = new CodesModel("", location, "", location, 1, "", 0, 1, 0, requirementToTheDriverModel);
        MessageModel messageModel = new MessageModel("", "", "0", "clientServer_userWantsToOrderTaxi_agree", "",  codesModel);
        CreateTripModel createTripModel = new CreateTripModel("3af83a99f6f8ad7", "3333333333", "android", messageModel);
        mainInteractor.getTripId(createTripModel);
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
