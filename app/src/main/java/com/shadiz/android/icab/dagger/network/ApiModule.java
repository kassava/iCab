package com.shadiz.android.icab.dagger.network;

import com.shadiz.android.icab.data.repositories.network.client.ClientApi;
import com.shadiz.android.icab.data.repositories.network.driver.DriverApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by oldman on 11.01.17.
 */

@Module(includes = {RetrofitModule.class})
public class ApiModule {
    @Provides
    @Singleton
    public ClientApi provideClientApi(Retrofit retrofit) {
        return retrofit.create(ClientApi.class);
    }

    @Provides
    @Singleton
    public DriverApi provideDriverApi(Retrofit retrofit) {
        return retrofit.create(DriverApi.class);
    }
}