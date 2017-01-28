package com.shadiz.android.icab.ui.main.models;

import android.support.annotation.NonNull;

/**
 * Created on 28.01.2017.
 */

public class FullDriverDataModel {

    private String name;
    private String car;
    private String rating;

    public FullDriverDataModel(@NonNull String name, @NonNull String carName, @NonNull String rating) {
        this.name = name;
        this.car = carName;
        this.rating = rating;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getCar() {
        return car;
    }

    @NonNull
    public String getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "FullDriverDataModel{" +
                "name='" + name + '\'' +
                " car='" + car + '\'' +
                " rating= '" + rating + '\'' +
                '}';
    }
}
