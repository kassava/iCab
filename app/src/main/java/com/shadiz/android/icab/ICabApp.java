package com.shadiz.android.icab;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.shadiz.android.icab.dagger.application.AppComponent;
import com.shadiz.android.icab.dagger.application.AppModule;
import com.shadiz.android.icab.dagger.application.DaggerAppComponent;

/**
 * Created on 28.01.2017.
 */

public class ICabApp extends Application {

    @NonNull
    private AppComponent appComponent;

    @NonNull
    public static ICabApp get(@NonNull Context context) {
        return (ICabApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = prepareAppComponent().build();
    }

    @NonNull
    private DaggerAppComponent.Builder prepareAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this));
    }

    @NonNull
    public AppComponent applicationComponent() {
        return appComponent;
    }
}
