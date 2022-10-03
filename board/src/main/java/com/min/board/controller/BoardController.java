package com.min.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.board.dao.BoardDao;
import com.min.board.dao.ReplyDao;

@Controller
public class BoardController {

	@Autowired
	BoardDao boardDao;

	@Autowired
	ReplyDao replyDao;

	// 글 List
	@RequestMapping("/")
	public String index(Model model) {

		model.addAttribute("board", boardDao.list());

		return "main";

	}

	// 글 Create 이동
	@RequestMapping("/createPage")
	public String createPage() {

		return "create";

	}

	// 글 Create
	@RequestMapping("/create")
	public String create(@RequestParam("boardName") String boardName, @RequestParam("boardTitle") String boardTitle, @RequestParam("boardContent") String boardContent) {

		if (boardDao.create(boardName, boardTitle, boardContent) == 1) {

			return "redirect:/";

		} else {

			return "redirect:/failed?message=create failed:/";

		}

	}

	// 글 Read
	@RequestMapping("/readPage")
	public String readPage(Model model, @RequestParam("boardIdx") String boardIdx) {

		boardDao.hit(boardIdx);	// 조회수 증가
		model.addAttribute("board", boardDao.read(boardIdx));	// 글 DB
		model.addAttribute("reply", replyDao.list(boardIdx));	// 댓글 DB

		return "read";

	}

	// 글 Update 이동
	@RequestMapping("/updatePage")
	public String updatePage(Model model, @RequestParam("boardIdx") String boardIdx) {

		model.addAttribute("board", boardDao.read(boardIdx));

		return "update";

	}

	// 글 Update
	@RequestMapping("/update")
	public String update(@RequestParam("boardIdx") String boardIdx, @RequestParam("boardTitle") String boardTitle, @RequestParam("boardContent") String boardContent) {

		if (boardDao.update(boardIdx, boardTitle, boardContent) == 1) {

			return "redirect:/readPage?boardIdx=" + boardIdx;

		} else {

			return "redirect:/failed?message=update failed :/";

		}

	}

	// 글 Delete
	@RequestMapping("/delete")
	public String delete(@RequestParam("boardIdx") String boardIdx) {

		if (boardDao.delete(boardIdx) == 1) {

			return "redirect:/";

		} else {

			return "redirect:/failed?message=delete failed :/";

		}

	}

}
