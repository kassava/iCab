package com.shadiz.android.icab.dagger.application;

import com.shadiz.android.icab.ICabApp;
import com.shadiz.android.icab.dagger.main.MainComponent;
import com.shadiz.android.icab.dagger.main.MainModule;
import com.shadiz.android.icab.dagger.realm.RealmRepoModule;
import com.shadiz.android.icab.data.repositories.RealmRepo;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created on 28.01.2017.
 */

@Component(modules = {AppModule.class, UtilsModule.class, RealmRepoModule.class})
@Singleton
public interface AppComponent {

    MainComponent plus(MainModule mainModule);

    void inject(ICabApp app);

    void inject(RealmRepo realmRepo);
}
