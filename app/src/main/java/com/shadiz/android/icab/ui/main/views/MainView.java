package com.shadiz.android.icab.ui.main.views;

/**
 * Created on 28.01.2017.
 */

public interface MainView {

    void showProgress();
    void hideProgress();
    void showError();

    void showDrivers(String driversInfo); // show drivers in log
}
