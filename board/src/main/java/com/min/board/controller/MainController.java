package com.min.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.board.dao.BoardDao;
import com.min.board.dto.BoardDto;

@Controller
public class MainController {

	@Autowired
	BoardDao boardDao;

	// Main
	@RequestMapping("/")
	public String index(Model model) {

		List<BoardDto> list = boardDao.list();
		System.out.println(list);
		model.addAttribute("list", list);

		return "index";

	}

	// Create 이동
	@RequestMapping("/write")
	public String write() {

		return "write";

	}

	// Create
	@RequestMapping("/writeOk")
	public String writeOk(@RequestParam("boardName") String boardName, @RequestParam("boardTitle") String boardTitle, @RequestParam("boardContent") String boardContent) {

		int result = boardDao.write(boardName, boardTitle, boardContent);

		if (result == 1) {

			System.out.println("글 등록 성공!");

		} else {

			System.out.println("글 등록 실패ㅜ");

		}

		return "redirect:/";

	}

}
