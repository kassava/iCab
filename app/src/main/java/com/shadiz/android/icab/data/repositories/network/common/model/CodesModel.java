package com.shadiz.android.icab.data.repositories.network.common.model;


import com.shadiz.android.icab.data.repositories.network.common.LocationModelRequest;
import com.shadiz.android.icab.data.repositories.network.common.RequirementToTheDriverModel;

/**
 * Created on 31.01.17.
 */

public class CodesModel {
    private String code1, code3, code6;
    private  int code5, code7, code8, code9;
    private LocationModelRequest code2, code4;
    private RequirementToTheDriverModel code10;



//    /**
//     *
//     * @param code1 - координаты, где забрать клиента ( longitude / latitude / precision / geocode )
//     * @param code2 - время, когда нужно забрать клиента ( Y-m-d H:i:s формат UTC )
//     * @param code3 - координаты доставки ( longitude / latitude / precision / geocode )
//     * @param code4 -  (JSON) - координаты доставки ( longitude / latitude / precision / geocode )
//     * @param code5 - количество мест, которое запросил клиент ( от 1 до 6 )
//     * @param code6 - комментарий клиента ( опционально )
//     * @param code7 - длинна поездки в метрах
//     * @param code8 - длительность поездки в секундах
//     * @param code9 - ID водилы кому отослать заказ, или зафейлить если он не примет.
//     * @param code10(JSON) - фильтр поиска (radius / rateFrom / rateTo / acceptCC) (left empty will fill this up with system values from config).
//     * code10 example:{"radius":"20000","rateFrom":0,"rateTo":7,"acceptCC":1}
//     */
    public CodesModel(String code1, LocationModelRequest code2, String code3, LocationModelRequest code4, int code5, String code6, int code7, int code8, int code9, RequirementToTheDriverModel code10) {
        this.code1 = code1;
        this.code3 = code3;
        this.code4 = code4;
        this.code5 = code5;
        this.code6 = code6;
        this.code7 = code7;
        this.code8 = code8;
        this.code9 = code9;
        this.code2 = code2;
        this.code10 = code10;
    }


    public String getCode1() {

        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getCode3() {
        return code3;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }

    public LocationModelRequest getCode4() {
        return code4;
    }

    public void setCode4(LocationModelRequest code4) {
        this.code4 = code4;
    }

    public int getCode5() {
        return code5;
    }

    public void setCode5(int code5) {
        this.code5 = code5;
    }

    public String getCode6() {
        return code6;
    }

    public void setCode6(String code6) {
        this.code6 = code6;
    }

    public int getCode7() {
        return code7;
    }

    public void setCode7(int code7) {
        this.code7 = code7;
    }

    public int getCode8() {
        return code8;
    }

    public void setCode8(int code8) {
        this.code8 = code8;
    }

    public int getCode9() {
        return code9;
    }

    public void setCode9(int code9) {
        this.code9 = code9;
    }

    public LocationModelRequest getCode2() {
        return code2;
    }

    public void setCode2(LocationModelRequest code2) {
        this.code2 = code2;
    }

    public RequirementToTheDriverModel getCode10() {
        return code10;
    }

    public void setCode10(RequirementToTheDriverModel code10) {
        this.code10 = code10;
    }
}
