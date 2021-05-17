package com.ningcs.track.stock.support;

import org.springframework.http.HttpEntity;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: ningcs
 * @Date: 2021/04/25/12:15
 * @Description:
 */
public class test {

    public static void main(String[] args) {
//        String expiration = new SimpleDateFormat("yyyy-MM-dd").format(new Date(1640880000 *1000L ));
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i=0;i<10000000;i++){
            executorService.execute(()->{
                    System.out.println(generateTransId());
            });
        }
    }

    public static String getFormatTimestamp() {
        // 当前时间戳
        long timestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        //时间戳格式转换
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(timestamp*1000L);
    }



    /**
     * 生成tranId YYYYMMDDHHMMSS+毫秒(3) +6位随机数
     *
     * @return
     */
    public static String generateTransId() {

        String format = new SimpleDateFormat("ddHHmmssSSS").format(new Date());
        String transId = format + getRandom(8);
//        System.out.println("获取transId：{} ##### "+ transId);
        return transId;
    }

    /**
     * 随机获得6位小数
     *
     * @param number
     * @return
     */
    public static String getRandom(int number) {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++) {
            result += random.nextInt(number);
        }
        return result;
    }
}
