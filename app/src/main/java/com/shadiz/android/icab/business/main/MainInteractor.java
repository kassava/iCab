package com.shadiz.android.icab.business.main;

import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.request.SyncMessageModelRequest;
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
    Observable<FullDriverDataModel> getFreeDrivers();
    void getStatusMessages(SyncMessageModelRequest syncModel);
    void getTripId(OrderModelRequest tripModel);
}
