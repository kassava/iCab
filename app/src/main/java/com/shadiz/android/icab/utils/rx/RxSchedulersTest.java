package com.shadiz.android.icab.utils.rx;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created on 29.01.2017.
 */

public class RxSchedulersTest extends RxSchedulersAbs {

    @Override
    public Scheduler getMainThreadScheduler() {
        return Schedulers.immediate();
    }

    @Override
    public Scheduler getIOScheduler() {
        return Schedulers.immediate();
    }

    @Override
    public Scheduler getComputationScheduler() {
        return Schedulers.immediate();
    }

}
