package com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by oldman on 07.02.17.
 */

public class PostponedTripModel extends BaseTripResponse {
    @SerializedName("phone")
    @Expose
    String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
