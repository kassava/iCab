package com.shadiz.android.icab.utils.rx;

import rx.Observable;
import rx.Scheduler;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Utils class that provide Rx Schedulers and appropriate Rx Transformers
 * <p>
 * Created on 28.01.2017.
 */

public abstract class RxSchedulersAbs {

    abstract public Scheduler getMainThreadScheduler();

    abstract public Scheduler getIOScheduler();

    abstract public Scheduler getComputationScheduler();

    public <T> Observable.Transformer<T, T> getIOToMainTransformer() {
        return objectObservable -> objectObservable
                .subscribeOn(getIOScheduler())
                .observeOn(getMainThreadScheduler());
    }

    public <T> Single.Transformer<T, T> getIOToMainTransformerSingle() {
        return objectObservable -> objectObservable
                .subscribeOn(getIOScheduler())
                .observeOn(getMainThreadScheduler());
    }

    public <T> Observable.Transformer<T, T> getComputationToMainTransformer() {
        return objectObservable -> objectObservable
                .subscribeOn(getComputationScheduler())
                .observeOn(getMainThreadScheduler());
    }

    public <T> Single.Transformer<T, T> getComputationToMainTransformerSingle() {
        return objectObservable -> objectObservable
                .subscribeOn(getComputationScheduler())
                .observeOn(getMainThreadScheduler());
    }

    public static <T> Observable<T> wrapAsync(Observable<T> observable) {
        return wrapAsync(observable, Schedulers.io());
    }

    public static <T> Observable<T> wrapAsync(Observable<T> observable, Scheduler scheduler) {
        return observable
                .subscribeOn(scheduler)
                .observeOn(AndroidSchedulers.mainThread());
    }
}