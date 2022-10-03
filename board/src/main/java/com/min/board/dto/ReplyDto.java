package com.min.board.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ReplyDto {

	private int replyIdx;
	private String replyName;
	private String replyContent;
	private int replyBoardIdx;
	private Date replyDate;

	public int getReplyIdx() {

		return replyIdx;

	}

	public void setReplyIdx(int replyIdx) {

		this.replyIdx = replyIdx;

	}

	public String getReplyName() {

		return replyName;

	}

	public void setReplyName(String replyName) {

		this.replyName = replyName;

	}

	public String getReplyContent() {

		return replyContent;

	}

	public void setReplyContent(String replyContent) {

		this.replyContent = replyContent;

	}

	public int getReplyBoardIdx() {

		return replyBoardIdx;

	}

	public void setReplyBoardIdx(int replyBoardIdx) {

		this.replyBoardIdx = replyBoardIdx;

	}

	public Date getReplyDate() {

		return replyDate;

	}

	public void setReplyDate(Date replyDate) {

		this.replyDate = replyDate;

	}

	@Override
	public String toString() {

		return "ReplyDto [replyIdx=" + replyIdx + ", replyName=" + replyName + ", replyContent=" + replyContent + ", replyBoardIdx=" + replyBoardIdx + ", replyDate=" + replyDate + "]";

	}

}
