package com.ningcs.track.stock.option;

import lombok.Data;

import java.util.List;

/**
 * @Auther: ningcs
 * @Date: 2021/05/14/16:32
 * @Description:
 */
@Data
public class TraceOptionResp {

    private String code;

    private List<OptionResp> entities;
}
