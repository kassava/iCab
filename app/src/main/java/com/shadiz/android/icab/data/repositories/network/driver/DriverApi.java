package com.shadiz.android.icab.data.repositories.network.driver;

import com.shadiz.android.icab.data.repositories.network.driver.models.response.order_confirm.OrderConfirmationModelResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 01.02.17.
 */

public interface DriverApi {
    @FormUrlEncoded
    @POST("/api/messageCreate.php")
    Call<OrderConfirmationModelResponse> setDriverOrderConfirmation(@Field("device_uuid") String device_uuid, @Field("login") String login, @Field("device_platform") String android, @Field("message")String messageModel);

}
