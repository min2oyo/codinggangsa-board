package com.min.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.board.dao.BoardDao;
import com.min.board.dao.ReplyDao;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	@Autowired
	BoardDao boardDao;

	@Autowired
	ReplyDao replyDao;

	// 댓글 Create
	@RequestMapping("/create")
	public String create(@RequestParam("replyContent") String replyContent, @RequestParam("replyName") String replyName, @RequestParam("replyBoardIdx") String replyBoardIdx) {

		if (replyDao.create(replyContent, replyName, replyBoardIdx) == 1) {

			return "redirect:/readPage?boardIdx=" + replyBoardIdx;

		} else {

			return "redirect:/failed?message=create reply failed:/";

		}

	}

//	// 글 Read
//	@RequestMapping("/read")
//	public String read(Model model, @RequestParam("boardIdx") String boardIdx) {
//
//		boardDao.hit(boardIdx);	// 조회수 증가
//		model.addAttribute("board", boardDao.read(boardIdx));	// 글 DB
//		model.addAttribute("reply", replyDao.list(boardIdx));	// 댓글 DB
//
//		return "read";
//
//	}
//
//	// 글 Update 이동
//	@RequestMapping("/update")
//	public String update(Model model, @RequestParam("boardIdx") String boardIdx) {
//
//		model.addAttribute("board", boardDao.read(boardIdx));
//
//		return "update";
//
//	}
//
//	// 글 Update
//	@RequestMapping("/updateOk")
//	@ResponseBody
//	public String updateOk(@RequestParam("boardIdx") String boardIdx, @RequestParam("boardTitle") String boardTitle, @RequestParam("boardContent") String boardContent) {
//
//		if (boardDao.update(boardIdx, boardTitle, boardContent) == 1) {
//
//			return "<script>alert('글 수정 성공!');location.href='/read?boardIdx=" + boardIdx + "';</script>";
//
//		} else {
//
//			return "<script>alert('글 수정 실패ㅜ');location.href='/update?boardIdx=" + boardIdx + "';</script>";
//
//		}
//
//	}
//
//	// 글 Delete
//	@RequestMapping("/delete")
//	@ResponseBody
//	public String delete(@RequestParam("boardIdx") String boardIdx) {
//
//		if (boardDao.delete(boardIdx) == 1) {
//
//			return "<script>alert('글 삭제 성공!');location.href='/';</script>";
//
//		} else {
//
//			return "<script>alert('글 삭제 실패ㅜ');history.back();</script>";
//
//		}
//
//	}

}
