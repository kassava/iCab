package com.shadiz.android.icab.data.repositories.network;

import com.shadiz.android.icab.data.repositories.network.models.request.CreateTripModel;
import com.shadiz.android.icab.data.repositories.network.models.request.MessageModel;
import com.shadiz.android.icab.data.repositories.network.models.response.TripModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created on 11.01.17.
 */

public interface TaxiApi {
//    @GET("clientGetTripsInfo")
//    Call<OrderModel> getClientGetTripsInfo(@Query("q") String city);

    /**
     * type (string) - clientServer_userWantsToOrderTaxi_agree
     * code2 (JSON) - координаты, где забрать клиента ( longitude / latitude / precision / geocode )
     * code3 (string) - время, когда нужно забрать клиента ( Y-m-d H:i:s формат UTC )
     * code4 (JSON) - координаты доставки ( longitude / latitude / precision / geocode )
     * code5 (int)- количество мест, которое запросил клиент ( от 1 до 6 )
     * code6 (string) - комментарий клиента ( опционально )
     * code7 (int) - длинна поездки в метрах
     * code8 (int) - длительность поездки в секундах
     * code9 (int) - ID водилы кому отослать заказ, или зафейлить если он не примет.
     * code10 (JSON) - фильтр поиска (radius / rateFrom / rateTo / acceptCC) (left empty will fill this up with system values from config).
     */
//    @Headers({
//            "device_uuid: 3af83a99f6f8ad7",
//            "login: 3333333333",
//            "device_platform: android"
//    })
    @POST("/api/messageCreate.php")
    Call<TripModel> getTripId(@Body CreateTripModel messageModel);
    

}