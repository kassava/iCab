package com.shadiz.android.icab.ui.main.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.shadiz.android.icab.ICabApp;
import com.shadiz.android.icab.R;
import com.shadiz.android.icab.dagger.main.MainModule;
import com.shadiz.android.icab.ui.main.presenter.MainPresenter;

import javax.inject.Inject;

/**
 * Created on 28.01.2017.
 */

public class MainFragment extends Fragment implements MainView {

    @Inject
    MainPresenter mainPresenter;

    private TextView clientUserWantsToOrderTaxiAgree, clientWantsCancelOrderTextView, clientStatusOrdersTextView, clientGetTripsInfoTextView,  clientRateDriverAfterTripTextView,
            driverMessageSyncTextView, driverGetTripsInfoTextView, driverAgreeToOrderTextView, driverDisagreeToOrderTextView, driverUserWantsToCancelOrderAgreeTextView,
            clientStatusTextView, activeClientOrderTextView, activeDriveOrderTextView;
    private ProgressBar progressBar;
    private CoordinatorLayout coordinatorLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        ICabApp.get(getContext()).getApplicationComponent().plus(new MainModule()).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        clientGetTripsInfoTextView = (TextView) view.findViewById(R.id.clientGetTripsInfoTextView);
        clientGetTripsInfoTextView.setOnClickListener(v -> mainPresenter.clientGetTripsInfo());
        driverGetTripsInfoTextView = (TextView) view.findViewById(R.id.driverGetTripsInfoTextView);
        driverGetTripsInfoTextView.setOnClickListener(v -> mainPresenter.driverGetTripsInfo());

        //-----------client create order----------------------
        clientUserWantsToOrderTaxiAgree = (TextView) view.findViewById(R.id.clientUserWantsToOrderTaxiAgree);
        clientUserWantsToOrderTaxiAgree.setOnClickListener(v -> mainPresenter.clientClickToCreateOrderButton());
        //------------client cancel the order---------------
        clientWantsCancelOrderTextView = (TextView) view.findViewById(R.id.clientWantsCancelOrderTextView);
        clientWantsCancelOrderTextView.setOnClickListener(v -> mainPresenter.clientClickToCancelOrderButton(clientUserWantsToOrderTaxiAgree.getText()));
        //------------client status orders-------------------
        clientStatusOrdersTextView = (TextView) view.findViewById(R.id.clientStatusOrdersTextView);
        clientStatusOrdersTextView.setOnClickListener(v -> mainPresenter.clientMessageSync());
        //---------------client rate to drive after trip--------
        clientRateDriverAfterTripTextView = (TextView) view.findViewById(R.id.clientRateDriverAfterTripTextView);
        clientRateDriverAfterTripTextView.setOnClickListener(v -> mainPresenter.clientMessageSync());

        //---------------driver status order-------------------
        driverMessageSyncTextView = (TextView) view.findViewById(R.id.driverMessageSyncTextView);
        driverMessageSyncTextView.setOnClickListener(v -> mainPresenter.driverMessageSync());
        //---------------driver has agree to order--------------
        driverAgreeToOrderTextView = (TextView) view.findViewById(R.id.driverAgreeToOrderrTextView);
        driverAgreeToOrderTextView.setOnClickListener(v -> mainPresenter.driverAgreeToOrder(activeClientOrderTextView.getText()));
        //---------------driver has disagree to order------------
        driverDisagreeToOrderTextView = (TextView) view.findViewById(R.id.driverDisagreeToOrderTextView);
        driverDisagreeToOrderTextView.setOnClickListener(v -> mainPresenter.driverDisagreeToOrder(activeClientOrderTextView.getText()));
        //---------------driver has cancel to order------------
        driverUserWantsToCancelOrderAgreeTextView = (TextView) view.findViewById(R.id.driverUserWantsToCancelOrderAgreeTextView);
        driverUserWantsToCancelOrderAgreeTextView.setOnClickListener(v -> mainPresenter.driverCancelOrder(activeClientOrderTextView.getText()));

        activeClientOrderTextView = (TextView) view.findViewById(R.id.activeClientOrderTextView);
        activeDriveOrderTextView = (TextView) view.findViewById(R.id.activeDriverOrderTextView);
        clientStatusTextView = (TextView) view.findViewById(R.id.activeClientOrderTextView);

        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.main_layout);
        mainPresenter.bindView(this);

        return view;
    }

    @Override
    public void onDestroyView() {
        mainPresenter.unbindView();
        super.onDestroyView();
    }
    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String msg) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, msg, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public void showDrivers(String driversInfo) {
        Log.d("Fragment", driversInfo);
    }

    @Override
    public void showClientTripsInfo(String id) {
        Toast.makeText(getContext(), "trip info: " + id, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showIdNewOrder(int id) {
        getActivity().runOnUiThread(() -> activeClientOrderTextView.setText(String.valueOf(id)));
        Toast.makeText(getContext(), "new order id: " + id, Toast.LENGTH_SHORT).show();
        mainPresenter.driverMessageSync();
    }

    @Override
    public void showIdCanceledOrder(int id) {
        Toast.makeText(getContext(), "Canceled Order: " + id, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showStatusOfClientOrders(String order) {
        getActivity().runOnUiThread(() -> clientStatusTextView.setText(String.valueOf(order)));

    }

    @Override
    public void showDriversTripsInfo(String info) {
        getActivity().runOnUiThread(() -> activeDriveOrderTextView.setText(info));

    }

    @Override
    public void showStatusOfDriverOrders(String order) {
        getActivity().runOnUiThread(() -> driverMessageSyncTextView.setText(String.valueOf(order)));

    }

    @Override
    public void showDriverAgreeToOrder(int order) {
        Toast.makeText(getContext(), "The driver has agree to order: " + order, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDriverDisagreeToOrder(int order) {
        Toast.makeText(getContext(), "The driver has disagree to order: " + order, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showDriverCancelOrders(int trips) {
        Toast.makeText(getContext(), "The driver has cancel to order: " + trips, Toast.LENGTH_SHORT).show();

    }
}
