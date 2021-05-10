package com.example.demo.dao;

import com.example.demo.domain.Rank;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface RankMapper {

    int insert(Rank record);

    int insertSelective(Rank record);

    /**
     * 查总分
     *
     * @param songListId
     * @return
     */
    int selectScoreSum(Long songListId);

    /**
     * 查总评分人数
     *
     * @param songListId
     * @return
     */
    int selectRankNum(Long songListId);

    @Select("select * from rank where songListId=#{songListId} and consumerId=#{consumerId}")
    Rank selectSonglistRankOfTheConsumer(@Param("songListId") Long songListId, @Param("consumerId") Long consumerId);

    @Update("update rank set score=#{score} where songListId=#{songListId} and consumerId=#{consumerId}")
    int updateSonglistRankOfTheConsumer(@Param("songListId") Long songListId, @Param("consumerId") Long consumerId, @Param("score") Integer score);
}
