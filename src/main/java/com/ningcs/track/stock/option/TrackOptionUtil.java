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
    public static String fundstockPools = "arkk,spy,uvxy,gbtc";

    //科技巨头
    public static String growingstockPools = "aapl,goog,msft";

    //新能源energy
    public static String energystockPools = "tsla,nio,xpev";

    //芯片
    public static String chipStockPools = "tsm,nvda,asml,qcom,avgo,txn,amd,mu,amat,lrcx,nxpi";

    //电商
    public static String netStockPools = "amzn,baba,jd,pdd,shop,se,ebay,meli,wish,etsy,rvlv";

    // 流媒体
    public static String mediachinesePools = "nflx,dis,roku,fubo";

    //社交股
    public static String socialchinesePools = "fb,snap,pins,twtr";

    //比特币概念
    public static String btcchinesePools = "pypl,sq,coin";


    //中概股
    public static String chipchinesePools = "bidu,futu,bili";


    //传统股票
    public static String traditionalchinesePools = "ba,spg,wynn";


    static StringBuilder stringBuilder = new StringBuilder();

    public static String totalPools = stringBuilder
            .append(fundstockPools).append(",")
            .append(growingstockPools).append(",")
            .append(energystockPools).append(",")
            .append(chipStockPools).append(",")
            .append(netStockPools).append(",")
            .append(mediachinesePools).append(",")
            .append(socialchinesePools).append(",")
            .append(btcchinesePools).append(",")
            .append(traditionalchinesePools).append(",")
            .toString();

    public static TreeMap<String, String> Init() {
        TreeMap<String, String> map = new TreeMap<>();
        //基金
        map.put("arkk", "ARKK基金");
        map.put("spy", "标普基金");
        map.put("uvxy", "恐慌指数");
        map.put("gbtc", "比特币基金");

        //科技巨头
        map.put("aapl", "苹果");
        map.put("goog", "谷歌");
        map.put("fb", "Facebook");
        map.put("amzn", "亚马逊");
        map.put("msft", "微软");

        //新能源
        map.put("tsla", "特斯拉");
        map.put("nio", "蔚来");
        map.put("xpev", "小鹏");
        map.put("li", "理想");


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
        map.put("etsy", "Rvlv");

        //流媒体
        map.put("nflx", "奈飞");
        map.put("dis", "迪士尼");
        map.put("roku", "Roku");
        map.put("fubo", "Fubo");

        //社交股
        map.put("fb", "Facebook");
        map.put("snap", "Snapchat");
        map.put("pins", "Pinterest");
        map.put("twtr", "推特");


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
        map.put("nxpi", "恩智浦");

        //中概股
        map.put("bidu", "百度");
        map.put("futu", "富途");
        map.put("bili", "B站");

        //数字货币（比特币概念）
        map.put("sq", "Square");
        map.put("pypl", "PayPal");
        map.put("coin", "coinbase");

        //传统股票
        map.put("ba", "波音");
        map.put("spg", "西蒙地产");
        map.put("wynn", "永利度假村");
        map.put("cost", "好市多");

        return map;
    }



    public static void main(String[] args) throws Exception {
        //初始化
        TreeMap<String, String> map = Init();



        System.out.println("股票池");

        System.out.println("基金:");
        List<String> collect0 = Arrays.asList(fundstockPools.split(",")).stream().map(a -> map.get(a)).collect(Collectors.toList());
        System.out.println(String.join(",", collect0));

        System.out.println("科技巨头:");
        List<String> collect = Arrays.asList(growingstockPools.split(",")).stream().map(a -> map.get(a)).collect(Collectors.toList());
        System.out.println(String.join(",", collect));

        System.out.println("新能源汽车:");
        List<String> collect1 = Arrays.asList(energystockPools.split(",")).stream().map(a -> map.get(a)).collect(Collectors.toList());
        System.out.println(String.join(",", collect1));

        System.out.println("芯片股:");
        List<String> collect2 = Arrays.asList(chipStockPools.split(",")).stream().map(a -> map.get(a)).collect(Collectors.toList());
        System.out.println(String.join(",", collect2));

        System.out.println("电商:");
        List<String> collect3 = Arrays.asList(netStockPools.split(",")).stream().map(a -> map.get(a)).collect(Collectors.toList());
        System.out.println(String.join(",", collect3));

        System.out.println("流媒体:");
        List<String> collect4 = Arrays.asList(mediachinesePools.split(",")).stream().map(a -> map.get(a)).collect(Collectors.toList());
        System.out.println(String.join(",", collect4));

        System.out.println("社交广告:");
        List<String> collect5 = Arrays.asList(socialchinesePools.split(",")).stream().map(a -> map.get(a)).collect(Collectors.toList());
        System.out.println(String.join(",", collect5));

        System.out.println("数字货币:");
        List<String> collect7 = Arrays.asList(btcchinesePools.split(",")).stream().map(a -> map.get(a)).collect(Collectors.toList());
        System.out.println(String.join(",", collect7));


        System.out.println("中概股:");
        List<String> collect8 = Arrays.asList(chipchinesePools.split(",")).stream().map(a -> map.get(a)).collect(Collectors.toList());
        System.out.println(String.join(",", collect8));

        System.out.println("传统股票:");
        List<String> collect9 = Arrays.asList(traditionalchinesePools.split(",")).stream().map(a -> map.get(a)).collect(Collectors.toList());
        System.out.println(String.join(",", collect9));


        //处理期权异动
        traceOption(map);
    }

    //追踪期权
    public static void traceOption(TreeMap<String, String> map ) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date_from = simpleDateFormat.parse("2021-05-18");
        Date date_to = simpleDateFormat.parse("2021-05-19");


        List<CalculateStock> calculateStocks = new ArrayList<>();
        List<OptionRespList> optionRespLists = new ArrayList<>();

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
//                log.info("响应结果：{}", result);
                JSONObject jsonObject = JSON.parseObject(result);
                JSONArray jsonArray = (JSONArray) jsonObject.get("entities");
                List<OptionResp> optionRespList = JSON.parseArray(jsonArray.toJSONString(), OptionResp.class);


                if (CollectionUtils.isEmpty(optionRespList) || optionRespList.size() <= 3) {
                    return;
                }
                String symbol = optionRespList.get(0).getSymbol();
                System.out.println(map.get(symbol.toLowerCase()) + "(" + symbol.toUpperCase() + ")" + "期权异动捕获:");

                CalculateStock calculateStock = new CalculateStock();
                calculateStock.setTotal(optionRespLists.size());
                calculateStock.setSymbol(symbol);
                calculateStock.setSymbolName(map.get(symbol.toLowerCase()));

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
                            optionResp1.setSize(amount + "");
                            String expiration = new SimpleDateFormat("yyyy-MM-dd").format(new Date(optionResp.getExpiration() * 1000L));
                            String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(optionResp.getReceived() * 1000L));
                            optionResp1.setExpiration(expiration);
                            optionResp1.setReceived(result1);
                            optionRespLists.add(optionResp1);

                            //只统计100w大单
                            if (Integer.parseInt(optionResp1.getSize()) > 100) {
                                String typeName;
                                if (optionResp.getType() == 1) {
                                    typeName = "看涨（call）";
                                } else {
                                    typeName = "看跌（put）";
                                }
                                System.out.println("在" + optionResp1.getReceived()
                                        + "以" + optionResp1.getStrike() + "买入" + optionResp1.getSymbol()
                                        + " " + optionResp1.getSize() + "w美元"
                                        + typeName + ",到期日：" + optionResp1.getExpiration());


                            }

                            //记录大于20w
                            if (Integer.parseInt(optionResp1.getSize()) > 20) {
                                if (optionResp.getType() == 1) {
                                    calculateStock.setCallCount(calculateStock.getCallCount() + 1);
                                } else {
                                    calculateStock.setPutCount(calculateStock.getPutCount() + 1);

                                }



                            }


                        });
                calculateStocks.add(calculateStock);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        StringBuilder stringBuilderCall = new StringBuilder();
        StringBuilder middle = new StringBuilder();
        StringBuilder stringBuilderput = new StringBuilder();

        calculateStocks.forEach(calculateStock1 -> {

            if (Math.abs(calculateStock1.getCallCount() - calculateStock1.getPutCount()) <= 1) {
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

        if (StringUtils.isNotBlank(stringBuilderCall)) {
            System.out.println("今日机构期权做多的股票：" + stringBuilderCall.toString());
        }
        if (StringUtils.isNotBlank(middle)) {
            System.out.println("今日期权多头和空头博弈的股票：" + middle.toString());
        }
        if (StringUtils.isNotBlank(stringBuilderput)) {
            System.out.println("今日机构期权做空的股票：" + stringBuilderput.toString());
        }
        System.out.println("更多有价值的信息，请关注公众号：美股发掘。我会定期跟踪股票池相关股票的期权异动，和大家一起交流学习，不作为投资意见。");
        System.out.println("");

        List<OptionRespList> respLists = optionRespLists.stream()
                .filter(a -> !a.isDesc())
                .filter(a -> Integer.parseInt(a.getSize()) > 20)
                .collect(Collectors.toList());
        OptionRespList respList = new OptionRespList();
        respList.setCompany("公司");
        respList.setSymbol("股票");
        respList.setType("类型");
        respList.setStrike("目标价");
        respList.setSize("交易额");
        respList.setExpiration("过期日");
        respList.setReceived("捕获时间");
        respList.setDesc(true);
        optionRespLists.add(respList);

        respLists.add(0,respList);
        StockimageUtils.dealData(respLists,20);


        List<OptionRespList> respLists1 = optionRespLists.stream()
                .filter(a -> !a.isDesc())
                .filter(a -> Integer.parseInt(a.getSize()) > 100)
                .collect(Collectors.toList());
        respLists1.add(0,respList);
        StockimageUtils.dealData(respLists1,100);

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
