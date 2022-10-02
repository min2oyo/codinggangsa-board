package com.min.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.board.dao.BoardDao;

@Controller
public class MainController {

	@Autowired
	BoardDao boardDao;

	// Main
	@RequestMapping("/")
	public String index(Model model) {

		model.addAttribute("data", boardDao.list());

		return "main";

	}

	// Create 이동
	@RequestMapping("/create")
	public String create() {

		return "create";

	}

	// Create
	@RequestMapping("/createOk")
	@ResponseBody
	public String createOk(@RequestParam("boardName") String boardName, @RequestParam("boardTitle") String boardTitle, @RequestParam("boardContent") String boardContent) {

		if (boardDao.create(boardName, boardTitle, boardContent) == 1) {

			return "<script>alert('글 등록 성공!');location.href='/';</script>";

		} else {

			return "<script>alert('글 등록 실패ㅜ!');location.href='/create';</script>";

		}

	}

	// Read
	@RequestMapping("/read")
	public String read(Model model, @RequestParam("boardIdx") String boardIdx) {

		model.addAttribute("data", boardDao.read(boardIdx));

		return "read";

	}

	// Update 이동
	@RequestMapping("/update")
	public String update(Model model, @RequestParam("boardIdx") String boardIdx) {

		model.addAttribute("data", boardDao.read(boardIdx));

		return "update";

	}

	// Update
	@RequestMapping("/updateOk")
	@ResponseBody
	public String updateOk(@RequestParam("boardIdx") String boardIdx, @RequestParam("boardTitle") String boardTitle, @RequestParam("boardContent") String boardContent) {

		if (boardDao.update(boardIdx, boardTitle, boardContent) == 1) {

			return "<script>alert('글 수정 성공!');location.href='/read?boardIdx=" + boardIdx + "';</script>";

		} else {

			return "<script>alert('글 수정 실패ㅜ');location.href='/update?boardIdx=" + boardIdx + "';</script>";

		}

	}

	// Delete
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam("boardIdx") String boardIdx) {

		if (boardDao.delete(boardIdx) == 1) {

			return "<script>alert('글 삭제 성공!');location.href='/';</script>";

		} else {

			return "<script>alert('글 삭제 실패ㅜ');history.back();</script>";

		}

	}

}
