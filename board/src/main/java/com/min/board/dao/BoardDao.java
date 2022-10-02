package com.min.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.min.board.dto.BoardDto;

@Mapper
public interface BoardDao {

	public List<BoardDto> list();

}
