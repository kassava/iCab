package com.shadiz.android.icab.dagger.main;

import com.shadiz.android.icab.ui.main.views.MainFragment;

import dagger.Subcomponent;

/**
 * Created on 04.02.2017.
 */

@Subcomponent(modules = {MainModuleTest.class})
@MainScope
public interface MainComponentTest {

    void inject(MainFragment mainFragment);
}
