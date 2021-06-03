package com.ningcs.track.stock.reptile;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @Auther: ningcs
 * @Date: 2021/05/26/14:36
 * @Description:
 */
public class NewsUtil {

    public static void main(String[] args) {
        test();
    }

    public static void  test()  {
        //通过httpclient，设置参数，代理，建立连接，获取HTML文档（响应信息）
        String requestUrl = "https://kuaixun.stcn.com/";
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
//                Elements elements = document.getElementsByTag("ul");
                Elements elements = document.getElementsByTag("news_list2");
                Elements elements1 = elements.select("ul");
                Elements elements2 = elements1.select("li");
                for (int i = 0; i < elements2.size(); i++) {
                    System.out.println("文章标题:" + elements2.get(i).text());
                    System.out.println("文章标题:" + elements2.get(i).attr("title"));
                    System.out.println("文章地址:" + elements2.get(i).attr("href"));
                }
            } else {
                System.out.println("返回状态不是200,可能需要登录或者授权，亦或者重定向了！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
