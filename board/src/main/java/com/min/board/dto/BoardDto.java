package com.min.board.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class BoardDto {

	private int boardIdx;
	private String boardName;
	private String boardTitle;
	private String boardContent;
	private int boardHit;
	private Date boardDate;

	public int getBoardIdx() {

		return boardIdx;

	}

	public void setBoardIdx(int boardIdx) {

		this.boardIdx = boardIdx;

	}

	public String getBoardName() {

		return boardName;

	}

	public void setBoardName(String boardName) {

		this.boardName = boardName;

	}

	public String getBoardTitle() {

		return boardTitle;

	}

	public void setBoardTitle(String boardTitle) {

		this.boardTitle = boardTitle;

	}

	public String getBoardContent() {

		return boardContent;

	}

	public void setBoardContent(String boardContent) {

		this.boardContent = boardContent;

	}

	public int getBoardHit() {

		return boardHit;

	}

	public void setBoardHit(int boardHit) {

		this.boardHit = boardHit;

	}

	public Date getBoardDate() {

		return boardDate;

	}

	public void setBoardDate(Date boardDate) {

		this.boardDate = boardDate;

	}

	@Override
	public String toString() {

		return "BoardDto [boardIdx=" + boardIdx + ", boardName=" + boardName + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardHit=" + boardHit + ", boardDate=" + boardDate + "]";

	}

}
