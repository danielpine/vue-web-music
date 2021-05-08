package com.example.demo.service;

import com.example.demo.bo.Result;
import com.example.demo.dao.CollectMapper;
import com.example.demo.dao.SongHistoryMapper;
import com.example.demo.domain.Collect;
import com.example.demo.domain.SongHistory;
import com.example.demo.service.CollectService;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class SongHistoryService {
    @Autowired
    private SongHistoryMapper songHistoryMapper;

    public Result updateHistory(String userId, String songId) {
        SongHistory songHistory = songHistoryMapper.selectSongHistoryOfUser(userId, songId);
        if (Objects.nonNull(songHistory)) {
            songHistory.setCount(songHistory.getCount() + 1);
            songHistory.setLastplaytime(new Date());
            int res = songHistoryMapper.updateByPrimaryKey(songHistory);
            return ResultUtil.msg(res, "更新成功", songHistory);
        } else {
            songHistory = new SongHistory();
            songHistory.setCount(1);
            songHistory.setSongid(Integer.valueOf(songId));
            songHistory.setUserid(Integer.valueOf(userId));
            songHistory.setLastplaytime(new Date());
            int res = songHistoryMapper.insert(songHistory);
            return ResultUtil.msg(res, "添加成功", songHistory);
        }

    }
}
