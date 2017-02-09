package com.shadiz.android.icab.dagger.network;

import com.shadiz.android.icab.data.repositories.network.client.ClientApi;
import com.shadiz.android.icab.data.repositories.network.client.ClientService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 09.02.17.
 */
@Module(includes = {ApiModule.class})
public class ClientModule {
    @Provides
    @Singleton
    public ClientService provideClientService(ClientApi clientApi) {
        return new ClientService(clientApi);
    }
}
