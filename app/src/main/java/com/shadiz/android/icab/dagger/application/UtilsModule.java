package com.shadiz.android.icab.dagger.application;

import com.shadiz.android.icab.utils.rx.RxSchedulers;
import com.shadiz.android.icab.utils.rx.RxSchedulersAbs;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 28.01.2017.
 */

@Module
public class UtilsModule {

    @Provides
    @Singleton
    RxSchedulersAbs provideRxSchedulersAbs() {
        return new RxSchedulers();
    }

}
