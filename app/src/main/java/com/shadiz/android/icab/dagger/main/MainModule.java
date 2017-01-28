package com.shadiz.android.icab.dagger.main;

import com.shadiz.android.icab.business.main.MainInteractor;
import com.shadiz.android.icab.business.main.MainInteractorImpl;
import com.shadiz.android.icab.data.repositories.MainRepository;
import com.shadiz.android.icab.data.repositories.MainRepositoryImpl;
import com.shadiz.android.icab.ui.main.presenter.MainPresenter;
import com.shadiz.android.icab.ui.main.presenter.MainPresenterImpl;
import com.shadiz.android.icab.utils.rx.RxSchedulersAbs;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 28.01.2017.
 */

@Module
public class MainModule {

    @Provides
    @MainScope
    MainPresenter provideMainPresenter(MainInteractor mainInteractor,
                                       RxSchedulersAbs rxSchedulersAbs) {
        return new MainPresenterImpl(mainInteractor, rxSchedulersAbs);
    }

    @Provides
    @MainScope
    MainRepository provideMainRepository() {
        return new MainRepositoryImpl();
    }

    @Provides
    @MainScope
    MainInteractor provideMainInteractor(MainRepository mainRepository) {
        return new MainInteractorImpl(mainRepository);
    }
}
