package com.shadiz.android.icab.dagger;

import com.shadiz.android.icab.ICabApp;
import com.shadiz.android.icab.dagger.application.AppComponent;
import com.shadiz.android.icab.dagger.application.AppModule;
import com.shadiz.android.icab.dagger.application.DaggerAppComponent;
import com.shadiz.android.icab.dagger.realm.RealmRepoModule;

import java.util.Objects;

/**
 * Created on 02.02.2017.
 */

public class Injector {

    private static AppComponent appComponent;

    private Injector() {}

    public static void initializeAppComponent(ICabApp iCabApp) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(iCabApp))
                .realmRepoModule(new RealmRepoModule())
                .build();
    }

    public static AppComponent getAppComponent() {
        Objects.requireNonNull(appComponent, "applicationComponent is null");
        return appComponent;
    }
}
