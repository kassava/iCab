package com.shadiz.android.icab.dagger.application;

import com.shadiz.android.icab.dagger.main.MainComponent;
import com.shadiz.android.icab.dagger.main.MainModule;
import com.shadiz.android.icab.dagger.network.TaxiModule;
import com.shadiz.android.icab.data.repositories.network.TaxiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created on 28.01.2017.
 */

@Component(modules = {AppModule.class, UtilsModule.class, TaxiModule.class})
@Singleton
public interface AppComponent {

    MainComponent plus(MainModule mainModule);
    TaxiService getTaxiService();

    void inject(TaxiService taxiService);
}
