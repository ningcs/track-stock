package com.ningcs.track.stock.job;

import com.ningcs.track.stock.constant.TrackTypeEnum;
import com.ningcs.track.stock.entity.Track;
import com.ningcs.track.stock.model.Content;
import com.ningcs.track.stock.service.TrackService;
import com.ningcs.track.stock.support.MailSupport;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @Auther: ningcs
 * @Date: 2021/05/25/17:52
 * @Description:
 */
@Slf4j
@Component
public class TrackARKJob {

    @Autowired
    private TrackService trackService;
    /*
     * 每天的7点,8点，9点执行
     */
//    @Scheduled(cron = "0 0 7,8,9 * * ?") //每天的7点,8点，9点执行
    @Scheduled(cron = "0 0/1 * * * ?") //每天的7点,8点，9点执行
    public void trackStockTask() {
        List<Content> contentList = MailSupport.trackStock();
        if (CollectionUtils.isEmpty(contentList)){
            log.info(LocalDate.now()+"当前无可执行数据.... ##### ");
        }
        createTrack(contentList);
    }
    public  void createTrack(List<Content> contents) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        contents.stream().filter(a -> !a.getTicker().equals("股票"))
                .map(content -> {
                    Track track = new Track();
                    BeanUtils.copyProperties(content, track);
                    track.setAmount(new BigDecimal(content.getAmount()));
                    track.setDirection(TrackTypeEnum.getCode(content.getDirection().toLowerCase()));
                    track.setCloseprice(new BigDecimal(content.getClosePrice()));
                    try {
                        track.setTrackingtime(format.parse(content.getDate()));
                    } catch (ParseException e) {
                        log.error("Method:transform-trackingTime-error：{}", e.getMessage());
                    }
                    track.setCreatetime(new Date());
                    return track;
                }).forEach(track -> {
            trackService.createTrackStock(track);
        });
    }

}
