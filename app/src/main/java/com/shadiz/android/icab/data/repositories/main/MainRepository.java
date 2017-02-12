package com.shadiz.android.icab.data.repositories.main;


import com.shadiz.android.icab.business.main.listener.OrderListener;
import com.shadiz.android.icab.data.repositories.network.common.request.order.OrderModelRequest;
import com.shadiz.android.icab.data.repositories.network.main.DriverModel;

import rx.Observable;

/**
 * Created on 28.01.2017.
 */

public interface MainRepository {

    Observable<DriverModel> getDrivers();

    void getIdNewOrder(OrderModelRequest request, OrderListener listener);

}
