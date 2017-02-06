package com.shadiz.android.icab.dagger.network;


import com.shadiz.android.icab.data.repositories.network.client.ClientApi;
import com.shadiz.android.icab.data.repositories.network.client.ClientService;
import com.shadiz.android.icab.data.repositories.network.driver.DriverApi;
import com.shadiz.android.icab.data.repositories.network.driver.DriverService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oldman on 11.01.17.
 */
@Module(includes = {ApiModule.class})
public class TaxiModule {
    @Provides
    @Singleton
    public ClientService provideClientService(ClientApi clientApi) {
        return new ClientService(clientApi);
    }
    @Provides
    @Singleton
    public DriverService provideDriverService(DriverApi driverApi) {
        return new DriverService(driverApi);
    }
}