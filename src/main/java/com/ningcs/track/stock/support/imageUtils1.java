package com.ningcs.track.stock.support;//package com.fj.fimail.support;
//
//import com.fj.fimail.model.Content;
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;
//import org.springframework.stereotype.Component;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.BufferedOutputStream;
//import java.io.FileOutputStream;
//import java.util.List;
//import java.util.*;
//
///**
// * @Auther: ningcs
// * @Date: 2021/04/19/13:55
// * @Description:读取QQ邮箱收件箱
// */
//
//@Component
//public class imageUtils1 {
//
//
//    private static void createImage(String fileLocation, BufferedImage image) {
//        try {
//            FileOutputStream fos = new FileOutputStream(fileLocation);
//            BufferedOutputStream bos = new BufferedOutputStream(fos);
//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
//            encoder.encode(image);
//            bos.close();
//            fos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    //
//    // public static void graphicsGeneration(String path, PolicyBean policyBean)
//    // {
//    //
//    // int imageWidth = 1000;// 图片的宽度
//    //
//    // int imageHeight = 1000;// 图片的高度
//    //
//    // BufferedImage image = new BufferedImage(imageWidth, imageHeight,
//    // BufferedImage.TYPE_INT_RGB);
//    // Graphics graphics = image.getGraphics();
//    // graphics.setColor(Color.white);
//    // graphics.fillRect(0, 0, imageWidth, imageHeight);
//    // graphics.setColor(Color.ORANGE);
//    // graphics.setFont(new Font("宋体", Font.BOLD, 20));
//    //
//    // // PolicyPersonDto policyPersonDto = policyBean.getPolicyPersonDto();
//    // // PolicyProductDto policyProductDto = policyBean.getPolicyProductDto();
//    //
//    // int num = 50;
//    // graphics.drawString("手机号      : " + policyPersonDto.getMobile(), 50,
//    // num);
//    // num += 50;
//    // graphics.drawString("登陆密码    : " + policyPersonDto.getPassword(), 50,
//    // num);
//    // num += 50;
//    // graphics.drawString("身份证号    : " + policyPersonDto.getIdentityCard(), 50,
//    // num);
//    // num += 50;
//    // graphics.drawString("姓名        : " + policyPersonDto.getUserName(), 50,
//    // num);
//    // num += 50;
//    // graphics.drawString("所在地区    : " + policyPersonDto.getArea(), 50, num);
//    // num += 50;
//    // graphics.drawString("常住地址    : " + policyPersonDto.getAddress(), 50,
//    // num);
//    // num += 50;
//    // graphics.drawString("微信号      : " + policyPersonDto.getWechatNo(), 50,
//    // num);
//    // num += 50;
//    // graphics.drawString("QQ号        : " + policyPersonDto.getQq(), 50, num);
//    // num += 50;
//    // graphics.drawString("Email       : " + policyPersonDto.getEmail(), 50,
//    // num);
//    // num += 50;
//    // graphics.drawString("品牌        : " + policyProductDto.getBrand(), 50,
//    // num);
//    // num += 50;
//    // graphics.drawString("型号        : " + policyProductDto.getModel(), 50,
//    // num);
//    // num += 50;
//    // graphics.drawString("商品编号    : " + policyProductDto.getProductId(), 50,
//    // num);
//    // num += 50;
//    // graphics.drawString("购买日期    : " + policyProductDto.getPurchaseDate(),
//    // 50, num);
//    // num += 50;
//    // graphics.drawString("购买价格    : " + policyProductDto.getPurchasePrice(),
//    // 50, num);
//    // num += 50;
//    // graphics.drawString("购买途径    : " + policyProductDto.getPurchaseWay(), 50,
//    // num);
//    // num += 50;
//    // graphics.drawString("报修电话    : " + policyProductDto.getWarrantyPhone(),
//    // 50, num);
//    // num += 50;
//    // graphics.drawString("延保单位    : " +
//    // policyProductDto.getExtendedWarrantyUnit(), 50, num);
//    // num += 50;
//    // graphics.drawString("延保电话    : " +
//    // policyProductDto.getExtendedWarrantyPhone(), 50, num);
//    // num += 50;
//    // graphics.drawString("发票编号    : " + policyProductDto.getInvoiceNo(), 50,
//    // num);
//    //
//    // createImage(path, image);
//    // }
//
//    public static void main(String[] args) {
//        List<Content> list = new ArrayList<Content>();
//
//        Map<String, String> map = new HashMap<String, String>();
//
//        map.put("title","测试");
//        Content content = new Content();
//        content.setFund("名称");
//        content.setDate(new Date());
//        content.setDirection("名称");
//        content.setTicker("名称");
//        content.setCusip("名称");
//        content.setCompany("名称");
//        content.setShares("名称");
//        content.setPercentage("名称");
//        content.setTitle(true);
//        list.add(content);
//
//        Content content = new Content();
//        content.setFund("名称");
//        content.setDate(new Date());
//        content.setDirection("名称");
//        content.setTicker("名称");
//        content.setCusip("名称");
//        content.setCompany("名称");
//        content.setShares("名称");
//        content.setPercentage("名称");
//        content.setTitle(true);
//        list.add(content);
//
//        Content content2 = new Content();
//        content2.setFund("名称");
//        content2.setDate(new Date());
//        content2.setDirection("名称");
//        content2.setTicker("名称");
//        content2.setCusip("名称");
//        content2.setCompany("名称");
//        content2.setShares("名称");
//        content2.setPercentage("名称");
//        content2.setTitle(true);
//        list.add(content2);
//
//        mapTitle1.put()
//        int imageWidth = 1200;// 图片的宽度
//
//        int imageHeight = 1000;// 图片的高度
//
//        BufferedImage image = new BufferedImage(imageWidth, imageHeight,
//                BufferedImage.TYPE_INT_RGB);
//        Graphics graphics = image.getGraphics();
//        graphics.setColor(Color.red);
//        graphics.fillRect(0, 0, imageWidth, imageHeight);
//        graphics.setColor(Color.black);
//
//        int high = 100;
//        int wigth = 0;
//        graphics.setFont(new Font("宋体", Font.BOLD, 50));
//        graphics.drawString("注册保单", 500, high);
//        graphics.setFont(new Font("宋体", Font.BOLD, 20));
//        high += 10;
//        graphics.drawLine(50, high, 1150, high);
//
//        for (Map<String, String> rowMap : list) {
//            high += 50;
//            wigth = 50;
//            for (Map.Entry<String, String> entry : rowMap.entrySet()) {
//                String name = entry.getKey() + "：" + entry.getValue();
//                if ("title".equals(entry.getKey())) {
//                    high += 50;
//                    graphics.setFont(new Font("黑体", Font.BOLD, 30));
//                    graphics.drawString(entry.getValue(), wigth, high);
//                    graphics.setFont(new Font("宋体", Font.BOLD, 20));
//                } else {
//                    graphics.drawString(name, wigth, high);
//                    wigth += 400;
//                }
//
//            }
//        }
//
//        createImage("D:\\image\\11.jpg", image);
//
//    }
//
//}
