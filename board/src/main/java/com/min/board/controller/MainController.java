package com.min.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.min.board.dao.BoardDao;
import com.min.board.dto.BoardDto;

@Controller
public class MainController {

	@Autowired
	BoardDao boardDao;

	// Main
	@RequestMapping("/")
	public String listFrom(Model model) {

		List<BoardDto> list = boardDao.list();
		System.out.println(list);
		model.addAttribute("list", list);

		return "index";

	}

	// Create 이동
	@RequestMapping("/write")
	public String writeForm() {

		return "write";

	}

}
