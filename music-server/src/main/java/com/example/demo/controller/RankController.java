package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Rank;
import com.example.demo.service.impl.RankServiceImpl;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RestController
@Controller
public class RankController {

    @Autowired
    private RankServiceImpl rankService;

    //    提交评分
    @ResponseBody
    @RequestMapping(value = "/rank/add", method = RequestMethod.POST)
    public Object addRank(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String songListId = req.getParameter("songListId").trim();
        String consumerId = req.getParameter("consumerId").trim();
        String score = req.getParameter("score").trim();
        Rank rank = rankService.selectSonglistRankOfTheConsumer(Long.valueOf(songListId), Long.valueOf(consumerId));
        if (Objects.nonNull(rank)) {
            int i = rankService.updateSonglistRankOfTheConsumer(Long.valueOf(songListId), Long.valueOf(songListId), Integer.valueOf(score));
            jsonObject.put("code", i);
            jsonObject.put("msg", i == 1 ? "评价成功" : "评价失败");
            return jsonObject;
        } else {
            rank = new Rank();
            rank.setSongListId(Long.parseLong(songListId));
            rank.setConsumerId(Long.parseLong(consumerId));
            rank.setScore(Integer.parseInt(score));
            boolean res = rankService.addRank(rank);
            if (res) {
                jsonObject.put("code", 1);
                jsonObject.put("msg", "评价成功");
                return jsonObject;
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "评价失败");
                return jsonObject;
            }
        }
    }

    @ResponseBody
    @RequestMapping(value = "/rank/get", method = RequestMethod.POST)
    public Object getRank(HttpServletRequest req) {
        String songListId = req.getParameter("songListId").trim();
        String consumerId = req.getParameter("consumerId").trim();
        Rank rank = rankService.selectSonglistRankOfTheConsumer(Long.valueOf(songListId), Long.valueOf(consumerId));
        if (Objects.nonNull(rank)) {
            return ResultUtil.success(rank.getScore(), "获取成功");
        } else {
            return ResultUtil.error("暂无评分");
        }
    }


    //    获取指定歌单的评分
    @RequestMapping(value = "/rank", method = RequestMethod.GET)
    public Object rankOfSongListId(HttpServletRequest req) {
        String songListId = req.getParameter("songListId");
        return rankService.rankOfSongListId(Long.parseLong(songListId));
    }
}
