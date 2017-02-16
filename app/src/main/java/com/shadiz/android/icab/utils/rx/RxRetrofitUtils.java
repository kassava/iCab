package com.shadiz.android.icab.utils.rx;

import android.util.Log;

import com.shadiz.android.icab.data.repositories.network.RetrofitError;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created on 31.01.17.
 */

public class RxRetrofitUtils {
    public static <T> Observable<T> wrapRetrofitCall(final Call<T> call) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
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
                    subscriber.onError(new RetrofitError(execute.errorBody()));
                }
            }
        });
    }
}
