package com.min.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.min.board.dto.BoardDto;

@Mapper
public interface BoardDao {

	// 글 List
	public List<BoardDto> list();

	// 글 Create
	public int create(String boardName, String boardTitle, String boardContent);

	// 글 Read
	public BoardDto read(String boardIdx);

	// 글 Update
	public int update(String boardIdx, String boardTitle, String boardContent);

	// 글 Delete
	public int delete(String boardIdx);

	// 조회수 Update
	public int hit(String boardIdx);

}
