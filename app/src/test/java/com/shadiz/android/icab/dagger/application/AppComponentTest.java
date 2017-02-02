package com.shadiz.android.icab.dagger.application;

import com.shadiz.android.icab.RealmRepoTest;
import com.shadiz.android.icab.dagger.realm.RealmRepoModuleTest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created on 02.02.2017.
 */

@Singleton
@Component(modules = {AppModuleTest.class, UtilsModuleTest.class, RealmRepoModuleTest.class})
public interface AppComponentTest extends AppComponent {

    void inject(RealmRepoTest realmRepo);

}
