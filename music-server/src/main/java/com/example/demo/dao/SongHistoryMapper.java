package com.example.demo.dao;

import com.example.demo.domain.SongHistory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface SongHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SongHistory record);

    int insertSelective(SongHistory record);

    SongHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SongHistory record);

    int updateByPrimaryKey(SongHistory record);

    @Select("select * from song_history where userid=#{userId} and songid=#{songId}")
    SongHistory selectSongHistoryOfUser(@Param("userId") String userId, @Param("songId") String songId);
}