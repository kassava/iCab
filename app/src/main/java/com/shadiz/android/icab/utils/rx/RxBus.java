package com.shadiz.android.icab.utils.rx;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * The example of event bus pattern on Rx.
 * Here’s how you post an event to the bus:
 * <p><pre>{@code
 * public void onTapButtonClicked() {
 *  rxBus.send(new TapEvent());
 * }
 * }</pre>
 * Here’s how you listen to those events from other fragments/services etc
 * (note that it is important to subscribe to the exact same _rxBus instance that was used to post the events):
 * <p><pre>{@code
 * rxBus.toObserverable()
 * .subscribe(new Action1<Object>() {
 * @Override
 * public void call(Object event) {
 * if(event instanceof TapEvent) {
 * showTapText();
 * }else if(event instanceof SomeOtherEvent) {
 * doSomethingElse();
 * }
 * }
 * });
 * }</pre>
 *
 * Created on 29.01.2017.
 */

public class RxBus {

    private final Subject<Object, Object> bus = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o) {
        bus.onNext(o);
    }

    public Observable<Object> toObservable() {
        return bus;
    }
}
