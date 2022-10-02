package com.min.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.min.board.dto.BoardDto;

@Mapper
public interface BoardDao {

	// Main
	public List<BoardDto> list();

	// Create
	public int write(String boardName, String boardTitle, String boardContent);

}
