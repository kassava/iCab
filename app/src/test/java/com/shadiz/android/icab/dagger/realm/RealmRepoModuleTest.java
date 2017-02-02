package com.shadiz.android.icab.dagger.realm;

import com.shadiz.android.icab.data.repositories.RealmRepo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

/**
 * Created on 02.02.2017.
 */
@Module
public class RealmRepoModuleTest {

    private boolean isMockedDatabase;

    // for simplicity use variables, but you should create separated modules if needed
    public RealmRepoModuleTest(boolean mockDatabase) {
        this.isMockedDatabase = mockDatabase;
    }

    @Provides
    @Singleton
    public RealmRepo provideRealmRepo() {
        return isMockedDatabase ? mock(RealmRepo.class) : new RealmRepo();
    }
}
