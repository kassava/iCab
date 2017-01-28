package com.shadiz.android.icab.dagger.application;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created on 28.01.2017.
 */
@Module
public class AppModule {

    private final Context appContext;

    public AppModule(@NonNull Context context) {
        appContext = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return appContext;
    }
}
