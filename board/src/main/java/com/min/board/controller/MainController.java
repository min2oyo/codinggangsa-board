package com.min.board.controller;

import javax.servlet.http.HttpServletRequest;

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
	public String createOk(HttpServletRequest request, @RequestParam("boardName") String boardName, @RequestParam("boardTitle") String boardTitle, @RequestParam("boardContent") String boardContent) {

		int result = boardDao.create(boardName, boardTitle, boardContent);

		if (result == 1) {

			System.out.println("글 등록 성공!");
			request.getSession().setAttribute("alert", "글 등록 성공!");
			return "redirect:/";

		} else {

			System.out.println("글 등록 실패ㅜ");
			request.getSession().setAttribute("alert", "글 등록 실패ㅜ");
			return "redirect:/create";

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
	public String updateOk(HttpServletRequest request, @RequestParam("boardIdx") String boardIdx, @RequestParam("boardTitle") String boardTitle, @RequestParam("boardContent") String boardContent) {

		int result = boardDao.update(boardIdx, boardTitle, boardContent);

		if (result == 1) {

			System.out.println("글 수정 성공!");
			request.getSession().setAttribute("alert", "글 수정 성공!");
			return "redirect:/read?boardIdx=" + boardIdx;

		} else {

			System.out.println("글 수정 실패ㅜ");
			request.getSession().setAttribute("alert", "글 수정 실패ㅜ");
			return "redirect:/update?boardIdx=" + boardIdx;

		}

	}

	// Delete
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("boardIdx") String boardIdx) {

		int result = boardDao.delete(boardIdx);

		if (result == 1) {

			request.getSession().setAttribute("alert", "글 삭제 성공!");
			System.out.println("글 삭제 성공!");
			return "redirect:/";

		} else {

			request.getSession().setAttribute("alert", "글 삭제 실패ㅜ");
			System.out.println("글 삭제 실패ㅜ");
			return "redirect:/update?boardIdx=" + boardIdx;

		}

	}

}
