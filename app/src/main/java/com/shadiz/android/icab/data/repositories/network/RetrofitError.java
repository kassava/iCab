package com.shadiz.android.icab.data.repositories.network;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created on 11.01.17.
 */

public class RetrofitError extends Throwable {
    public RetrofitError(ResponseBody responseBody) {
        super(getMessage(responseBody));
    }

    private static String getMessage(ResponseBody responseBody) {
        try {
            return new JSONObject(responseBody.string()).optString("message");
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return "Unknown exception";
    }
}
