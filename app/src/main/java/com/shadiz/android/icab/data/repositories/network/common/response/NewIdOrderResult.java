package com.shadiz.android.icab.data.repositories.network.common.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shadiz.android.icab.data.repositories.network.common.BaseResult;

/**
 * Created by OldMan on 05.02.2017.
 */

public class NewIdOrderResult extends BaseResult {
    @SerializedName("newId")
    @Expose
    private String newId;

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }
}
