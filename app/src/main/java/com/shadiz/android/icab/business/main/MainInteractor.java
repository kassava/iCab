package com.shadiz.android.icab.business.main;

import com.shadiz.android.icab.data.repositories.network.models.request.CreateTripModel;
import com.shadiz.android.icab.data.repositories.network.models.request.MessageModel;
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
//    void getTripId(MessageModel message);
    void getTripId(CreateTripModel tripModel);
}
