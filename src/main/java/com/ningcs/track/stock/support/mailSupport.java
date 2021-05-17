package com.ningcs.track.stock.support;

import com.ningcs.track.stock.model.Content;
import org.jsoup.Jsoup;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.Security;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeUtility;
import javax.mail.search.FlagTerm;

/**
 * @Auther: ningcs
 * @Date: 2021/04/19/13:55
 * @Description:读取QQ邮箱收件箱
 */

@Component
public class mailSupport {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";// ssl加密,jdk1.8无法使用

        // 定义连接imap服务器的属性信息
        String port = "993";
        String imapServer = "imap.qq.com";
        String protocol = "imap";
        String username = "923507613@qq.com";
        String password = "xlyqcgqgcrowbeej"; // QQ邮箱的授权码

        // 有些参数可能不需要
        Properties props = new Properties();
        props.setProperty("mail.imap.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.imap.socketFactory.fallback", "false");
        props.setProperty("mail.transport.protocol", protocol); // 使用的协议
        props.setProperty("mail.imap.port", port);
        props.setProperty("mail.imap.socketFactory.port", port);

        // 获取连接
        Session session = Session.getDefaultInstance(props);
        session.setDebug(false);

        // 获取Store对象
        Store store;
        try {
            store = session.getStore(protocol);
            store.connect(imapServer, username, password); // 登陆认证

            // 通过imap协议获得Store对象调用这个方法时，邮件夹名称只能指定为"INBOX"
            Folder folder = store.getFolder("INBOX");// 获得用户的邮件帐户
            folder.open(Folder.READ_WRITE); // 设置对邮件帐户的访问权限

            int n = folder.getUnreadMessageCount();// 得到未读数量
            System.out.println("未读邮件+" + n);

            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false); // false代表未读，true代表已读
            Message messages[] = folder.search(ft);
            for (Message message : messages) {
                String subject = message.getSubject();// 获得邮件主题
                System.out.println("邮件标题：" + subject);
                if (!subject.contains("ARK")) {
                    message.setFlag(Flags.Flag.SEEN, true); // imap读取后邮件状态会变为已读,设为未读
                    continue;
                }
                Address from = (Address) message.getFrom()[0];// 获得发送者地址
                System.out.println("邮件的主题为: " + subject);
//                try {
//                    System.out.println("发件人地址为: " + decodeText(from.toString()));
//                } catch (UnsupportedEncodingException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
                System.out.println("日期:" + message.getSentDate());

                try {
//                  parseMultipart((Multipart) message.getContent());
                    Object content = message.getContent();
                    if (content instanceof String) {
                        String body = (String) content;

                        System.out.println("正文：" + body);
                    } else if (content instanceof Multipart) {
                        Multipart mp = (Multipart) content;
                        System.out.println("正文：" + mp.getBodyPart(0).getContent());
                        //处理特殊邮件
                        parseMultipart(mp);
                    }
                    //System.out.println("正文:" + bp.getContent());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

            folder.close(false);// 关闭邮件夹对象
            store.close(); // 关闭连接对象
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected static String decodeText(String text) throws UnsupportedEncodingException {
        if (text == null)
            return null;
        if (text.startsWith("=?GB") || text.startsWith("=?gb"))
            text = MimeUtility.decodeText(text);
        else
            text = new String(text.getBytes("ISO8859_1"));
        return text;
    }

    /**
     * 对复杂邮件的解析
     *
     * @param multipart
     * @throws MessagingException
     * @throws IOException
     */
    public static void parseMultipart(Multipart multipart) throws MessagingException, IOException {
        int count = multipart.getCount();
        System.out.println("couont =  " + count);
        for (int idx = 0; idx < count; idx++) {
            BodyPart bodyPart = multipart.getBodyPart(idx);
            System.out.println(bodyPart.getContentType());
            if (bodyPart.isMimeType("text/plain")) {
                System.out.println("plain................." + bodyPart.getContent());
            } else if (bodyPart.isMimeType("text/html")) {
                String content = (String) bodyPart.getContent();
                System.out.println("html..................." + content);
                parsingTable(content);
            } else if (bodyPart.isMimeType("multipart/*")) {
                Multipart mpart = (Multipart) bodyPart.getContent();
                parseMultipart(mpart);

            } else if (bodyPart.isMimeType("application/octet-stream")) {
                String disposition = bodyPart.getDisposition();
                System.out.println(disposition);
                if (disposition.equalsIgnoreCase(BodyPart.ATTACHMENT)) {
                    String fileName = bodyPart.getFileName();
                    InputStream is = bodyPart.getInputStream();
                    copy(is, new FileOutputStream("D:\\image\\" + fileName));
                }
            }
        }
    }

    /**
     * 文件拷贝，在用户进行附件下载的时候，可以把附件的InputStream传给用户进行下载
     *
     * @param is
     * @param os
     * @throws IOException
     */
    public static void copy(InputStream is, OutputStream os) throws IOException {
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = is.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }
        if (os != null) {
            os.close();

        }
        if (is != null) {
            is.close();
        }
    }

    private static void parsingTable(String table) {
        Document doc = Jsoup.parse(table);
        Elements rows = doc.select("table").get(0).select("tr");
        List<Content> contents = new ArrayList<>();
        Content content = new Content();
        content.setFund("基金");
        content.setDirection("买/卖");
        content.setTicker("股票");
        content.setShares("股数");
        content.setPercentage("仓位%");
        content.setClosePrice("收盘价");
        content.setAmount("买入总额");
        content.setDesc(true);
        contents.add(content);
        if (rows.size() == 1) {
            System.out.println("没有结果");
        } else {
            for (int i = 1; i < rows.size(); i++) {

//                System . out . println ( "------------------------------------------- ----------------------" );
                Element row = rows.get(i);
                String fund = row.select("td").get(1).text();
                String direction = row.select("td").get(3).text();
                String ticker = row.select("td").get(4).text();
//                String company = row.select("td").get(6).text();
                String shares = row.select("td").get(7).text();
                String percentage = row.select("td").get(8).text();

                Content content1 = new Content();
                content1.setFund(fund);
                content1.setDirection(direction);
                content1.setTicker(ticker);
                content1.setShares(shares);
                content1.setPercentage(percentage);
                content1.setDesc(false);
                contents.add(content1);

//                System . out . println ( "row:" + row . select ( "td" ). get (0). text ());
//                System . out . println ( "Fund:" + row . select ( "td" ). get (1). text ());
//                System . out . println ( "Date:" + row . select ( "td" ). get ( 2 ). text ());
//                System . out . println ( "Direction:" + row . select ( "td" ). get ( 3 ). text ());
//                System . out . println ( "Ticker:" + row . select ( "td" ). get ( 4 ). text ());
//                System . out . println ( "CUSIP:" + row . select ( "td" ). get ( 5 ). text ());
//                System . out . println ( "Company:" + row . select ( "td" ). get ( 6 ). text ());
//                System . out . println ( "Shares" + row . select ( "td" ). get ( 7 ). text ());
//                System . out . println ( " % of ETF:" + row . select ( "td" ). get (8 ). text ());
                System.out.println("------------------------------------------- ----------------------");
            }
        }

        Set<String> stockNames = contents.stream().filter(a->!a.getTicker().equals("股票"))
                .map(Content::getTicker).collect(Collectors.toSet());

        //获取股票收盘价
        Map<String, BigDecimal> stockMap = StockUtils.getStocks(stockNames);

        //增加收盘价
        contents.forEach(content1 -> {
            BigDecimal price = stockMap.get(content1.getTicker());
            if (price==null){
                return ;
            }
            content1.setClosePrice(price.toString());
            String count = content1.getShares().replaceAll(",", "");
            BigDecimal amount = price.multiply(new BigDecimal(count))
                    .divide(new BigDecimal(10000),0,BigDecimal.ROUND_HALF_UP);
            content1.setAmount(amount.toString()+"w");
        });

        //写入磁盘
        imageUtils.dealData(contents);


        System.out.println("ARK基金" + LocalDate.now().plusDays(-1) + "持仓变化：");
        System.out.println("摘要：");
        contents.stream().filter(a -> a.getPercentage().compareTo("0.2") >= 0)
                .collect(Collectors.groupingBy(Content::getDirection, Collectors.mapping(a -> a.getTicker(), Collectors.toList())))
                .forEach((k, v) -> {
                    if (k.toLowerCase().equals("buy")) {
                        System.out.println("ARK基金买入：" + String.join(",", v) + ";");
                    }
                    if (k.toLowerCase().equals("sell")) {
                        System.out.println("ARK基金卖出：" + String.join(",", v) + ";");
                    }

                });


        for (Content content1 : contents) {
            if (content1.isDesc()) {
                continue;
            }
            if (content1.getPercentage().compareTo("0.1") >= 0) {
                String operate = "";
                if (content1.getDirection().toLowerCase().equals("buy")) {
                    operate = "买入";
                } else {
                    operate = "卖出";
                }
                String message = content1.getFund() + operate + content1.getTicker() + ": " +
                        BigDecimal.valueOf(Integer.parseInt(content1.getShares().replaceAll(",", ""))).divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP)
                        + "w股" + ",价值"+content1.getAmount()+"美元,基金仓位占比: " +
                        BigDecimal.valueOf(Double.parseDouble(content1.getPercentage())).setScale(2, BigDecimal.ROUND_HALF_UP)
                        + "%;";
                System.out.println(message);
            }
        }
        System.out.println("以上只统计ARK相关基金持仓变化大于0.1%的调仓变化，ARK全部调仓变化如下图");


    }


}
