package com.shadiz.android.icab.dagger.network;


import com.shadiz.android.icab.dagger.network.ApiModule;
import com.shadiz.android.icab.data.repositories.network.TaxiApi;
import com.shadiz.android.icab.data.repositories.network.TaxiService;

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
    public TaxiService provideTaxiService(TaxiApi taxiApi) {
        return new TaxiService(taxiApi);
    }
}
