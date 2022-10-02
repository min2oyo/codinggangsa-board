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

	@RequestMapping("/")
	public String root() {

		return "redirect:listForm";

	}

	@RequestMapping("/listForm")
	public String listFrom(Model model) {

		List<BoardDto> list = boardDao.list();
		System.out.println(list);
		model.addAttribute("list", list);

		return "listForm";

	}

}
