package com.ningcs.track.stock.job;

import com.ningcs.track.stock.support.MailSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @Auther: ningcs
 * @Date: 2021/05/25/17:52
 * @Description:
 */
@Slf4j
@Component
public class TrackARKJob {

    /*
     * 每天的7点,8点，9点执行
     */
    @Scheduled(cron = "0 0 7,8,9 * * ?") //每天的7点,8点，9点执行
    public void trackStockTask() {
        Integer count = MailSupport.trackStock();
        if (count>0){
            log.info(LocalDate.now()+"执行成功.... ##### ");
        }
    }
}
