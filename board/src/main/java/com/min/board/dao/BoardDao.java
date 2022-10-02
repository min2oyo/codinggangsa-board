package com.min.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.min.board.dto.BoardDto;

@Mapper
public interface BoardDao {

	// Main
	public List<BoardDto> list();

	// Create
	public int create(String boardName, String boardTitle, String boardContent);

	// Read
	public BoardDto read(String boardIdx);

	// Update
	public int update(String boardIdx, String boardTitle, String boardContent);

	// Delete
	public int delete(String boardIdx);

}
