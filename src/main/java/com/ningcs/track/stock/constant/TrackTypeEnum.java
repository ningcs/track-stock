package com.ningcs.track.stock.constant;

/**
 * @Auther: ningcs
 * @Date: 2021/06/09/17:44
 * @Description:
 */
public enum TrackTypeEnum {

    TRACK_TYPE_BUY(0,"buy"),
    TRACK_TYPE_SELL(1,"sell"),
    ;
    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String Message) {
        this.message = message;
    }

    TrackTypeEnum() {
    }

    TrackTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static  Integer getCode(String message) {
        for (TrackTypeEnum value : TrackTypeEnum.values()) {
            if (value.message.equals(message)) {
                return value.code;
            }
        }
        return null;
    }


    public static  String getMessage(Integer code) {
        for (TrackTypeEnum value : TrackTypeEnum.values()) {
            if (value.code.equals(code)) {
                return value.message;
            }
        }
        return "";
    }
}
