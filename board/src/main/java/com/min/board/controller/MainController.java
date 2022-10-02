package com.min.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String createOk(@RequestParam("boardName") String boardName, @RequestParam("boardTitle") String boardTitle, @RequestParam("boardContent") String boardContent) {

		int result = boardDao.create(boardName, boardTitle, boardContent);

		if (result == 1) {

			System.out.println("글 등록 성공!");
			return "redirect:/";

		} else {

			System.out.println("글 등록 실패ㅜ");
			return "redirect:/write";

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

}
