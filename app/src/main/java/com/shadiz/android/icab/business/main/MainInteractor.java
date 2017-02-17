package com.shadiz.android.icab.business.main;

import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageRequestModel;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;

import rx.Observable;

/**
 * Created on 28.01.2017.
 */

public interface MainInteractor {

    /**
     * @return onError if PersonalInfo loading error was occurred in Repository,
     * onSuccess in other cases
     */
    void getStatusMessages(SyncMessageRequestModel syncModel);


    Observable<String> getClientTripsInfo();

    /**
     * Create new order
     * @return
     */
    Observable<Integer> getClientTripId();

    /**
     * user want cancel order
     * @return
     */
    Observable<Integer> getClientIdCanceledOrder(CharSequence id);

    /**
     * The client receiver a status of orders
     * @return
     */
    Observable<SyncMessageModelResponse> getClientStatusOfOrders();


    /**
     * The driver receives a list of orders
     * @return
     */
    Observable<SyncMessageModelResponse> getStatusOfDriversOrders();

    /**
     * The driver receives a list of orders
     * @return
     */
    Observable<String> getDriverTripsInfo();

    /**
     * The driver has agree to order
     * @return
     */
    Observable<Integer> getDriverAgreeToOrder(CharSequence id);

    /**
     * The driver has disagree to order
     * @return
     */
    Observable<Integer> getDriverDisagreeToOrder(CharSequence id);

    /**
     * The driver has cancel to order
     * @return
     */
    Observable<Integer> getDriverCancelOrder(CharSequence id);
}
