package com.shadiz.android.icab.dagger.application;

import android.content.Context;
import android.support.annotation.NonNull;

import com.shadiz.android.icab.ICabApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 28.01.2017.
 */
@Module
public class AppModule {

    private final ICabApp application;

    public AppModule(@NonNull ICabApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public ICabApp provideApp() {
        return application;
    }

    @Provides
    @Singleton
    public Context provideAppContext() {
        return application.getApplicationContext();
    }
}
