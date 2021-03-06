package org.baseball.kia.yg.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.baseball.kia.yg.entity.BoardVo;
import org.baseball.kia.yg.entity.CommentVo;
import org.baseball.kia.yg.entity.PagingVo;
import org.baseball.kia.yg.service.BoardService;
import org.baseball.kia.yg.service.CommentService;
import org.baseball.kia.yg.service.LikeService;
import org.baseball.kia.yg.util.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;

	@Autowired
	CommentService commentService;
	
	@Autowired
	LikeService likeService;

	@RequestMapping(value = "/intro", method = RequestMethod.GET)
	public String introduction(Model model) {
		model.addAttribute("menu", "intro");
		return "/yg/introteam";
	}

	@RequestMapping(value = "/free", method = RequestMethod.GET)
	public String defaultHandle(Model model, Criteria cri) {
		model.addAttribute("menu", "free");
		model.addAttribute("all", boardService.getAll(cri));

		PagingVo pvo = new PagingVo();
		pvo.setCri(cri);
		pvo.setTotalCount(boardService.listCount());

		model.addAttribute("pvo", pvo);
		return "/yg/board";
	}

	@RequestMapping(path = "/write", method = RequestMethod.GET)
	public String insertGetHandle(Model model) {
		return "yg/boardwrite";
	}

	@RequestMapping(path = "/write", method = RequestMethod.POST)
	public String insertPostHandle(@ModelAttribute("vo") BoardVo vo, HttpServletRequest request,
			MultipartHttpServletRequest mhsr) throws IOException {

		boolean rst = boardService.addNewOne(vo);
		if (!rst) {
			return "/yg/boardwrite";
		}
		
		return "redirect:/free";
	}

	@RequestMapping(value = "/boardview", method = RequestMethod.GET)
	public String boardView(@RequestParam("boardNo") int no, Model model, HttpSession httpSession) {
		boardService.updateCnt(no);
		BoardVo vo = boardService.getOneByNo(no);
		if (vo == null) {
			return "redirect:/free";
		}
		model.addAttribute("board", vo);
		model.addAttribute("cmt", new CommentVo());
		
//		AccountVo loginUserVo = (AccountVo) httpSession.getAttribute("loginUser");
//		LikeVo lvo = new LikeVo();
//		lvo.setBoardNoLike(no);
//		lvo.setIdLike(loginUserVo.getId());
//		
//		int likes = 0;
//		int check = likeService.likeBoardCount(lvo);
//		
//		if(check ==0) {
//			likeService.likeinsert(lvo);
//		}else if(check==1) {
//			likes = likeService.likeViewCount(lvo);
//		}
//		
//		model.addAttribute("ltlike",likes);
		
		return "/yg/boardview";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String boardDelete(@RequestParam("boardNo") int no) {
		if (no > 0) {
			boardService.boardDelete(no);
		}
		return "redirect:/free";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String getUpdate(@RequestParam("no") int no, Model model) {
		BoardVo vo = boardService.getOneByNo(no);
		model.addAttribute("one", vo);
		return "/yg/boardupdate";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String postUpdate(BoardVo vo) {
		boardService.update(vo);
		return "redirect:/boardview?boardNo=" + vo.getBoardNo();
	}

}
