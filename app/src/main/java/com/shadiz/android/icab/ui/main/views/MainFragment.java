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

    private TextView orderTaxiTextView, cancelOrderTextView, statusDriverOrdersTextView, statusClientOrdersTextView;
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

        orderTaxiTextView = (TextView) view.findViewById(R.id.order);
        orderTaxiTextView.setOnClickListener(v -> mainPresenter.clientClickToCreateOrderButton());

        cancelOrderTextView = (TextView) view.findViewById(R.id.cancelOrderTextView);
        cancelOrderTextView.setOnClickListener(v -> mainPresenter.clientClickToCancelOrderButton(orderTaxiTextView.getText()));

        statusDriverOrdersTextView = (TextView) view.findViewById(R.id.newOrderTextView);
        statusDriverOrdersTextView.setOnClickListener(v -> mainPresenter.driverMessageSync());

        statusClientOrdersTextView = (TextView) view.findViewById(R.id.statusOrdersTextView);
        statusClientOrdersTextView.setOnClickListener(v -> mainPresenter.clientMessageSync());


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
    public void showIdNewOrder(int id) {
        getActivity().runOnUiThread(() -> orderTaxiTextView.setText(String.valueOf(id)));
        Toast.makeText(getContext(), "new order id: " + id, Toast.LENGTH_SHORT).show();
        mainPresenter.driverMessageSync();
    }

    @Override
    public void showIdCanceledOrder(int id) {
        Toast.makeText(getContext(), "Canceled Order: " + id, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showStatusOfClientOrders(String order) {
        getActivity().runOnUiThread(() -> statusClientOrdersTextView.setText(String.valueOf(order)));

    }

    @Override
    public void showStatusOfDriverOrders(String order) {
        getActivity().runOnUiThread(() -> statusDriverOrdersTextView.setText(String.valueOf(order)));

    }
}
