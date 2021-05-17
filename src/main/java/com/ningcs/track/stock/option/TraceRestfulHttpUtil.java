package com.ningcs.track.stock.option;

import com.ningcs.track.stock.util.RestfulHttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Auther: ningcs
 * @Date: 2021/05/10/19:16
 * @Description:
 */
public class TraceRestfulHttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(RestfulHttpUtil.class);


    public static String token ="eyJ1aWQiOjM5ODUsInNhbHQiOiIwLjg4NTA4MjQzMDEzMzU0MTYiLCJleHBpcmVzIjoxNjIzNTcwNTMyLjE4ODE1Njh9G9MJ8TJvqPoTVlMJu_3xcg==";

    /**
     * 向指定URL发起Get请求，参数为params
     *
     * @param url
     * @param params
     * @return
     */
    public static String sendGet(String url) throws Exception, IOException {
        StringBuffer result = new StringBuffer();// 查询结果
        BufferedReader in = null;
        OutputStreamWriter out = null;
        try {
//            String paramsString = handleParams(params);//处理参数为字符串
//            System.out.println("***************请求参数*******************");
//            System.out.println("param:" + url);
//            System.out.println("***************请求参数*******************");
            HttpURLConnection conn = getConnObject(url, "GET"); //根据请求方式和url获得相应的conn对象
            if (conn == null) {
                logger.error("url处理异常！");
                return "";
            }

            // 获取URLConnection对象对应的输出流
            /*out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // flush输出流的缓冲
            out.flush();*/
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            logger.error(url + "响应异常", e);
        } catch (Exception e) {
            logger.error("GET请求错误！", e);
        } finally { //使用finally块来关闭输出流、输入流
            try {
                /*if(out!=null){
                    out.close();
                }*/
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                logger.error("服务器异常", ex);
            }
        }
        return result.toString();
    }

    /**
     * 向指定URL发起post请求，参数为params
     *
     * @param url
     * @param params
     * @return
     */
    public static String sendPost(String url, Map<String, String> params) {
        return "";
    }

    /**
     * 根据请求方式和url获得相应的conn对象
     *
     * @param url
     * @param method
     * @return
     */
    private static HttpURLConnection getConnObject(String url, String method) {
        HttpURLConnection conn = null;
        URL realUrl = null;

        try {
            realUrl = new URL(url);
            conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestMethod("GET");

//            // 设置通用的请求属性
            conn.setRequestProperty("Authorization", token);
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //设置连接超时和读取超时
            conn.setConnectTimeout(60000);
            conn.setReadTimeout(60000);
            conn.connect();

            //conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        } catch (MalformedURLException e) {
            logger.error("无效url！", e);
        } catch (IOException e) {
            logger.error("url资源获取异常！", e);
        } catch (Exception e) {
            logger.error("不能处理的请求方式！");
        }
        return conn;
    }

    /**
     * Handle request params
     *
     * @param params
     * @return
     */
    private static String handleParams(TreeMap<String, String> params) {
        // 发送请求参数
        if (params != null) {
            StringBuilder param = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (param.length() > 0) {
                    param.append("&");
                }
                param.append(entry.getKey());
                param.append("=");
                param.append(entry.getValue());
            }
            return param.toString();
        } else {
            return "";
        }
    }

}