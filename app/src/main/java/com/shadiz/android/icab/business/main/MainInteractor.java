package com.shadiz.android.icab.business.main;

import com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info.TripInfoResponse;
import com.shadiz.android.icab.data.repositories.network.common.request.order.CancelOrderRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.ui.main.models.FullDriverDataModel;

import rx.Observable;

/**
 * Created on 28.01.2017.
 */

public interface MainInteractor {

    /**
     * @return onError if PersonalInfo loading error was occurred in Repository,
     * onSuccess in other cases
     */
    void getStatusMessages(SyncMessageModelRequest syncModel);


    Observable<String> getClientTripsInfo();

    /**
     * Create new order
     * @return
     */
    Observable<Integer> getTripId();

    /**
     * user want cancel order
     * @return
     */
    Observable<Integer> getIdCanceledOrder(CharSequence id);

    /**
     * The client receiver a status of orders
     * @return
     */
    Observable<SyncMessageModelResponse> getStatusOfClientOrders();


    /**
     * The driver receives a list of orders
     * @return
     */
    Observable<SyncMessageModelResponse> getStatusOfDriversOrders();

}
