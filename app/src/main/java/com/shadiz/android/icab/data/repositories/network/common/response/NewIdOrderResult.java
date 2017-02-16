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
    private Integer newId;

    public Integer getNewId() {
        return newId;
    }

    public void setNewId(Integer newId) {
        this.newId = newId;
    }
}
