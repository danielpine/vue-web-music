package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.RecommendMapper;
import com.example.demo.domain.SongList;
import com.example.demo.pojo.SongTag;

@Service
public class RecommendService {
	@Autowired
	private RecommendMapper recommendMapper;
	@Autowired
	private SongListService songListService;

	private static int recommendCount = 20;

	public List<SongList> recommend(Integer userId) {
		ArrayList<SongTag> userTagList = new ArrayList<>();
		List<SongTag> userCollectTags = recommendMapper.getUserCollect(userId);
		List<SongTag> userHistoryTags = recommendMapper.getUserHistory(userId);
		userTagList.addAll(userCollectTags);
		userTagList.addAll(userHistoryTags);
		System.out.println(userTagList);
		if (!userTagList.isEmpty()) {
			Map<String, Integer> map = userTagList.stream().collect(
			        Collectors.toMap(SongTag::getTag, SongTag::getScore, (a, b) -> a + b));
			System.out.println(JSONObject.toJSONString(map, true));
			Integer sum = map.values().stream().reduce(Integer::sum).orElse(0);
			System.out.println(sum);
			ArrayList<SongList> recommendSongList = new ArrayList<>();
			map.forEach((style, score) -> {
				Integer limit = (int) Math.ceil(((((float) score) / sum) * recommendCount));
				System.out.println(limit);
				List<SongList> list = recommendMapper.getLimitSongListByStlye(style, limit);
				recommendSongList.addAll(list);
			});
			return recommendSongList;
		} else {
			return songListService.allSongList().subList(0, 20);
		}
	}

}
