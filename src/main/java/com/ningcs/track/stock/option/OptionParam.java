package com.ningcs.track.stock.option;

import lombok.Data;

/**
 * @Auther: ningcs
 * @Date: 2021/05/13/17:40
 * @Description:
 */
@Data
public class OptionParam {

    /**
     * 签名默认web
     */
    private String sign;

    /**
     * 分页默认10
     */
    private String limit;

    /**
     * 名称
     */
    private String symbol;

    /**
     * 开始时间
     */
    private String date_from;

    /**
     * 结束时间
     */
    private String date_to;

    /**
     * 到期日开始开始时间
     */
    private String expiry_from;

    /**
     * 到期日结束时间
     */
    private String expiry_to;

    /**
     * 目标价开始区间
     */
    private String strike_to;

    /**
     * 目标价结束区间
     */
    private String strike_from;

    /**
     * 购买金额区间
     */
    private String size_from;

    /**
     * 购买金额区间
     */
    private String size_to;

    /**
     * CALL/PUT
     */
    private String type;
}
