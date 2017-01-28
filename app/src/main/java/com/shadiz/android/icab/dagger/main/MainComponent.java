package com.shadiz.android.icab.dagger.main;

import com.shadiz.android.icab.ui.main.views.MainFragment;

import dagger.Subcomponent;

/**
 * Created on 28.01.2017.
 */

@Subcomponent(modules = {MainModule.class})
@MainScope
public interface MainComponent {

    void inject(MainFragment mainFragment);

}
