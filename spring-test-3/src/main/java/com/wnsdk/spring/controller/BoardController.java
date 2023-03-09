package com.wnsdk.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wnsdk.spring.model.BoardDto;
import com.wnsdk.spring.model.CommentDto;
import com.wnsdk.spring.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("/list")
	private String list(Model model) {
		List<BoardDto> articles = boardService.boardList();
		model.addAttribute("articles", articles);
		System.out.println(articles.toString());
		return "/board/list";
	}
	
	@GetMapping("/write")
	private String write() {
		return "/board/write";
	}
	
	@PostMapping("/write")
	private String write(@RequestParam BoardDto article, Model model) {
		boardService.boardWrite(article);
		return "/board/list";
	}
	
	@GetMapping("/detail/{articleNo}")
	private String detail(@PathVariable int articleNo, Model model) {
		BoardDto article = boardService.boardDetail(articleNo);
		model.addAttribute("article", article);
		return "/board/detail";
	}
	
	@ResponseBody
	@GetMapping("/comment/{articleNo}")
	private ResponseEntity<?> comment(@PathVariable int articleNo) {
		List<CommentDto> comments = boardService.getComments(articleNo);
		return new ResponseEntity<List<CommentDto>>(comments, HttpStatus.OK);
	}
}
