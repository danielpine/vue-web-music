package com.example.demo.service.impl;

import com.example.demo.dao.RankMapper;
import com.example.demo.domain.Rank;
import com.example.demo.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl implements RankService {

    @Autowired
    private RankMapper rankMapper;

    @Override
    public int rankOfSongListId(Long songListId) {
        return rankMapper.selectScoreSum(songListId) / rankMapper.selectRankNum(songListId);
    }

    @Override
    public boolean addRank(Rank rank) {
        return rankMapper.insertSelective(rank) > 0 ? true : false;
    }

    @Override
    public Rank selectSonglistRankOfTheConsumer(Long songListId, Long consumerId) {
        return rankMapper.selectSonglistRankOfTheConsumer(songListId, consumerId);
    }

    @Override
    public int updateSonglistRankOfTheConsumer(Long songListId, Long consumerId, Integer score) {
        return rankMapper.updateSonglistRankOfTheConsumer(songListId, consumerId, score);
    }
}
