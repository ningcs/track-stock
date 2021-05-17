package com.ningcs.track.stock.option;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: ningcs
 * @Date: 2021/05/13/17:55
 * @Description:
 */
@Data
public class OptionResp {


    /**
     * 代码
     */
    private String symbol;

    /**
     * 类型: 1call/-1 put
     *
     */
    private Integer type;

    /**
     * 目标价
     */
    private String strike;

    /**
     * 买入是股票价格
     */
    private String spot;

    /**
     * 买入金额
     */
    private BigDecimal size;

    /**
     * 过期时间
     */
    private Integer expiration;

    /**
     * 捕获时间
     */
    private Integer received;



}
