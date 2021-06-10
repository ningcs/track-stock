package com.ningcs.track.stock.mapper;

import com.ningcs.track.stock.entity.Track;
import com.ningcs.track.stock.example.TrackExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TrackMapper {
    long countByExample(TrackExample example);

    int deleteByExample(TrackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Track record);

    int insertSelective(Track record);

    List<Track> selectByExample(TrackExample example);

    Track selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Track record, @Param("example") TrackExample example);

    int updateByExample(@Param("record") Track record, @Param("example") TrackExample example);

    int updateByPrimaryKeySelective(Track record);

    int updateByPrimaryKey(Track record);
}