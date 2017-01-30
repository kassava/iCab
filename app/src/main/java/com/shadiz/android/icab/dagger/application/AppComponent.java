package com.shadiz.android.icab.dagger.application;

import com.shadiz.android.icab.dagger.main.MainComponent;
import com.shadiz.android.icab.dagger.main.MainModule;
import com.shadiz.android.icab.data.repositories.PrefsRepo;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created on 28.01.2017.
 */

@Component(modules = {AppModule.class, UtilsModule.class})
@Singleton
public interface AppComponent {

    MainComponent plus(MainModule mainModule);
}
