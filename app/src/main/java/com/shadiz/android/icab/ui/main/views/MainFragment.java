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

import com.shadiz.android.icab.R;
import com.shadiz.android.icab.dagger.Injector;
import com.shadiz.android.icab.dagger.main.MainModule;
import com.shadiz.android.icab.data.realm.models.RealmDriverInfoModel;
import com.shadiz.android.icab.data.realm.table.ClientTable;
import com.shadiz.android.icab.data.repositories.RealmRepo;
import com.shadiz.android.icab.ui.main.presenter.MainPresenter;

import javax.inject.Inject;

/**
 * Created on 28.01.2017.
 */

public class MainFragment extends Fragment implements MainView {

    @Inject
    MainPresenter mainPresenter;
    @Inject
    RealmRepo realmRepo;

    private TextView orderTaxiTextView;
    private ProgressBar progressBar;
    private CoordinatorLayout coordinatorLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Injector.getAppComponent().plus(new MainModule()).inject(this);
        long time = realmRepo.getServiceStopTime();
        int id = realmRepo.getCarId();
        realmRepo.setClientKey(ClientTable.LAST_SELECTED_DRIVER, "dafffff");
        String driver = realmRepo.getClientKey(ClientTable.LAST_SELECTED_DRIVER);

        RealmDriverInfoModel realmDriverInfoModel = new RealmDriverInfoModel();
        realmDriverInfoModel.setName("ghjf");
        String  str = realmDriverInfoModel.getName();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        orderTaxiTextView = (TextView) view.findViewById(R.id.order);
        orderTaxiTextView.setOnClickListener(v -> mainPresenter.clickToOrderButton());
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
    public void showError() {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, getString(R.string.common_error), Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public void showDrivers(String driversInfo) {
        Log.d("Fragment", driversInfo);
    }
}
