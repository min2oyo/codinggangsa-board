package com.min.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.min.board.dto.ReplyDto;

@Mapper
public interface ReplyDao {

	// 댓글 List
	public List<ReplyDto> list(String replyBoardIdx);

	// 댓글 Create
	public int create(String replyName, String replyContent, String replyBoardIdx);

	// 댓글 Delete
	public int delete(String replyIdx);

}
