package com.ningcs.track.stock.option;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xml.internal.security.Init;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @Auther: ningcs
 * @Date: 2021/05/13/17:25
 * @Description:
 */
@Slf4j
public class TrackOptionUtil {

    public static String url = "https://api.traceoption.com/v1.0/user/options/filter";

    //五大科技巨头
    public static String stockPools = "aapl,goog,fb,amzn,msft";
    //芯片
    public static String chipStockPools = "tsm,nvda,asml,qcom,avgo,txn,amd,mu,amat,lrcx,NXPI";
    //电商
    public static String netStockPools = "amzn,shop,baba,jd,pdd,se,ebay,meli,wish,etsy";
    //中概股
    public static String chipchinesePools = "nio,xpev,bidu,pdd,baba,futu,bili,jd";


    public static TreeMap<String, String> Init() {
        TreeMap<String, String> map = new TreeMap<>();
        //电商
        map.put("amzn", "亚马逊");
        map.put("shop", "Shopify");
        map.put("baba", "阿里巴巴");
        map.put("jd", "京东");
        map.put("pdd", "拼多多");
        map.put("se", "Sea Limited");
        map.put("ebay", "eBay");
        map.put("meli", "美卡多");
        map.put("wish", "Wish");
        map.put("etsy", "Etsy");



        //芯片
        map.put("tsm", "台积电");
        map.put("nvda", "英伟达");
        map.put("asml", "阿斯麦");
        map.put("qcom", "高通");
        map.put("avgo", "博通");
        map.put("txn", "德州仪器");
        map.put("amd", "AMD");
        map.put("mu", "美光科技");
        map.put("amat", "应用材料");
        map.put("lrcx", "拉姆研究");
        map.put("NXPI", "恩智浦");

        //中概股
        map.put("nio", "蔚来");
        map.put("xpev", "小鹏");
        map.put("bidu", "百度");
        map.put("pdd", "拼多多");
        map.put("baba", "阿里巴巴");
        map.put("futu", "富途");
        map.put("bili", "B站");
        map.put("jd", "京东");


        return map;
    }


    public static void main(String[] args) throws Exception {
        //初始化
        TreeMap<String, String> map = Init();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date_from = simpleDateFormat.parse("2021-05-11");
        Date date_to = simpleDateFormat.parse("2021-05-15");
        System.out.println("十大电商期权异动跟踪");
        StringBuilder stringBuilder1=new StringBuilder();
        map.forEach((k,v)->{
            stringBuilder1.append(v).append(",");
        });
        System.out.println("股票池："+stringBuilder1.toString());
        Arrays.asList(chipchinesePools.split(",")).forEach(s -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("?")
                    .append("sign").append("=").append("web")
                    .append("&").append("limit").append("=").append("10");
            stringBuilder.append("&").append("symbol").append("=").append(s);
            stringBuilder.append("&").append("date_from").append("=").append(date_from.getTime() / 1000);
            stringBuilder.append("&").append("date_to").append("=").append(date_to.getTime() / 1000);
            stringBuilder.append("&").append("expiry_to").append("=").append(getCurrYearLast().getTime() / 1000);
            try {
                String result = TraceRestfulHttpUtil.sendGet(url + stringBuilder.toString());
//                log.info("响应结果：{}",result);
                JSONObject jsonObject = JSON.parseObject(result);
                JSONArray jsonArray = (JSONArray) jsonObject.get("entities");
                List<OptionResp> optionRespList = JSON.parseArray(jsonArray.toJSONString(), OptionResp.class);
                if (CollectionUtils.isEmpty(optionRespList)) {
                    return;
                }
                String symbol = optionRespList.get(0).getSymbol();
                System.out.println(map.get(symbol.toLowerCase()) + "期权异动捕获:");
                optionRespList.forEach(optionResp -> {
                    String typeName = "看涨(call)";
                    if (optionResp.getType() == -1) {
                        typeName = "看跌(put)";
                    }

                    String expiration = new SimpleDateFormat("yyyy-MM-dd").format(new Date(optionResp.getExpiration() * 1000L));
                    String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(optionResp.getReceived() * 1000L));
                    System.out.println("在" + result1
                            + "以" + optionResp.getStrike() + "买入" + map.get(optionResp.getSymbol().toLowerCase())
                            + " "+optionResp.getSize().divide(new BigDecimal(10000), 0, BigDecimal.ROUND_HALF_DOWN) + "w美元"
                            + typeName + ",到期日：" + expiration + "\n");
                });


            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    /**
     * 获取当年的最后一天
     *
     * @param year
     * @return
     */
    public static Date getCurrYearLast() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * 获取某年最后一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }


}
