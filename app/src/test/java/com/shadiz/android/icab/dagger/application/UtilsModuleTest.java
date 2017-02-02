package com.shadiz.android.icab.dagger.application;

import com.shadiz.android.icab.utils.rx.RxSchedulers;
import com.shadiz.android.icab.utils.rx.RxSchedulersAbs;
import com.shadiz.android.icab.utils.rx.RxSchedulersTest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 02.02.2017.
 */
@Module
public class UtilsModuleTest {

    @Provides
    @Singleton
    RxSchedulersTest provideRxSchedulersTest() {
        return new RxSchedulersTest();
    }

    @Provides
    @Singleton
    RxSchedulersAbs provideRxSchedulersAbs() {
        return new RxSchedulers();
    }
}
