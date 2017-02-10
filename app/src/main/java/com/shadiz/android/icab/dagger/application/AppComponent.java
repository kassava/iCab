package com.shadiz.android.icab.dagger.application;

import com.shadiz.android.icab.dagger.main.MainComponent;
import com.shadiz.android.icab.dagger.main.MainModule;
import com.shadiz.android.icab.dagger.network.ClientModule;
import com.shadiz.android.icab.dagger.network.DriverModule;
import com.shadiz.android.icab.data.NetworkManager;
import com.shadiz.android.icab.data.repositories.network.client.ClientService;
import com.shadiz.android.icab.data.repositories.network.driver.DriverService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created on 28.01.2017.
 */

@Component(modules = {AppModule.class, UtilsModule.class, ClientModule.class, DriverModule.class, NetworkManagerModule.class})
@Singleton
public interface AppComponent {

    MainComponent plus(MainModule mainModule);

    ClientService getClientService();

    DriverService getDriverServices();

    NetworkManager getNetworkManager();

    void inject(ClientService taxiService);
}
