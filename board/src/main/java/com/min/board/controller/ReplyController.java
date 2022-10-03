package com.min.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.board.dao.ReplyDao;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	@Autowired
	ReplyDao replyDao;

	// 댓글 Create
	@RequestMapping("/create")
	public String create(@RequestParam("replyContent") String replyContent, @RequestParam("replyName") String replyName, @RequestParam("replyBoardIdx") String replyBoardIdx) {

		if (replyDao.create(replyContent, replyName, replyBoardIdx) == 1) {

			return "redirect:/readPage?boardIdx=" + replyBoardIdx;

		} else {

			return "redirect:/failed?message=create reply failed:/";

		}

	}

	// 댓글 Delete
	@RequestMapping("/delete")
	public String delete(@RequestParam("replyIdx") String replyIdx, @RequestParam("replyBoardIdx") String replyBoardIdx) {

		if (replyDao.delete(replyIdx) == 1) {

			return "redirect:/readPage?boardIdx=" + replyBoardIdx;

		} else {

			return "redirect:/failed?message=delete reply failed:/";

		}

	}

}
