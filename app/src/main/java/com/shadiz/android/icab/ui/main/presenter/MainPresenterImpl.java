package com.shadiz.android.icab.ui.main.presenter;

import android.support.annotation.NonNull;

import com.shadiz.android.icab.business.main.MainInteractor;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
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
    public void clientClickToCreateOrderButton() {
        mainView.showProgress();
        Subscription createNewIdOrderSubscription = mainInteractor.getTripId()
                .compose(rxSchedulersAbs.getIOToMainTransformer())
                .subscribe(this::handleCreateOrder, this::handleError);

        compositeSubscription.add(createNewIdOrderSubscription);
    }

    @Override
    public void clientClickToCancelOrderButton(CharSequence id) {
        mainView.showProgress();
        Subscription getIdCanceledOrderSubscription = mainInteractor.getIdCanceledOrder(id)
                .compose(rxSchedulersAbs.getIOToMainTransformer())
                .subscribe(this::handleCancelOrder, this::handleError);
        compositeSubscription.add(getIdCanceledOrderSubscription);
    }

    @Override
    public void clientMessageSync() {
        mainView.showProgress();
        Subscription getIdCanceledOrderSubscription = mainInteractor.getStatusOfClientOrders()
                .compose(rxSchedulersAbs.getIOToMainTransformer())
                .subscribe(this::handleStatusClientOrders, this::handleError);
        compositeSubscription.add(getIdCanceledOrderSubscription);
    }

    @Override
    public void driverMessageSync() {
        mainView.showProgress();
        Subscription getNewOrdersSubscription = mainInteractor.getStatusOfDriversOrders()
                .compose(rxSchedulersAbs.getIOToMainTransformer())
                .subscribe(this::handleStatusDriverOrders, this::handleError);
        compositeSubscription.add(getNewOrdersSubscription);
    }

    private void setFreeDriversToView(@NonNull FullDriverDataModel fullDriverDataModel) {
        mainView.showDrivers(fullDriverDataModel.toString());
    }

    private void handleCreateOrder(@NonNull int id) {
        mainView.hideProgress();
        mainView.showIdNewOrder(id);
    }

    private void handleCancelOrder(@NonNull int id) {
        mainView.hideProgress();
        mainView.showIdCanceledOrder(id);
    }

    private void handleStatusDriverOrders(@NonNull SyncMessageModelResponse response) {
        mainView.hideProgress();
        mainView.showStatusOfClientOrders(String.valueOf(response.getResult().getMessages().get(0).getCode1()));
    }

    private void handleStatusClientOrders(@NonNull SyncMessageModelResponse response) {
        mainView.hideProgress();
        mainView.showStatusOfClientOrders(String.valueOf(response.getResult().getMessages().get(0).getCode1()));
    }
    private void handleError(Throwable throwable) {
        mainView.hideProgress();
        mainView.showError(throwable.getLocalizedMessage());
    }
}
