package com.min.board.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String root() {

		return "redirect:listForm";

	}

	@RequestMapping("/listForm")
	public String listFrom() {

		return "listForm";

	}

}
