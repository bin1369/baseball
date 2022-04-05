package org.baseball.kia.controller;

import java.util.Map;

import org.baseball.kia.entity.BaseballChartVo;
import org.baseball.kia.entity.LineupVo;
import org.baseball.kia.entity.UniformInfoVo;
import org.baseball.kia.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/admin")
	public String adminHandle(Model model) { // 계정 관리 페이지 호출
		model.addAttribute("accountList", adminService.selectAccountByType("all"));
		model.addAttribute("menu", "account");
		return "/admin/account";
	}

	@RequestMapping(value = "/admin/account")
	public String adminAccountHandle(Model model, @RequestParam String type) { // 타입별 계정 정보 조회
		model.addAttribute("accountList", adminService.selectAccountByType(type));
		return "/admin/account-list";
	}
	
	@RequestMapping(value = "/admin/account/report")
	public String adminAccountReportHandle(@RequestParam String id) { // 신고 계정 차단 설정
		adminService.reportAccount(id);
		return "redirect: /admin";
	}
	

	@RequestMapping(value = "/admin/uniformInfo")
	public String uniformHandle(Model model) { // 상품 관리 페이지 호출
		model.addAttribute("menu", "uniform");
		return "/admin/uniformInfo";
	}
	
	@RequestMapping(value = "/admin/uniformInfo/search")
	public String uniformInfoSearchHandle(@RequestParam(required = false) String type, @RequestParam(required = false) String word, Model model) { // 유니폼 검색
		UniformInfoVo vo = new UniformInfoVo();
		if (type != null) {
			if (type.equals("uniformName")) {
				vo.setUniformName(word);
			
			} else if(type.equals("color")) {
				vo.setColor(word);
			
			} else if(type.equals("playerName")) {
				vo.setPlayerName(word);
			}
			model.addAttribute("uniformInfoList", adminService.selectUniformInfo(vo));
			return "/admin/uniformInfo-list";
			
		} else {
			model.addAttribute("uniformInfoList", adminService.selectUniformInfo(null));
			return "/admin/uniformInfo-list";
			
		}
	}
	
	@RequestMapping(value = "/admin/uniformInfo/update", method = RequestMethod.GET)
	public String uniformInfoUpdateHandle( @RequestParam int uniInfoNo, Model model ) { // 유니폼 정보 수정 페이지 요청
		UniformInfoVo vo = new UniformInfoVo();
		vo.setUniInfoNo(uniInfoNo);
		model.addAttribute("uniformInfo", adminService.selectUniformInfo(vo).get(0));
		model.addAttribute("menu", "uniform");
		return "/admin/uniformInfo-update";
	}

	@RequestMapping(value = "/admin/uniformInfo/update", method = RequestMethod.POST)
	public String uniformInfoUpdatePostHandle(@ModelAttribute UniformInfoVo vo, @RequestParam MultipartFile attach) { // 유니폼 정보 수정
		if (adminService.updateUniformInfo(vo, attach)) {
			return "redirect: /admin/uniformInfo";
		} else {
			return "redirect: /admin/uniformInfo/update?uniInfoNo="+vo.getUniInfoNo();
		}
	}

	@RequestMapping(value = "/admin/uniformInfo/insert", method = RequestMethod.GET)
	public String uniformInfoInsertHandle(@ModelAttribute UniformInfoVo vo, Model model) { // 유니폼 정보 등록 페이지 요청
		model.addAttribute("menu", "uniform");
		return "/admin/uniformInfo-insert";
	}

	@RequestMapping(value = "/admin/uniformInfo/insert", method = RequestMethod.POST)
	public String uniformInfoInsertPostHandle(@ModelAttribute UniformInfoVo vo, @RequestParam MultipartFile attach) { // 유니폼 정보 등록
		if(adminService.insertUniformInfo(vo, attach)) {
			return "redirect: /admin/uniformInfo";
		} else {
			return "redirect: /admin/uniformInfo/insert";
		}
	}
	

	@RequestMapping(value = "/admin/lineup")
	public String lineupHandle(Model model) { // 라인업 페이지 호출
		model.addAttribute("scheduleList", adminService.selectSchedule());// 경기일정 조회
		model.addAttribute("menu", "lineup");
		return "/admin/lineup";
	}

	@RequestMapping(value = "/admin/lineup/insert")
	public String lineupInsertHandle(Model model, @ModelAttribute LineupVo vo, @RequestParam String service) { // 라인업 입력, 수정
		
		if (service.equals("insert")) { // 라인업 입력
			adminService.insertLineup(vo);
			
		} else if (service.equals("update")) { // 라인업 수정
			adminService.updateLineup(vo);
		}
		
		model.addAttribute("menu", "lineup");
		return "redirect: /admin/lineup";
	}

	@ResponseBody
	@RequestMapping(value = "/admin/lineup/select")
	public LineupVo lineupSelectHandle(Model model, @RequestParam String gameDate, @RequestParam String gameTime) { // 라인업 조회
		LineupVo vo = new LineupVo();
		vo.setGameDate(gameDate);
		vo.setGameTime(gameTime);
		return adminService.selectLineup(vo);
	}
	
	@RequestMapping(value = "/admin/ticket")
	public String ticketHandle(Model model) { // 티켓 예매내역 페이지 호출
		model.addAttribute("menu", "ticket");
		return "/admin/ticket";
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/ticket/search")
	public Map<String, Object> ticketSearchHandle(@ModelAttribute BaseballChartVo vo, Model model) { // 티켓예매내역 검색
		return adminService.selectBaseballChartData(vo);
	}

	@RequestMapping(value = "/admin/uniformList")
	public String uniformListHandle(Model model) { // 상품 구매내역 조회 페이지 호출
		model.addAttribute("menu", "uniformList");
		return "/admin/uniformList";
	}
}