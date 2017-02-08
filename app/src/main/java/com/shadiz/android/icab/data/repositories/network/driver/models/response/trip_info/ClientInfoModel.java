package com.shadiz.android.icab.data.repositories.network.driver.models.response.trip_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.response.BaseUserInfo;

/**
 * Created by oldman on 08.02.17.
 */

public class ClientInfoModel extends BaseUserInfo{
    @SerializedName("login")
    @Expose
    private Integer login;
    @SerializedName("surname")
    @Expose
    private Integer surname;
}
