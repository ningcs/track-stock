package com.ningcs.track.stock.option;

import lombok.Data;

/**
 * @Auther: ningcs
 * @Date: 2021/05/13/17:55
 * @Description:
 */
@Data
public class OptionRespList {

    /**
     * 公司
     */
    private String company;

    /**
     * 代码
     */
    private String symbol;

    /**
     * 类型: 1call/-1 put
     *
     */
    private String type;


    /**
     * 过期日
     */
    private String expiration;

    /**
     * 目标价
     */
    private String strike;


    /**
     * 买入金额
     */
    private String size;



    /**
     * 捕获时间
     */
    private String received;


    /**
     * 描述
     */
    private boolean desc=false;



}
