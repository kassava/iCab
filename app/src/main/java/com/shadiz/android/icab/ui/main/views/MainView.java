package com.shadiz.android.icab.ui.main.views;

/**
 * Created on 28.01.2017.
 */

public interface MainView {

    void showProgress();
    void hideProgress();
    void showError(String msg);

    void showDrivers(String driversInfo); // show drivers in log

    void showClientTripsInfo(String info);
    void showIdNewOrder(int id);
    void showIdCanceledOrder(int id);
    void showStatusOfClientOrders(String order);

    void showDriversTripsInfo(String info);
    void showStatusOfDriverOrders(String order);
    void showDriverAgreeToOrder(int order);
    void showDriverDisagreeToOrder(int order);

    void showDriverCancelOrders(int trips);
}
