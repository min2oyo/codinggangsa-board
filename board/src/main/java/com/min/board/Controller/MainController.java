package com.min.board.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/")
	@ResponseBody
	public String root() {

		return "root() 생성";

	}

	@RequestMapping("/listForm")
	public String listFrom() {

		return "listForm";

	}

}
