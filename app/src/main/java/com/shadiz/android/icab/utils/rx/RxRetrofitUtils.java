package com.shadiz.android.icab.utils.rx;

import com.shadiz.android.icab.data.repositories.network.TaxiError;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created on 31.01.17.
 */

public class RxRetrofitUtils {
    public static <T> Observable<T> wrapRetrofitCall(final Call<T> call) {
        return Observable.create(subscriber ->
        {
            final Response<T> execute;
            try {
                execute = call.execute();
            } catch (IOException e) {
                subscriber.onError(e);
                return;
            }
            if (execute.isSuccessful()) {
                subscriber.onNext(execute.body());
            } else {
                subscriber.onError(new TaxiError(execute.errorBody()));
            }
        });
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
