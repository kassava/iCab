package com.shadiz.android.icab.business.main;

import com.shadiz.android.icab.data.network.models.response.main.CarModel;
import com.shadiz.android.icab.data.network.models.response.main.DriverModel;
import com.shadiz.android.icab.data.repositories.MainRepository;
import com.shadiz.android.icab.ui.main.models.FullDriverDataModel;

import org.junit.Before;
import org.junit.Test;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created on 29.01.2017.
 */

public class MainInteractorTest {

    private MainRepository mainRepository;
    private MainInteractorImpl mainInteractorImpl;

    @Before
    public void beforeEachTest() {
        mainRepository = mock(MainRepository.class);
        mainInteractorImpl = new MainInteractorImpl(mainRepository);
    }

    @Test
    public void getFreeDrivers_allSuccess() {
        // mock
        when(mainRepository.getDrivers()).thenReturn(Observable.fromCallable(() ->
                new DriverModel("aba", new CarModel("mers", "a123bn"), "4")));

        // create TestSubscriber
        TestSubscriber<FullDriverDataModel> testSubscriber = TestSubscriber.create();
        // call method and get result
        mainInteractorImpl.getFreeDrivers().subscribe(testSubscriber);
        testSubscriber.awaitTerminalEvent();
        // test no errors was not occurred
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
        // test of the received PersonalFullDataModel
        FullDriverDataModel fullDriverDataModel = testSubscriber.getOnNextEvents().get(0);
        assertThat(fullDriverDataModel.getName()).isEqualTo("aba");
        assertThat(fullDriverDataModel.getRating()).isEqualTo("4");
        assertThat(fullDriverDataModel.getCar()).isEqualTo("Car{name='mers' number='a123bn'}");
    }

    @Test
    public void getFreeDrivers_driversError() {
        // mock
        when(mainRepository.getDrivers()).thenReturn(Observable.fromCallable(() ->
                new DriverModel("bab", new CarModel("mers", "a123bn"), "4")));
        when(mainRepository.getDrivers()).thenReturn(Observable.error(new IllegalStateException()));
        // create TestSubscriber
        TestSubscriber<FullDriverDataModel> testSubscriber = TestSubscriber.create();
        // call method and get result
        mainInteractorImpl.getFreeDrivers().subscribe(testSubscriber);
        testSubscriber.awaitTerminalEvent();
        // test error was occurred
        testSubscriber.assertError(MainInteractorException.class);
    }

    @Test
    public void getFreeDrivers_allSuccess_butAllNull() {
        // mock
        when(mainRepository.getDrivers()).thenReturn(Observable.fromCallable(() -> null));
        // create TestSubscriber
        TestSubscriber<FullDriverDataModel> testSubscriber = TestSubscriber.create();
        // call method and get result
        mainInteractorImpl.getFreeDrivers().subscribe(testSubscriber);
        testSubscriber.awaitTerminalEvent();
        // test no errors was not occurred
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
        // test of the received PersonalFullDataModel
        FullDriverDataModel fullDriverDataModel = testSubscriber.getOnNextEvents().get(0);
        assertThat(fullDriverDataModel.getName()).isEqualTo("");
        assertThat(fullDriverDataModel.getCar()).isEqualTo("");
        assertThat(fullDriverDataModel.getRating()).isEqualTo("");
    }
}
