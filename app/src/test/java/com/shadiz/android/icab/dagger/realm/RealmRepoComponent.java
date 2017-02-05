package com.shadiz.android.icab.dagger.realm;

import com.shadiz.android.icab.RealmRepoTest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created on 05.02.2017.
 */
@Singleton
@Component(modules = {RealmRepoModuleTest.class})
public interface RealmRepoComponent {

    void inject(RealmRepoTest realmRepo);
}
