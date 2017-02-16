package com.shadiz.android.icab.data.repositories.network.client;


import com.shadiz.android.icab.data.repositories.network.client.models.response.order.CanceledOrderModelResponse;
import com.shadiz.android.icab.data.repositories.network.client.models.response.rate_after_trip.NewOrderCreatorModelResponse;
import com.shadiz.android.icab.data.repositories.network.client.models.response.trip_info.TripInfoResponse;
import com.shadiz.android.icab.data.repositories.network.common.response.message_sync.SyncMessageModelResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created on 11.01.17.
 */

public interface ClientApi {
    /**
     * device_uuid": "",
     * login: "",
     * device_platform: "android",
     * message: "{"appear_type":"0", "type":"clientServer_userWantsToOrderTaxi_agree","user_from":"","user_to":"","message_body":""
     * codesModel:{
     * code2 (JSON) - координаты, где забрать клиента ( longitude / latitude / precision / geocode )
     * code3 (string) - время, когда нужно забрать клиента ( Y-m-d H:i:s формат UTC )
     * code4 (JSON) - координаты доставки ( longitude / latitude / precision / geocode )
     * code5 (int)- количество мест, которое запросил клиент ( от 1 до 6 )
     * code6 (string) - комментарий клиента ( опционально )
     * code7 (int) - длинна поездки в метрах
     * code8 (int) - длительность поездки в секундах
     * code9 (int) - ID водилы кому отослать заказ, или зафейлить если он не примет.
     * code10 (JSON) - фильтр поиска (radius / rateFrom / rateTo / acceptCC) (left empty will fill this up with system values from config).}"
     * <p>
     * Responce:
     * session_id;
     * login;
     * trip_id
     */
    @Headers({"Accept: application/json"})
    @FormUrlEncoded
    @POST("/api/messageCreate.php")
    Call<NewOrderCreatorModelResponse> getTripId(@Field("device_uuid") String device_uuid, @Field("login") String login, @Field("device_platform") String android, @Field("message") String messageModel);


    /**
     * device_uuid": "",
     * login: "",
     * device_platform: "android",
     * date_from: ""
     * <p>
     * <p>
     * responce:
     * id,
     * user_from: 0,
     * user_to": "",
     * appear_type": "0",
     * type: "serverClient_userWantsToOrderTaxi_disagree",
     * expiretime: "",
     * message_body: null,
     * code1: "2074",
     * code2: "TTL Reached",
     * code3: null,
     * code4: null,
     * code5: null,
     * code6: null,
     * code7: null,
     * code8: null,
     * code9: null,
     * code10: null,
     * date_created: "2017-02-01 06:55:40",
     * date_sent: "2017-02-01 06:55:40"
     */
    @Headers({"Accept: application/json"})
    @FormUrlEncoded
    @POST("/api/messageSync.php")
    Call<SyncMessageModelResponse> getStatusOrders(@Field("date_from") String date, @Field("device_uuid") String device_uuid, @Field("login") String login, @Field("device_platform") String android);

    /**
     * @param device_uuid
     * @param login
     * @param android
     * @param messageModel: type (string) - clientServer_userWantsToCancelOrder_agree; code1 (int) - id поездки; code2 (string) - причина отмены ( опционально ); code3 () -, code4 () -
     * @return
     */
    @FormUrlEncoded
    @POST("/api/messageCreate.php")
    Call<CanceledOrderModelResponse> getIdCanceledOrder(@Field("device_uuid") String device_uuid, @Field("login") String login, @Field("device_platform") String android, @Field("message") String messageModel);

    /**
     * @param device_uuid
     * @param login
     * @param android
     * @param messageModel: newId    - id поездки; duration -  длительность поездки в секундах; mileage  - длинна поездки в метрах; cost     -  стоимость поездки; currency - валюта стоимости поездки
     * @return
     */
    @FormUrlEncoded
    @POST("/api/messageCreate.php")
    Call<NewOrderCreatorModelResponse> setRateDriverAfterTrip(@Field("device_uuid") String device_uuid, @Field("login") String login, @Field("device_platform") String android, @Field("message") String messageModel);


    @FormUrlEncoded
    @POST("/api/clientGetTripsInfo.php")
    Call<TripInfoResponse> getClientTripsInfo(@Field("device_uuid") String device_uuid, @Field("login") String login,
                                              @Field("device_platform") String android, @Field("trip_filter") String tripFilter);
}