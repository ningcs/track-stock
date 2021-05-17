package com.ningcs.track.stock.support;

import com.ningcs.track.stock.model.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.MimeUtility;
import javax.mail.search.FlagTerm;
import java.io.*;
import java.security.Security;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Auther: ningcs
 * @Date: 2021/04/19/13:55
 * @Description:读取QQ邮箱收件箱
 */

@Component
public class mailSupport1 {

    public static void main(String[] args) {
        String html = "Latest Trades</h4><table border=\"0\" cellpadding=\"5\" cellspacing=\"0\" style=\"font-family: Arial; font-size:13px;\">\n" +
                "<tbody><tr bgcolor=\"#000\" style=\"color:#fff; background-color:#000\">\n" +
                "<td></td>\n" +
                "<td>Fund</td>\n" +
                "<td>Date</td>\n" +
                "<td>Direction</td>\n" +
                "<td>Ticker</td>\n" +
                "<td>CUSIP</td>\n" +
                "<td>Company</td>\n" +
                "<td align=\"right\">Shares</td>\n" +
                "<td>% of ETF</td>\n" +
                "</tr><tr style=\"background-color:#fff\"><td>1</td><td>ARKF</td><td>04/16/2021</td><td>Buy</td><td>COIN</td><td>19260Q107</td><td>COINBASE\n" +
                "GLOBAL INC</td><td align=\"right\">19,599</td><td align=\"right\">0.1473</td></tr><tr style=\"background-color:#EEE\"><td>2</td><td>ARKF</td><td>04/16/2021</td><td>Sell</td><td>SQ</td><td>852234103</td><td>SQUARE\n" +
                "INC</td><td align=\"right\">24,983</td><td align=\"right\">0.1471</td></tr><tr style=\"background-color:#fff\"><td>3</td><td>ARKG</td><td>04/16/2021</td><td>Buy</td><td>BLI</td><td>084310101</td><td>BERKELEY\n" +
                "LIGHTS INC</td><td align=\"right\">5,698</td><td align=\"right\">0.0028</td></tr><tr style=\"background-color:#EEE\"><td>4</td><td>ARKG</td><td>04/16/2021</td><td>Buy</td><td>MASS</td><td>65443P102</td><td>908\n" +
                "DEVICES INC</td><td align=\"right\">24,213</td><td align=\"right\">0.0129</td></tr><tr style=\"background-color:#fff\"><td>5</td><td>ARKG</td><td>04/16/2021</td><td>Sell</td><td>PHR</td><td>71944F106</td><td>PHREESIA\n" +
                "INC</td><td align=\"right\">13,392</td><td align=\"right\">0.0071</td></tr><tr style=\"background-color:#EEE\"><td>6</td><td>ARKG</td><td>04/16/2021</td><td>Sell</td><td>SYRS</td><td>87184Q107</td><td>SYROS\n" +
                "PHARMACEUTICALS INC</td><td align=\"right\">100</td><td align=\"right\">0.0000</td></tr><tr style=\"background-color:#fff\"><td>7</td><td>ARKK</td><td>04/16/2021</td><td>Buy</td><td>U</td><td>91332U101</td><td>UNITY\n" +
                "SOFTWARE INC</td><td align=\"right\">143,850</td><td align=\"right\">0.0572</td></tr><tr style=\"background-color:#EEE\"><td>8</td><td>ARKK</td><td>04/16/2021</td><td>Buy</td><td>EXAS</td><td>30063P105</td><td>EXACT\n" +
                "SCIENCES CORP</td><td align=\"right\">49,345</td><td align=\"right\">0.0254</td></tr><tr style=\"background-color:#fff\"><td>9</td><td>ARKK</td><td>04/16/2021</td><td>Buy</td><td>COIN</td><td>19260Q107</td><td>COINBASE\n" +
                "GLOBAL INC</td><td align=\"right\">112,539</td><td align=\"right\">0.1512</td></tr><tr style=\"background-color:#EEE\"><td>10</td><td>ARKK</td><td>04/16/2021</td><td>Buy</td><td>BEAM</td><td>07373V105</td><td>BEAM\n" +
                "THERAPEUTICS INC</td><td align=\"right\">52,791</td><td align=\"right\">0.0153</td></tr><tr style=\"background-color:#fff\"><td>11</td><td>ARKK</td><td>04/16/2021</td><td>Sell</td><td>TSLA</td><td>88160R101</td><td>TESLA\n" +
                "INC</td><td align=\"right\">86,715</td><td align=\"right\">0.2562</td></tr><tr style=\"background-color:#EEE\"><td>12</td><td>ARKQ</td><td>04/16/2021</td><td>Buy</td><td>IRDM</td><td>46269C102</td><td>IRIDIUM\n" +
                "COMMUNICATIONS INC</td><td align=\"right\">22,142</td><td align=\"right\">0.0266</td></tr><tr style=\"background-color:#fff\"><td>13</td><td>ARKQ</td><td>04/16/2021</td><td>Sell</td><td>AVAV</td><td>008073108</td><td>AEROVIRONMENT\n" +
                "INC</td><td align=\"right\">6,400</td><td align=\"right\">0.0204</td></tr><tr style=\"background-color:#EEE\"><td>14</td><td>ARKW</td><td>04/16/2021</td><td>Buy</td><td>COIN</td><td>19260Q107</td><td>COINBASE\n" +
                "GLOBAL INC</td><td align=\"right\">54,940</td><td align=\"right\">0.2525</td></tr><tr style=\"background-color:#fff\"><td>15</td><td>ARKW</td><td>04/16/2021</td><td>Buy</td><td>U</td><td>91332U101</td><td>UNITY\n" +
                "SOFTWARE INC</td><td align=\"right\">81,999</td><td align=\"right\">0.1170</td></tr><tr style=\"background-color:#EEE\"><td>16</td><td>ARKW</td><td>04/16/2021</td><td>Sell</td><td>SNPS</td><td>871607107</td><td>SYNOPSYS\n" +
                "INC</td><td align=\"right\">11,600</td><td align=\"right\">0.0428</td></tr><tr style=\"background-color:#fff\"><td>17</td><td>ARKW</td><td>04/16/2021</td><td>Sell</td><td>TSLA</td><td>88160R101</td><td>TESLA\n" +
                "INC</td><td align=\"right\">47,826</td><td align=\"right\">0.5008</td></tr></tbody></table>";
        Document doc = Jsoup. parse ( html );
        Elements rows = doc . select ( "table" ). get ( 0 ). select ( "tr" );

        if ( rows . size () == 1 ) {
            System . out . println ( "没有结果" );
        } else {
            for ( int i = 1 ; i < rows . size (); i ++) {
                System . out . println ( "------------------------------------------- ----------------------" );
                Element row = rows . get ( i );
                new Content();
                System . out . println ( "row:" + row . select ( "td" ). get (0). text ());
                System . out . println ( "Fund:" + row . select ( "td" ). get (1). text ());
                System . out . println ( "Date:" + row . select ( "td" ). get ( 2 ). text ());
                System . out . println ( "Direction:" + row . select ( "td" ). get ( 3 ). text ());
                System . out . println ( "Ticker:" + row . select ( "td" ). get ( 4 ). text ());
                System . out . println ( "CUSIP:" + row . select ( "td" ). get ( 5 ). text ());
                System . out . println ( "Company:" + row . select ( "td" ). get ( 6 ). text ());
                System . out . println ( "Shares" + row . select ( "td" ). get ( 7 ). text ());
                System . out . println ( " % of ETF:" + row . select ( "td" ). get (8 ). text ());
                System . out . println ( "------------------------------------------- ----------------------" );
            }
        }
    }

}
