package com.shadiz.android.icab.data;

import android.util.Log;

import com.shadiz.android.icab.ICabApp;
import com.shadiz.android.icab.data.repositories.network.client.ClientService;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.OrderCancelerModelResponse;
import com.shadiz.android.icab.data.repositories.network.client.models.response.order.OrderCreatorModelResponse;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.order.CancelOrderRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.driver.DriverService;
import com.shadiz.android.icab.data.repositories.network.driver.models.request.current_order.ConfirmOrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.driver.models.response.current_confirm.OrderConfirmationModelResponse;
import com.shadiz.android.icab.utils.rx.RxRetrofitUtils;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created on 09.02.17.
 */

public class NetworkManager {
    @Inject
    private ClientService clientService;
    @Inject
    private DriverService driverService;

    public NetworkManager() {
        this.clientService = ICabApp.getApplicationComponent().getClientService();
        this.driverService = ICabApp.getApplicationComponent().getDriverServices();
    }

    /**
     * client -> server
     *
     * @param orderModelRequest
     */
    public void createNewOrderFromClient(OrderModelRequest orderModelRequest) {
//        clientService = ICabApp.getApplicationComponent().getClientService();
        Observable<OrderCreatorModelResponse> getTripObservable = RxRetrofitUtils.wrapRetrofitCall(clientService.getNewTripId(orderModelRequest));

        RxRetrofitUtils.wrapAsync(getTripObservable)
                .subscribe(response -> {
                    Log.d("MainActivity", "Success " + response.getStatus());

                }, exception -> {
                    Log.d("MainActivity", exception.getMessage());
                });
    }

    /**
     * client -> server
     *
     * @param syncMessageModelRequest
     */
    public void checkStateOrder(SyncMessageModelRequest syncMessageModelRequest) {
        Observable<SyncMessageModelResponse> syncMessageModelObservable = RxRetrofitUtils.wrapRetrofitCall(clientService.getStatusMessage(syncMessageModelRequest));
        RxRetrofitUtils.wrapAsync(syncMessageModelObservable)
                .subscribe(responce -> {
                    Log.d("MainActivity", "Success " + responce.getStatus() + " session " + responce.getResult().getSession_id());
                }, exception -> {
                    Log.d("MainActivity", exception.getMessage());
                });
    }

    /**
     * driver -> server - agree
     *
     * @param cancelCurrentOrderFromDriver
     */
    public void setCancelCurrentOrderFromClient(CancelOrderRequest cancelCurrentOrderFromDriver) {
//        driverService = ICabApp.getApplicationComponent().getClientService();
        Observable<OrderCancelerModelResponse> setAgreeOrder = RxRetrofitUtils.wrapRetrofitCall(clientService.setCanceleCurrentOrder(cancelCurrentOrderFromDriver));

        RxRetrofitUtils.wrapAsync(setAgreeOrder)
                .subscribe(response -> {
                    Log.d("MainActivity", "Success " + response.getStatus());
                }, exception -> {
                    Log.d("MainActivity", exception.getMessage());
                });
    }
    //----------------------------confirmation the orden from driver --------------------------------------

    /**
     * driver -> server - agree
     *
     * @param confirmOrderModelRequest
     */

    public void setAgreeCreateNewOrderFromDriver(ConfirmOrderModelRequest confirmOrderModelRequest) {
//        driverService = ICabApp.getApplicationComponent().getClientService();
        Observable<OrderConfirmationModelResponse> setAgreeOrder = RxRetrofitUtils.wrapRetrofitCall(driverService.setDriverOrderConfirmation(confirmOrderModelRequest));

        RxRetrofitUtils.wrapAsync(setAgreeOrder)
                .subscribe(response -> {
                    Log.d("MainActivity", "Success " + response.getStatus());
                }, exception -> {
                    Log.d("MainActivity", exception.getMessage());
                });
    }

    /**
     * driver -> server - agree
     *
     * @param cancelCurrentOrderFromDriver
     */
    public void setCancelCurrentOrderFromDriver(CancelOrderRequest cancelCurrentOrderFromDriver) {
//        driverService = ICabApp.getApplicationComponent().getClientService();
        Observable<OrderCancelerModelResponse> setAgreeOrder = RxRetrofitUtils.wrapRetrofitCall(driverService.setCanceleCurrentOrder(cancelCurrentOrderFromDriver));

        RxRetrofitUtils.wrapAsync(setAgreeOrder)
                .subscribe(response -> {
                    Log.d("MainActivity", "Success " + response.getStatus());
                }, exception -> {
                    Log.d("MainActivity", exception.getMessage());
                });
    }
}
