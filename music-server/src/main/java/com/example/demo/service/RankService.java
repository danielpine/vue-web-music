package com.example.demo.service;

import com.example.demo.domain.Rank;

public interface RankService {

    int rankOfSongListId(Long songListId);

    boolean addRank(Rank rank);

    Rank selectSonglistRankOfTheConsumer(Long songListId, Long consumerId);

    int updateSonglistRankOfTheConsumer(Long songListId, Long consumerId, Integer score);
}
