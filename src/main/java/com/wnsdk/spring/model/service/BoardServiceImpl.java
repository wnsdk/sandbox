package com.wnsdk.spring.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnsdk.spring.model.BoardDto;
import com.wnsdk.spring.model.CommentDto;
import com.wnsdk.spring.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper boardMapper;

	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	@Override
	public List<BoardDto> boardList() {
		return boardMapper.boardList();
	}

	@Override
	public void boardWrite(BoardDto article) {
		boardMapper.boardWrite(article);
	}

	@Override
	public BoardDto boardDetail(int articleNo) {
		return boardMapper.boardDetail(articleNo);
	}

	@Override
	public List<CommentDto> getComments(int articleNo) {
		return boardMapper.commentList(articleNo);
	}

}
