package com.shadiz.android.icab.dagger.application;

import android.content.Context;
import android.support.annotation.NonNull;

import com.shadiz.android.icab.data.NetworkManager;
import com.shadiz.android.icab.data.repositories.network.client.ClientApi;
import com.shadiz.android.icab.data.repositories.network.client.ClientService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 10.02.17.
 */

@Module
public class NetworkManagerModule {
    @Provides
    @Singleton
    public NetworkManager provideClientService() {
        return new NetworkManager();
    }
}
