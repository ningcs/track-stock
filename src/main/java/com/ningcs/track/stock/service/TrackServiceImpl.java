package com.ningcs.track.stock.service;

import com.ningcs.track.stock.entity.Track;
import com.ningcs.track.stock.example.TrackExample;
import com.ningcs.track.stock.mapper.TrackMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Auther: ningcs
 * @Date: 2021/06/09/10:09
 * @Description:
 */
@Service
@Slf4j
public class TrackServiceImpl  implements TrackService{

    @Autowired
    private TrackMapper trackMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer createTrackStock(Track track) {
        Integer count =0;
        try {
            TrackExample trackExample = new TrackExample();
            trackExample.createCriteria().andFundEqualTo(track.getFund())
                    .andTickerEqualTo(track.getTicker())
                    .andTrackingtimeEqualTo(track.getTrackingtime());

            List<Track> tracks = trackMapper.selectByExample(trackExample);
            if (CollectionUtils.isNotEmpty(tracks)){
                return 0;
            }
            count=  trackMapper.insert(track);
        }catch (Exception e){
            log.error("Method:createTrackStock-ticker:{}-error:{}",track.getTicker());
        }
        return count;
    }
}
