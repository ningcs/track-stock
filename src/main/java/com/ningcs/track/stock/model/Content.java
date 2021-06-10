package com.ningcs.track.stock.model;

import lombok.Data;

/**
 * @Auther: ningcs
 * @Date: 2021/04/19/17:15
 * @Description:
 */
@Data
public class Content {

    /**
     * 基金名称
     */
    private String fund;

    /**
     * 日期
     */
    private String date;

    /**
     * 操作名称买/卖
     */
    private String direction;
    /**
     * 股票代码
     */
    private String ticker;
    /**
     * 股数
     */
    private String shares;
    /**
     * 基金百分比
     */
    private String percentage;

    /**
     * 收盘价
     */
    private String closePrice;

    /**
     * 总价 单位w
     */
    private String amount;

    /**
     * 描述
     */
    private boolean desc;


}
