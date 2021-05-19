package com.ningcs.track.stock.option;

import com.ningcs.track.stock.model.Content;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;
import java.util.*;

/**
 * @Auther: ningcs
 * @Date: 2021/04/19/13:55
 * @Description:读取QQ邮箱收件箱
 */

@Component
public class StockimageUtils {


    private static void createImage(String fileLocation, BufferedImage image) {
        try {
            ImageIO.write(image, "png", new File(fileLocation));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws NoSuchMethodException {
        List<Content> list = new ArrayList<Content>();

        Map<String, String> map = new HashMap<String, String>();

        map.put("title", "测试");
        Content content = new Content();
        content.setFund("名称");
        content.setDirection("名称");
        content.setTicker("名称");
        content.setShares("名称");
        content.setPercentage("名称");
        content.setClosePrice("收盘价");
        content.setAmount("总额(w)");
        content.setDesc(true);
        list.add(content);

        Content content1 = new Content();
        content1.setFund("ARKW");
        content1.setDirection("buy");
        content1.setTicker("名称");
        content1.setShares("123123");
        content1.setPercentage("0.53211");
        content.setClosePrice("123");
        content1.setAmount("22.22");
        content1.setDesc(false);
        list.add(content1);

        Content content2 = new Content();
        content2.setFund("ARKF");
        content2.setDirection("sell");
        content2.setTicker("名称");
        content2.setShares("123123");
        content2.setPercentage("0.233232");
        content.setClosePrice("123");
        content2.setAmount("22.22");
        content2.setDesc(false);
        list.add(content2);

        Content content3 = new Content();
        content3.setFund("ARKQ");
        content3.setDirection("sell");
        content3.setTicker("名称");
        content3.setShares("123123");
        content3.setPercentage("0.133232");
        content.setClosePrice("123");
        content3.setAmount("22.22");
        content3.setDesc(false);
        list.add(content3);

        Content content4 = new Content();
        content4.setFund("ARKQ");
        content4.setDirection("sell");
        content4.setTicker("名称");
        content4.setShares("123123");
        content4.setPercentage("0.0033");
        content4.setAmount("22.22");
        content4.setDesc(false);
        list.add(content4);

        Content content5 = new Content();
        content5.setFund("ARKQ");
        content5.setDirection("sell");
        content5.setTicker("名称");
        content5.setShares("123123");
        content5.setPercentage("0.233232");
        content5.setAmount("22.22");
        content5.setDesc(false);
        list.add(content5);
        Content content6 = new Content();
        content6.setFund("ARKQ");
        content6.setDirection("buy");
        content6.setTicker("名称");
        content6.setShares("123123");
        content6.setPercentage("0.333232");
        content6.setAmount("22.22");
        content6.setDesc(false);
        list.add(content6);

        Content content7 = new Content();
        content7.setFund("ARKQ");
        content7.setDirection("sell");
        content7.setTicker("名称");
        content7.setShares("123123");
        content7.setPercentage("0.133232");
        content7.setAmount("22.22");
        content7.setDesc(false);
        list.add(content7);

        Content content8 = new Content();
        content8.setFund("ARKQ");
        content8.setDirection("sell");
        content8.setTicker("名称");
        content8.setShares("123123");

        content8.setPercentage("0.133232");
        content8.setAmount("22.22");
        content8.setDesc(false);
        list.add(content8);

        Content content9 = new Content();
        content9.setFund("ARKQ");
        content9.setDirection("sell");
        content9.setTicker("名称");
        content9.setShares("123123");
        content9.setPercentage("0.133232");
        content9.setAmount("22.22");
        content9.setDesc(false);
        list.add(content9);
        Content content10 = new Content();
        content10.setFund("ARKQ");
        content10.setDirection("sell");
        content10.setTicker("名称");
        content10.setShares("123123");
        content10.setPercentage("0.133232");
        content10.setAmount("22.22");
        content10.setDesc(false);
        list.add(content10);

//        System.out.println("ARK基金"+LocalDate.now() +"持仓变化：");
//        for (Content content21 :list){
//            if (content1.getPercentage().compareTo("0.1") >= 0){
//                String operate="";
//                if (content1.getDirection().toLowerCase().equals("buy")){
//                    operate="买入";
//                }else {
//                    operate="卖出";
//                }
//                String message=content1.getFund()+operate+content1.getTicker()+":"+
//                        BigDecimal.valueOf(Integer.parseInt(content1.getShares())).divide(new BigDecimal(10000)).setScale(2,BigDecimal.ROUND_HALF_UP)
//                        +"w股"+",基金仓位占比:"+
//                        BigDecimal.valueOf(Double.parseDouble(content1.getPercentage())).setScale(2,BigDecimal.ROUND_HALF_UP)
//                        +"%;";
//                System.out.println(message);
//            }
//
//        }
//        list.stream().collect(Collectors.groupingBy(Content::getFund, Collectors.mapping(a -> a, Collectors.toList())))
//                .forEach((k, v) -> {
//                    v.stream().collect(Collectors.groupingBy(Content::getDirection,
//                            Collectors.mapping(a -> a.getTicker(), Collectors.toList()))).forEach((a, b) -> {
//                        if (a.toLowerCase().equals("buy")) {
//                            System.out.println(k + "基金买入：" + String.join(",", b));
//                        } else {
//                            System.out.println(k + "基金卖出：" + String.join(",", b));
//                        }
//
//                    });
//                });

//        dealData(list);
    }

    public static void dealData(List<OptionRespList> list,Integer amount) {
        int imageWidth = 2000;// 图片的宽度

        int size = list.size();

        int imageHeight = 70*size;// 图片的高度

        BufferedImage image = new BufferedImage(imageWidth, imageHeight,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, imageWidth, imageHeight);
        graphics.setColor(Color.black);

        //消除文字锯齿
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //消除画图锯齿
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        int high = 100;
        int wigth = 0;
        graphics.setFont(new Font("宋体", Font.BOLD, 50));
        graphics.drawString("期权异常跟踪(" + LocalDate.now().plusDays(-1) + ")", 600, high);
        graphics.setFont(new Font("宋体", Font.PLAIN, 30));
        graphics.setColor(new Color(255, 28, 26));
        graphics.drawString("注：统计交易金额大于"+amount+"万美元", 1350, high);
        graphics.setFont(new Font("宋体", Font.BOLD, 30));
        graphics.setColor(Color.black);
        high += 20;
        graphics.drawLine(50, high, 1750, high);
        high += 20;

        for (OptionRespList optionResp : list) {
            Field[] fields = optionResp.getClass().getDeclaredFields();
            high += 60;
            wigth = 120;

            for (Field field : fields) {
                String name = field.getName();
                if (name.equals("desc")) {
                    continue;
                }
                String method = name.substring(0, 1).toUpperCase() + name.substring(1);// 将属性首字符大写，方便get & set 方法

                try {
                    Method setmethod = optionResp.getClass().getMethod("get" + method);// 获取 get 方法
                    String value = (String) setmethod.invoke(optionResp);// 通过 get 获取值
                    if (optionResp.isDesc()) {

                        graphics.setFont(new Font("黑体", Font.BOLD, 50));
                        graphics.drawString(value, wigth, high);
                        graphics.setFont(new Font("宋体", Font.BOLD, 30));
                    } else {
                        graphics.setFont(new Font("宋体", Font.BOLD, 30));
                        //设置买入为绿色，卖出为红色
                        if (name.toLowerCase().equals("type")) {
                            if (optionResp.getType().toLowerCase().equals("call")) {
                                graphics.setColor(new Color(39,139,34));
                            } else {
                                graphics.setColor(new Color(255, 28, 26));
                            }
                        } else {
                            graphics.setColor(Color.black);
                        }
                        if (name.toLowerCase().equals("size")) {
                            value=value+"w";
                        }
                        graphics.drawString(value, wigth, high);
                    }
                    wigth += 220;

//                    System.out.println(value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        graphics.setColor(Color.black);
        high += 30;
        graphics.drawLine(50, high, 1550, high);

        high+=50;
        graphics.setColor(new Color(255, 28, 26));
        graphics.setFont(new Font("宋体", Font.BOLD, 30));
        graphics.drawString("注：以上数据出自公众号：美股发掘，转载请标明出处", 100, high);
        high+=50;
        graphics.drawString("注：关注公众号：美股发掘,和我一起发掘美股成长股", 100, high);
        high+=50;
        graphics.drawString("注：以上数据仅提供交流学习，不作为投资意见", 100, high);

        createImage("D:\\image\\trace\\"+LocalDate.now().plusDays(-1)+"-"+amount+".png", image);

    }

    /**
     * 随机获得6位小数
     *
     * @param number
     * @return
     */
    private static String getRandom(int number) {
        Random random = new Random();
        String result = "";
        for (
                int i = 0;
                i < 6; i++) {
            result += random.nextInt(number);
        }
        System.out.println(result);
        return result;
    }
}
