package com.ningcs.track.stock.support;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ningcs.track.stock.util.RestfulHttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @Auther: ningcs
 * @Date: 2021/05/10/19:13
 * @Description:
 */
@Slf4j
public class StockUtils {

    //    public static String url = "https://www.alphavantage.co/query";
    public static String url = "https://api.tdameritrade.com/v1/marketdata/quotes";


    //    public static String key = "76PGJAKAVWWAYRQR";
    public static String key = "sQ0KVde9BoCRFVMAGi6Vhj8YyPKRtloe";

    public static void main(String[] args) {
        getStocks(new HashSet<>(Arrays.asList("aapl", "tsla")));
    }

    public static Map<String, BigDecimal> getStocks(Set<String> stockNameList) {
        if (CollectionUtils.isEmpty(stockNameList)) {
            return new HashMap<>();
        }
        HashMap<String, BigDecimal> hashMap = new HashMap<>();
//            fixedThreadPool.execute(() -> {
        stockNameList.forEach(stockName -> {

            try {
                Map<String, String> params = new HashMap<>();
                params.put("symbol", stockName);
                params.put("apikey", key);

//                    Map<String, String> params = new HashMap<>();
//                    params.put("city", "110101");
//                    params.put("key", "3ff9482454cb60bcb73f65c8c48d4209");
                String result = null;
                try {
//                    Thread.sleep(1*100);
                    result = RestfulHttpUtil.sendGet(url, params);
                } catch (Exception e) {
                    log.info("请求失败: {}#####",e.getMessage());
                }
                if (StringUtils.isEmpty(result)) {
                    log.info("请求失败: #####");
                    return;
                }


                log.info("获取stock：{}，result:{}", stockName, JSON.toJSONString(result));
                JSONObject obj = JSON.parseObject(result); //将Json字符串转化为Json对象
                JSONObject jsonObject1 = obj.getJSONObject(stockName.toUpperCase());
                BigDecimal price = (BigDecimal) jsonObject1.get("closePrice");
                hashMap.put(stockName, price);
            } catch (Exception e) {
                log.error("error:{}", e.getMessage());
                hashMap.put(stockName, BigDecimal.ZERO);
            }

        });
        System.out.println("stock.price: " + JSON.toJSONString(hashMap));
        return hashMap;
    }
}
