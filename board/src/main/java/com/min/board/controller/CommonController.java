package com.min.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {

	// 실행 실패
	@RequestMapping("/failed")
	@ResponseBody
	public String failed(@RequestParam("message") String message) {

		return "<script>alert('" + message + "');history.back();</script>";

	}

}
