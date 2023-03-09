package com.wnsdk.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wnsdk.board.model.BoardDto;
import com.wnsdk.board.service.BoardService;
import com.wnsdk.util.PageNavigation;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private ServletContext servletContext;
	
	// 생성자 주입
	private final BoardService boardSevice;
	
	@Autowired
	public BoardController(BoardService boardService) {
		super();
		this.boardSevice = boardService;
	}
	
	// 게시글 작성 페이지로 이동
	@GetMapping("/write")
	public String write(@RequestParam Map<String, String> map, Model model) {
		logger.debug("write call parameter {}", map);
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "board/write";
	}
	
	// 게시글 작성
	@PostMapping("/write")
	public String write(BoardDto boardDto, @RequestParam("upfile") MultipartFile[] files, HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception {
		return "redirect:board/list";	// 게시글 작성 후, 목록 페이지로 바로 이동
	}
	
	// 게시글 목록 페이지로 이동
	@GetMapping("/list")
	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<BoardDto> list = boardSevice.listArticle(map);
		PageNavigation pageNavigation = boardSevice.makePageNavigation(map);
		
		mav.addObject("articles", list);
		mav.addObject("navigation", pageNavigation);
		mav.addObject("pgno", map.get("pgno"));
		mav.addObject("key", map.get("key"));
		mav.addObject("word", map.get("word"));
		
		mav.setViewName("board/list");		
		return mav;
	}
	
	// 게시글 상세 보기 페이지로 이동
	@GetMapping("/view")
	public String view () {
		return "board/view";
	}
	
	// 게시글 수정 페이지로 이동
	@GetMapping("/modify")
	public String modify(BoardDto boardDto, Map<String, String> map, RedirectAttributes redirectAttributes) {
		return "board/modify";
	}
	
	// 게시글 수정
	@PostMapping("/modify")
	public String modify() {
		return "refirect:/board/list";
	}
	
	// 게시글 삭제
	@GetMapping("/delete")
	public String delete() {
		return "refirect:/board/list";
	}
	
	// 파일 다운로드
	@GetMapping("/download")
	public ModelAndView downloadFile() {
		return new ModelAndView("redirect:/");
	}
}
