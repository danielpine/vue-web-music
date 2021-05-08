package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bo.Result;
import com.example.demo.domain.Collect;
import com.example.demo.service.SongHistoryService;
import com.example.demo.service.impl.CollectServiceImpl;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@Controller
public class SongHistoryController {

    @Autowired
    private SongHistoryService songHistoryService;

    @ResponseBody
    @RequestMapping(value = "/history/update", method = RequestMethod.POST)
    public Result update(HttpServletRequest req) {
        String userId = req.getParameter("userId");
        String songId = req.getParameter("songId");
        return songHistoryService.updateHistory(userId, songId);
    }

}

