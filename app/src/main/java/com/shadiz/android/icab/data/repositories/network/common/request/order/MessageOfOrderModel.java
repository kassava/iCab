package com.shadiz.android.icab.data.repositories.network.common.request.order;

/**
 * Created on 31.01.17.
 */

public class MessageOfOrderModel {
    private int user_from, user_to, appear_type, code8, code9;
    private String code1, code3, code5, code6, code2, code4, code7, code10, type, message_body;


    public String getType() {
        return type;
    }

    /**
     * @param type - serverDriver_userWantsToOrderTaxi_agree
     */
    public void setType(String type) {
        this.type = type;
    }

    public String getMessage_body() {
        return message_body;
    }

    public void setMessage_body(String message_body) {
        this.message_body = message_body;
    }

    public int getUser_from() {
        return user_from;
    }

    /**
     *
     * @param user_from - от кого
     */
    public void setUser_from(int user_from) {
        this.user_from = user_from;
    }

    public int getUser_to() {
        return user_to;
    }

    /**
     *
     * @param user_to - кому
     */
    public void setUser_to(int user_to) {
        this.user_to = user_to;
    }

    public int getAppear_type() {
        return appear_type;
    }

    public void setAppear_type(int appear_type) {
        this.appear_type = appear_type;
    }

    public int getCode8() {
        return code8;
    }

    /**
     *
     * @param code8 - длительность поездки в секундах
     */
    public void setCode8(int code8) {
        this.code8 = code8;
    }

    public int getCode9() {
        return code9;
    }

    /**
     *
     * @param code9 - ID водилы кому отослать заказ, или зафейлить если он не примет.
     */
    public void setCode9(int code9) {
        this.code9 = code9;
    }

    public String getCode1() {
        return code1;
    }

    /**
     * @param code1 - id поездки
     */
    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getCode3() {
        return code3;
    }

    /**
     * @param code3 - дата и время, когда нужно забрать клиента ( если отложенный )
     */
    public void setCode3(String code3) {
        this.code3 = code3;
    }

    public String getCode5() {
        return code5;
    }

    /**
     *  @param code5 -  сколько мест нужно ( от 1 до 6 )
     */
    public void setCode5(String code5) {
        this.code5 = code5;
    }

    public String getCode6() {
        return code6;
    }

    /**
     *
     * @param code6 - комментарий клиента
     */
    public void setCode6(String code6) {
        this.code6 = code6;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public String getCode4() {
        return code4;
    }

    /**
     *
     * @param code4 - координаты доставки ( longitude / latitude / geocode )
     */
    public void setCode4(String code4) {
        this.code4 = code4;
    }

    public String getCode7() {
        return code7;
    }

    /**
     *
     * @param code7 - ?
     */
    public void setCode7(String code7) {
        this.code7 = code7;
    }

    public String getCode10() {
        return code10;
    }

    /**
     *
     * @param code10 - 1 если заказ пришел с сайта
     */
    public void setCode10(String code10) {
        this.code10 = code10;
    }
}
