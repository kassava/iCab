package com.shadiz.android.icab.ui.main.presenter;

import android.support.annotation.NonNull;

import com.shadiz.android.icab.business.main.MainInteractor;
import com.shadiz.android.icab.business.main.MainInteractorImpl;
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

        Subscription loadFreeDriversSubscription = mainInteractor.getFreeDrivers()
                .compose(rxSchedulersAbs.getIOToMainTransformer())
                .subscribe(this::handleSuccessLoadPersonalInfo, this::handleErrorLoadPersonalInfo);
        compositeSubscription.add(loadFreeDriversSubscription);
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
