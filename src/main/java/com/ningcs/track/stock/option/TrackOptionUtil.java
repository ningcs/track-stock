package com.ningcs.track.stock.option;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: ningcs
 * @Date: 2021/05/13/17:25
 * @Description:
 */
@Slf4j
public class TrackOptionUtil {

    public static String url = "https://api.traceoption.com/v1.0/user/options/filter";

    //ARKK
    public static String fundstockPools = "arkk,spy,uvxy";

    //五大科技巨头
    public static String stockPools = "aapl,goog,fb,amzn,msft";

    //成长股
    public static String growingstockPools = "tsla,roku,sq,pypl,snap,pins,shop,se,wish,etsy";
    //芯片
    public static String chipStockPools = "tsm,nvda,asml,qcom,avgo,txn,amd,mu,amat,lrcx,NXPI";
    //    //电商
//    public static String netStockPools = "amzn,shop,se,ebay,meli,wish,etsy,";
    //中概股
    public static String chipchinesePools = "baba,jd,pdd,nio,xpev,bidu,pdd,futu,bili";

    static StringBuilder stringBuilder = new StringBuilder();

    public static String totalPools = stringBuilder.append(fundstockPools).append(",")
            .append(stockPools).append(",")
            .append(growingstockPools).append(",")
            .append(chipStockPools).append(",")
            .append(chipchinesePools).append(",").toString();

    public static TreeMap<String, String> Init() {
        TreeMap<String, String> map = new TreeMap<>();
        //arl
        map.put("arkk", "ARKK基金");
        map.put("spy", "标普基金");
        map.put("uvxy", "恐慌指数");

        //五大科技巨头
        map.put("aapl", "苹果");
        map.put("goog", "谷歌");
        map.put("fb", "Facebook");
        map.put("amzn", "亚马逊");
        map.put("msft", "微软");

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

        //成长股
        map.put("tsla", "特斯拉");
        map.put("roku", "Roku");
        map.put("sq", "Square");
        map.put("pypl", "PayPal");
        map.put("snap", "Snapchat");
        map.put("pins", "Pinterest");


        return map;
    }


