package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bo.Result;
import com.example.demo.service.SongHistoryService;

@RestController
@Controller
@RequestMapping(value = "/history")
public class SongHistoryController {

	@Autowired
	private SongHistoryService songHistoryService;

	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result<?> update(HttpServletRequest req) {
		String userId = req.getParameter("userId");
		String songId = req.getParameter("songId");
		return songHistoryService.updateHistory(userId, songId);
	}

}
