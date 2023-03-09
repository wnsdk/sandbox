package com.wnsdk.spring.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wnsdk.spring.model.BoardDto;
import com.wnsdk.spring.model.CommentDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> boardList();
	void boardWrite(BoardDto article);
	BoardDto boardDetail(int articleNo);
	List<CommentDto> commentList(int articleNo);

}
