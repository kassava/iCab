package com.shadiz.android.icab.data.repositories.network.driver;

import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.driver.models.response.current_confirm.OrderConfirmationModelResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 01.02.17.
 */

public interface DriverApi {
    /**
     * @param device_uuid
     * @param login
     * @param android
     * @param messageModel
     * @return
     */
    @FormUrlEncoded
    @POST("/api/messageCreate.php")
    Call<OrderConfirmationModelResponse> setDriverOrderConfirmation(@Field("device_uuid") String device_uuid, @Field("login") String login, @Field("device_platform") String android, @Field("message") String messageModel);

    /**
     * @param device_uuid
     * @param login
     * @param android
     * @param messageModel
     * @return
     */
    @FormUrlEncoded
    @POST("/api/messageCreate.php")
    Call<OrderConfirmationModelResponse> setOffToTheClient(@Field("device_uuid") String device_uuid, @Field("login") String login, @Field("device_platform") String android, @Field("message") String messageModel);

    /**
     * @param date
     * @param device_uuid
     * @param login
     * @param android
     * @return
     */
    @FormUrlEncoded
    @POST("/api/messageSync.php")
    Call<SyncMessageModelResponse> setStatusOrder(@Field("date_from") String date, @Field("device_uuid") String device_uuid, @Field("login") String login, @Field("device_platform") String android);
}
