package com.wnsdk.spring.model.service;

import java.util.List;

import com.wnsdk.spring.model.BoardDto;
import com.wnsdk.spring.model.CommentDto;

public interface BoardService {

	List<BoardDto> boardList();
	void boardWrite(BoardDto article);
	BoardDto boardDetail(int articleNo);
	List<CommentDto> getComments(int articleNo);

}
