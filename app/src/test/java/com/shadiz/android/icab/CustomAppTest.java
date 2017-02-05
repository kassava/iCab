package com.shadiz.android.icab;

/**
 * Created on 02.02.2017.
 */

public class CustomAppTest extends ICabApp {

    @Override
    protected void initRealm() {
        // do nothing: RealmRepo.setup() throws java.lang.UnsatisfiedLinkError for testing
    }
}
