package com.shadiz.android.icab;

import android.app.Application;

import com.shadiz.android.icab.dagger.Injector;
import com.shadiz.android.icab.data.repositories.RealmRepo;

import javax.inject.Inject;

/**
 * Created on 28.01.2017.
 */

public class ICabApp extends Application {

    @Inject
    RealmRepo realmRepo;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
        initRealm();
    }

    protected void initRealm() {
        realmRepo.setup();
    }

    protected void initDagger() {
        Injector.initializeAppComponent(this);
        Injector.getAppComponent().inject(this);
    }
}
