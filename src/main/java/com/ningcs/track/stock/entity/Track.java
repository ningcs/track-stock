package com.ningcs.track.stock.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Track
 * @author 
 */
@Data
public class Track implements Serializable {
    private Integer id;

    /**
     * 基金名称
     */
    private String fund;

    /**
     * 操作方式(0:buy,1:sell)
     */
    private Integer direction;

    /**
     * 公司股票代码
     */
    private String ticker;

    /**
     * 股数
     */
    private String shares;

    /**
     * 仓位%
     */
    private String percentage;

    /**
     * 收盘价
     */
    private BigDecimal closeprice;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 更新时间
     */
    private Date trackingtime;

    /**
     * 创建时间
     */
    private Date createtime;

    private static final long serialVersionUID = 1L;
}