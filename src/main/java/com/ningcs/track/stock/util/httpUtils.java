package com.ningcs.track.stock.util;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * @Auther: ningcs
 * @Date: 2021/05/08/17:27
 * @Description:
 */
@Slf4j
public class httpUtils {

    public static String doPost(String url, Map<String, Object> params) throws Exception {
        HttpURLConnection httpURLConnection = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            log.info("POST.request url: {}{}", url, JSON.toJSONString(params));
            URL u = new URL(url);
            httpURLConnection = (HttpURLConnection) u.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(60 * 1000);
            httpURLConnection.setReadTimeout(30 * 1000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);

            Object content = JSON.toJSON(params);
            httpURLConnection.connect();
            OutputStream out = httpURLConnection.getOutputStream();
            out.write(content.toString().getBytes());
            out.flush();
            out.close();

            int code = httpURLConnection.getResponseCode();
            log.info("POST.response url: {}, code: {}", url, code);
            if (code != 200) {
                log.info("error...........######");
            }
            reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            log.info("响应结果:{}", reader.toString());
            StringBuffer resp = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            log.info("POST.response url: {}, data: {}", url, resp.toString());
        } catch (IOException e) {
            log.error("POST.request failed!", e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                log.error("httpURLConnection|reader close error!", e);
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
        return stringBuilder.toString();
    }


}
