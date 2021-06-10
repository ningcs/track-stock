package com.ningcs.track.stock.controller;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ningcs.track.stock.entity.Track;
import com.ningcs.track.stock.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ningcs
 * @Date: 2021/06/09/10:09
 * @Description:
 */
@RestController
public class TrackController {

    @Autowired
    private TrackService trackService;

    @PostMapping(value = "/create")
    public void createTrack()throws Exception{
        Track track = new Track();
        track.setId(0);
        track.setFund("1");
        track.setDirection(0);
        track.setTicker("1");
        track.setShares("1");
        track.setPercentage("1");
        track.setCloseprice(new BigDecimal("0"));
        track.setAmount(new BigDecimal("0"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        track.setTrackingtime(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
        track.setCreatetime(new Date());
        trackService.createTrackStock(track);
    }

    public static void main(String[] args)throws  Exception {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date ="09/12/2021";
        System.out.println(format1.format(format.parse(date)));


    }
}
