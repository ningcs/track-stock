package com.ningcs.track.stock.reptile;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @Auther: ningcs
 * @Date: 2021/05/26/11:04
 * @Description:
 */
public class Reptile {

    public static void main(String[] args) {
        test();
    }

    public static void  test()  {
        //通过httpclient，设置参数，代理，建立连接，获取HTML文档（响应信息）
        String requestUrl = "https://www.cnblogs.com/longronglang/";
        HttpClient client = new HttpClient();
        HttpClientParams clientParams = client.getParams();
        clientParams.setContentCharset("UTF-8");
        GetMethod method = new GetMethod(requestUrl);
        String response = null;
        int code = 0;
        try {
            code = client.executeMethod(method);
            response = method.getResponseBodyAsString();
            if (code == HttpStatus.SC_OK) {
                //将获取的响应信息，转换成HTML文档为Document对象
                Document document = Jsoup.parse(response);
                Elements postItems = document.getElementsByClass("postTitle2");
                Elements readcontexts = document.getElementsByClass("postDesc");
                Elements readcontexts1 = document.getElementsByClass("postCon");
                for (int i = 0; i < postItems.size(); i++) {
                    System.out.println("文章标题:" + postItems.get(i).text());
                    System.out.println("文章地址:" + postItems.get(i).attr("href"));
                    System.out.println("文章摘要:" + readcontexts1.get(i).text());
                    System.out.println("发布信息:" + readcontexts.get(i).text());
                }
            } else {
                System.out.println("返回状态不是200,可能需要登录或者授权，亦或者重定向了！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
