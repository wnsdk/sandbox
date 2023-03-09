package com.ssafy.edu.board;

import java.util.List;

// Model (database 관련작업)
public class BoardService {
	private static BoardService service=new BoardService();
	
	private BoardService() {
		dao=new BoardDaoImpl();
	}
	public static BoardService getInstance() {
		return service;
	}
	
	private IBoardDao dao;
	//-----------------------------
	public boolean addBoard(Board board) {
		return dao.addBoard(board);
	}
	public List<Board> getBoardList() {
		return dao.getBoardList();
	}
	public Board getBoard(int article_no) {
		return dao.getBoard(article_no);
	}
	public boolean updateBoard(Board board) {
		return dao.updateBoard(board);
	}
	public boolean deleteBoard(int article_no) {
		return dao.deleteBoard(article_no);
	}
}
