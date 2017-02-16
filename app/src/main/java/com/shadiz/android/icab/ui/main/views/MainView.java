package com.shadiz.android.icab.ui.main.views;

/**
 * Created on 28.01.2017.
 */

public interface MainView {

    void showProgress();
    void hideProgress();
    void showError(String msg);

    void showDrivers(String driversInfo); // show drivers in log
    void showIdNewOrder(int id);
    void showIdCanceledOrder(int id);
    void showStatusOfClientOrders(String order);

    void showStatusOfDriverOrders(String order);
}
