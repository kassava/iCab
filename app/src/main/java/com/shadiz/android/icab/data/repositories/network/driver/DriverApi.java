package com.shadiz.android.icab.data.repositories.network.driver;

import com.shadiz.android.icab.data.repositories.network.client.models.response.order.OrderCancelerModelResponse;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;
import com.shadiz.android.icab.data.repositories.network.driver.models.response.current_confirm.OrderConfirmationModelResponse;
import com.shadiz.android.icab.data.repositories.network.driver.models.response.trip_info.DriverTripResponse;

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
     * @param messageModel: type (string) - clientServer_userWantsToCancelOrder_agree; code1 (int) - id поездки; code2 (string) - причина отмены ( опционально ); code3 () -, code4 () -
     * @return
     */
    @FormUrlEncoded
    @POST("/api/messageCreate.php")
    Call<OrderCancelerModelResponse> setCanceledOrder(@Field("device_uuid") String device_uuid, @Field("login") String login, @Field("device_platform") String android, @Field("message") String messageModel);

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
     * @param device_uuid
     * @param login
     * @param android
     * @param trip_filter
     * @return
     */
    @FormUrlEncoded
    @POST("/api/driverGetTripsInfo.php")
    Call<DriverTripResponse> getDriverTripsInfo(@Field("device_uuid") String device_uuid, @Field("login") String login,
                                                @Field("device_platform") String android, @Field("trip_filter") String trip_filter,
                                                @Field("trip_client_in_radius_meters") Integer trip_client_in_radius_meters,
                                                @Field("trip_max_distance_meters") Integer trip_max_distance_meters);

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