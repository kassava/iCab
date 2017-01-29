package com.shadiz.android.icab.ui.main.presenter;

import com.shadiz.android.icab.business.main.MainInteractor;
import com.shadiz.android.icab.ui.main.models.FullDriverDataModel;
import com.shadiz.android.icab.ui.main.views.MainView;
import com.shadiz.android.icab.utils.rx.RxSchedulersAbs;
import com.shadiz.android.icab.utils.rx.RxSchedulersTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import rx.Observable;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created on 29.01.2017.
 */

public class MainPresenterTest {

    private MainPresenterImpl mainPresenterImpl;
    private MainInteractor mainInteractor;

    private MainView mainView;

    private FullDriverDataModel fullDriverDataModel;
    private String rating = "2";


    @Before
    public void beforeEachTest() {
        mainInteractor = mock(MainInteractor.class);
        RxSchedulersAbs rxSchedulersAbs = new RxSchedulersTest();
        mainPresenterImpl = new MainPresenterImpl(mainInteractor, rxSchedulersAbs);
        mainView = mock(MainView.class);

        fullDriverDataModel = new FullDriverDataModel(
                "babat",
                "bmv",
                rating
        );
    }

    @Test
    public void loadFreeDrivers_successLoad() {
        // mock interactor
        when(mainInteractor.getFreeDrivers()).thenReturn(Observable.fromCallable(() -> fullDriverDataModel));
        // presenter bindView
        mainPresenterImpl.bindView(mainView);
        // action loadPersonalInfo
        mainPresenterImpl.clickToOrderButton();
        // verify interactor was called
        verify(mainInteractor).getFreeDrivers();
        // verify calls of view methods
        InOrder inOrder = inOrder(mainView);
        inOrder.verify(mainView).showProgress();
        inOrder.verify(mainView).showDrivers("FullDriverDataModel{" +
                "name='babat' car='bmv'" + " rating= '" + rating + '\'' + '}');
        inOrder.verify(mainView).hideProgress();
        // verify showError was not called
        verify(mainView, never()).showError();
    }

    @Test
    public void loadFreeDrivers_nullCache_errorLoad() {
        // mock interactor
        when(mainInteractor.getFreeDrivers()).thenReturn(Observable.error(new RuntimeException()));
        // presenter bindView
        mainPresenterImpl.bindView(mainView);
        // action loadPersonalInfo
        mainPresenterImpl.clickToOrderButton();
        // verify interactor was called
        verify(mainInteractor).getFreeDrivers();
        // verify calls of view methods (progress and showError)
        InOrder inOrder = inOrder(mainView);
        inOrder.verify(mainView).showProgress();
        inOrder.verify(mainView).hideProgress();
        inOrder.verify(mainView).showError();
        // verify info was not showed to view
        verify(mainView, never()).showDrivers(anyString());
    }
}
