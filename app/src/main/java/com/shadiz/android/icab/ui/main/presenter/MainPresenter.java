package com.shadiz.android.icab.ui.main.presenter;

import com.shadiz.android.icab.ui.main.views.MainView;

/**
 * Created on 28.01.2017.
 */

public interface MainPresenter {

    void bindView(MainView mainView);
    void unbindView();

    void clientGetTripsInfo();
    void clientClickToCreateOrderButton();
    void clientClickToCancelOrderButton(CharSequence id);
    void clientMessageSync();

    void driverMessageSync();
    void driverGetTripsInfo();
    void driverAgreeToOrder(CharSequence id);
    void driverDisagreeToOrder(CharSequence id);
    void driverCancelOrder(CharSequence id);
}
