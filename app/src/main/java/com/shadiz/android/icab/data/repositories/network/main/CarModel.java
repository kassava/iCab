package com.shadiz.android.icab.data.repositories.network.main;

import android.support.annotation.Nullable;

/**
 * Created on 28.01.2017.
 */

public class CarModel {

    private String name;
    private String number;

    public CarModel(@Nullable String name, @Nullable String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                " number='" + number + '\'' +
                '}';
    }
}
