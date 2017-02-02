package com.shadiz.android.icab.dagger.realm;

import com.shadiz.android.icab.data.repositories.RealmRepo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 02.02.2017.
 */
@Module
public class RealmRepoModule {

    @Provides
    @Singleton
    public RealmRepo provideRealmRepo() {
        return new RealmRepo();
    }
}
