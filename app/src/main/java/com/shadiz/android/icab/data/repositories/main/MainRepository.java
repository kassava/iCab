package com.shadiz.android.icab.data.repositories.main;

import com.shadiz.android.icab.data.network.models.response.main.DriverModel;

import rx.Observable;

/**
 * Created on 28.01.2017.
 */

public interface MainRepository {

    Observable<DriverModel> getDrivers();

}
