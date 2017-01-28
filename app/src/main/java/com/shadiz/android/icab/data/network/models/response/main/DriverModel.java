package com.shadiz.android.icab.data.network.models.response.main;

import android.support.annotation.Nullable;

/**
 * Created on 28.01.2017.
 */

public class DriverModel {

    private String name;
    private CarModel car;
    private String rating;

    public DriverModel(@Nullable String name, @Nullable CarModel car, @Nullable String rating) {
        this.name = name;
        this.car = car;
        this.rating = rating;
    }

    @Nullable
    public String getRating() {
        return rating;
    }

    @Nullable
    public CarModel getCar() {
        return car;
    }

    @Nullable
    public String getName() {
        return name;
    }
}
