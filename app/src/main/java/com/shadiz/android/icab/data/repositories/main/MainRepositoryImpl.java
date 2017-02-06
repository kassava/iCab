package com.shadiz.android.icab.data.repositories.main;



import com.shadiz.android.icab.data.repositories.network.main.CarModel;
import com.shadiz.android.icab.data.repositories.network.main.DriverModel;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Created on 28.01.2017.
 */

public class MainRepositoryImpl implements MainRepository {

    @Override
    public Observable<DriverModel> getDrivers() {
        return Observable.timer(2, TimeUnit.SECONDS)
                .flatMap(aLong -> Observable.fromCallable(() ->
                        new DriverModel("aba", new CarModel("mers", "a123bn"), "4"))
                );
    }
}
