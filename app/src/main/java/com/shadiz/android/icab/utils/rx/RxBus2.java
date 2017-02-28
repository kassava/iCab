package com.shadiz.android.icab.utils.rx;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.util.SparseArray;

import java.lang.annotation.Retention;
import java.util.HashMap;
import java.util.Map;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

import static java.lang.annotation.RetentionPolicy.SOURCE;


/**
 * Created by Pierce Zaifman on 2017-01-02.
 */

public final class RxBus2 {

    private static SparseArray<PublishSubject<Object>> subjectMap = new SparseArray<>();
    private static Map<Object, CompositeSubscription> subscriptionsMap = new HashMap<>();

    public static final int SUBJECT_MESSAGE = 0;
    public static final int SUBJECT_ANOTHER_SUBJECT = 1;

    @Retention(SOURCE)
    @IntDef({SUBJECT_MESSAGE, SUBJECT_ANOTHER_SUBJECT})
    @interface Subject {
    }

    private RxBus2() {
        // hidden constructor
    }

    /**
     * Get the subject or create it if it's not already in memory.
     */
    @NonNull
    private static PublishSubject<Object> getSubject(@Subject int subjectCode) {
        PublishSubject<Object> subject = subjectMap.get(subjectCode);
        if (subject == null) {
            subject = PublishSubject.create();
            subject.subscribeOn(AndroidSchedulers.mainThread());
            subjectMap.put(subjectCode, subject);
        }

        return subject;
    }

    /**
     * Get the CompositeSubscription or create it if it's not already in memory.
     */
    @NonNull
    private static CompositeSubscription getCompositeSubscription(@NonNull Object object) {
        CompositeSubscription compositeSubscription = subscriptionsMap.get(object);
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
            subscriptionsMap.put(object, compositeSubscription);
        }

        return compositeSubscription;
    }

    /**
     * Subscribe to the specified subject and listen for updates on that subject. Pass in an object to associate
     * your registration with, so that you can unsubscribe later.
     * <br/><br/>
     * <b>Note:</b> Make sure to call {@link RxBus#unregister(Object)} to avoid memory leaks.
     */
    public static void subscribe(@Subject int subject, @NonNull Object lifecycle, @NonNull Action1<Object> action) {
        Subscription subscription = getSubject(subject).subscribe(action);
        getCompositeSubscription(lifecycle).add(subscription);
    }

    /**
     * Unregisters this object from the bus, removing all subscriptions.
     * This should be called when the object is going to go out of memory.
     */
    public static void unregister(@NonNull Object lifecycle) {
        //We have to remove the composition from the map, because once you unsubscribe it can't be used anymore
        CompositeSubscription compositeSubscription = subscriptionsMap.remove(lifecycle);
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
        }
    }

    /**
     * Publish an object to the specified subject for all subscribers of that subject.
     */
    public static void publish(@Subject int subject, @NonNull Object message) {
        getSubject(subject).onNext(message);
    }
}
