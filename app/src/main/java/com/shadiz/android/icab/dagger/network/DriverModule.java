package com.shadiz.android.icab.dagger.network;

import com.shadiz.android.icab.data.repositories.network.client.ClientApi;
import com.shadiz.android.icab.data.repositories.network.client.ClientService;
import com.shadiz.android.icab.data.repositories.network.driver.DriverApi;
import com.shadiz.android.icab.data.repositories.network.driver.DriverService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 09.02.17.
 */

@Module(includes = {ApiModule.class})
public class DriverModule {
    @Provides
    @Singleton
    public DriverService provideClientService(DriverApi driverApi) {
        return new DriverService(driverApi);
    }
}
