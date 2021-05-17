package com.ningcs.track.stock.option;

import lombok.Data;

/**
 * @description:
 * @author: ningcs
 * @create: 2021-05-17 21:23
 **/
@Data
public class CalculateStock {

    private String symbol;
    private String symbolName;


    private Integer callCount=0;

    private Integer putCount=0;

    private Integer total;
}
