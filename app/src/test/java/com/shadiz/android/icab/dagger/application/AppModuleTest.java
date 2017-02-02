package com.shadiz.android.icab.dagger.application;

import android.content.Context;

import org.robolectric.RuntimeEnvironment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 02.02.2017.
 */
@Module
public class AppModuleTest {

    @Provides
    @Singleton
    public Context provideAppContext() {
        return RuntimeEnvironment.application.getApplicationContext();
    }
}
