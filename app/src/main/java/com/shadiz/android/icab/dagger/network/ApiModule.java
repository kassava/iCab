package com.shadiz.android.icab.dagger.network;

import com.shadiz.android.icab.data.repositories.network.TaxiApi;

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
    public TaxiApi provideApi(Retrofit retrofit) {
        return retrofit.create(TaxiApi.class);
    }
}