    public static void main(String[] args) throws Exception {
        //初始化
        TreeMap<String, String> map = Init();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date_from = simpleDateFormat.parse("2021-05-14");
        Date date_to = simpleDateFormat.parse("2021-05-17");


        System.out.println("股票池");

        System.out.println("基金:");
        List<String> collect5 = Arrays.asList(fundstockPools.split(",")).stream().map(a -> map.get(a)).collect(Collectors.toList());
        System.out.println(String.join(",", collect5));

        System.out.println("五大科技巨头:");
        List<String> collect = Arrays.asList(stockPools.split(",")).stream().map(a -> map.get(a)).collect(Collectors.toList());
        System.out.println(String.join(",", collect));

        System.out.println("成长股:");
        List<String> collect1 = Arrays.asList(growingstockPools.split(",")).stream().map(a -> map.get(a)).collect(Collectors.toList());
        System.out.println(String.join(",", collect1));

        System.out.println("芯片股:");
        List<String> collect2 = Arrays.asList(chipStockPools.split(",")).stream().map(a -> map.get(a)).collect(Collectors.toList());
        System.out.println(String.join(",", collect2));

        System.out.println("中概股:");
        List<String> collect3 = Arrays.asList(chipchinesePools.split(",")).stream().map(a -> map.get(a)).collect(Collectors.toList());
        System.out.println(String.join(",", collect3));

        List<CalculateStock> calculateStocks = new ArrayList<>();
        List<OptionRespList> optionRespLists = new ArrayList<>();
        OptionRespList respList = new OptionRespList();
        respList.setCompany("公司");
        respList.setSymbol("股票");
        respList.setType("类型");
        respList.setStrike("目标价");
        respList.setSize("交易金额");
        respList.setExpiration("过期日");
        respList.setReceived("捕获时间");
        respList.setDesc(true);
        optionRespLists.add(respList);


        Arrays.asList(totalPools.split(",")).forEach(s -> {
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


                if (CollectionUtils.isEmpty(optionRespList) || optionRespList.size() <= 3) {
                    return;
                }

                optionRespList
                        .forEach(optionResp -> {
                            OptionRespList optionResp1 = new OptionRespList();
                            BeanUtils.copyProperties(optionResp, optionResp1);
                            optionResp1.setCompany(map.get(optionResp.getSymbol().toLowerCase()));
                            optionResp1.setSymbol(optionResp.getSymbol());
                            optionResp1.setStrike(optionResp.getStrike());
                            optionResp1.setType("CALL");
                            if (optionResp.getType() == -1) {
                                optionResp1.setType("PUT");
                            }
                            BigDecimal amount = optionResp.getSize().divide(new BigDecimal(10000), 0, BigDecimal.ROUND_HALF_DOWN);
                            optionResp1.setSize(amount+"");
                            String expiration = new SimpleDateFormat("yyyy-MM-dd").format(new Date(optionResp.getExpiration() * 1000L));
                            String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(optionResp.getReceived() * 1000L));
                            optionResp1.setExpiration(expiration);
                            optionResp1.setReceived(result1);
                            optionRespLists.add(optionResp1);
                        });

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        optionRespLists.stream().filter(a -> a.getSize().compareTo("100") > 0)
                .filter(a->!a.isDesc())
                .collect(Collectors.groupingBy(OptionRespList::getSymbol,Collectors.toList()))
                .forEach((k,v) -> {
                    System.out.println(map.get(k.toLowerCase()) + "(" + k.toUpperCase() + ")" + "期权异动捕获:");

                    CalculateStock calculateStock = new CalculateStock();
                    calculateStock.setTotal(optionRespLists.size());
                    calculateStock.setSymbol(k);
                    calculateStock.setSymbolName(map.get(k.toLowerCase()));

                    v.forEach(optionResp->{

                        String typeName;
                        if (optionResp.getType().toLowerCase().equals("call")) {
                            typeName = "看涨（call）";
                            calculateStock.setPutCount(calculateStock.getPutCount() + 1);
                        } else {
                            typeName = "看涨（call）";
                            calculateStock.setCallCount(calculateStock.getCallCount() + 1);
                        }

                        System.out.println("在" + optionResp.getReceived()
                                + "以" + optionResp.getStrike() + "买入" + map.get(optionResp.getSymbol().toLowerCase())
                                + " " + optionResp.getSize() + "w美元"
                                + typeName + ",到期日：" + optionResp.getExpiration());
                    });
                    calculateStocks.add(calculateStock);
                });

        StringBuilder stringBuilderCall = new StringBuilder();
        StringBuilder middle = new StringBuilder();
        StringBuilder stringBuilderput = new StringBuilder();
        calculateStocks.forEach(calculateStock1 -> {

            if (calculateStock1.getCallCount() - calculateStock1.getPutCount() <= 1) {
                middle.append(calculateStock1.getSymbolName()).append(",");
                return;
            }

            if (calculateStock1.getCallCount() > calculateStock1.getPutCount()) {
                stringBuilderCall.append(calculateStock1.getSymbolName()).append(",");
            } else {
                stringBuilderput.append(calculateStock1.getSymbolName()).append(",");
            }


        });

        System.out.println("总结：");
        Set<String> collect4 = calculateStocks.stream()
                .map(CalculateStock::getSymbolName).collect(Collectors.toSet());
        String join = String.join(",", collect4);
        System.out.println("今日机构期权交易十分活跃的股票：" + join);

        if (StringUtils.isNotBlank(stringBuilderCall)) {
            System.out.println("今日机构期权做多的股票：" + stringBuilderCall.toString());
        }
        if (StringUtils.isNotBlank(middle)) {
            System.out.println("今日期权多头和空头博弈的股票：" + middle.toString());
        }
        if (StringUtils.isNotBlank(stringBuilderput)) {
            System.out.println("今日机构期权做空的股票：" + stringBuilderput.toString());
        }

        List<OptionRespList> respLists = optionRespLists.stream().filter(a -> a.getSize().compareTo("500000") > 0).collect(Collectors.toList());

        StockimageUtils.dealData(respLists);

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
