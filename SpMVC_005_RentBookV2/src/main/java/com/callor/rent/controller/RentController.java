package com.callor.rent.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.callor.rent.models.RentBookDto;
import com.callor.rent.models.RentBookVO;
import com.callor.rent.service.RentBookService;

import lombok.extern.slf4j.Slf4j;


/*
 * localhost:8080/rent/rent 또는 localhost:8080/rent/rent/* 로 요청이 들어왔을때
 * 		Browser 에 주소를 입력하거나 nav 항목을 클릭 했을때
 * 
 * 서비스를 제공할 시작점이다
 */
@Slf4j
@Controller
@RequestMapping(value="/rent")
@SessionAttributes("RENT_WORK")
public class RentController {
	
	protected final RentBookService rService;
	public RentController(RentBookService rService) {
		this.rService = rService;
	}

	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String home(Model model) {
		List<RentBookVO> rList = rService.selectAll();
		log.debug("(컨트롤러)대출리스트 확인 : {}",rList);
		model.addAttribute("RENTBOOKS",rList);
		return "rent/home";
	}

	//member input
	@RequestMapping(value= {"/insert"} ,method=RequestMethod.GET)
	public String work_book(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		return "rent/work_book";
	}
	
	@RequestMapping(value= {"/go/member"} ,method=RequestMethod.POST)
	public String work_member(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO,Model model) {
		// model.addAttribute("RENT_WORK",rentBookVO);
		return "rent/work_member";
	}

	@RequestMapping(value= {"/go/complete"} ,method=RequestMethod.POST)
	public String work_complete(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		return "rent/work_complete";
	}
	@RequestMapping(value= {"/insert"} ,method=RequestMethod.POST)
	public String work_insert(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO, SessionStatus session) {
		log.debug("(컨트롤러)도서대출 확인 : {}",rentBookVO);
		int result = rService.insert(rentBookVO);
		// SessionAtrubutes 에 보관중인 객체를 모두 사용한 후에는 반드시 Clear 해주어야한다.
		session.setComplete();
		return "redirect:/rent";
	}
	

	@ModelAttribute("RENTBOOK")
	public RentBookDto newRentBookDto() {
		return RentBookDto.builder().build();
	}
	@ModelAttribute("RENT_WORK")
	public RentBookVO newRentBookVO() {
		// Java 1.8 이후에서는 Local** 클래스를 적극 사용하기를 권장
		// Java 1.7 이하는 1.x 로 표기
		
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalDateTime returnDate = localDateTime.plusDays(7);
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");	// 날짜
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");		// 시간
		
		return RentBookVO.builder().rent_date(localDateTime.format(dateFormat))
				                   .rent_return_date(returnDate.format(dateFormat))
				                   .build();
	}

}
