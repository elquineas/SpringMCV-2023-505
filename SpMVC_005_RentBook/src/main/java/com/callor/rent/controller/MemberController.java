package com.callor.rent.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.rent.models.BookDto;
import com.callor.rent.models.MemberDto;
import com.callor.rent.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	protected final MemberService mService;
	public MemberController(MemberService mService) {
		this.mService = mService;
	}
	
	@RequestMapping(value= {"/",""} ,method=RequestMethod.GET)
	public String home(Model model) {
		List<MemberDto> mList = mService.selectAll();
		model.addAttribute("MEMBERS",mList);
		return "member/home";
	}
	
	//member input
	@RequestMapping(value= {"/insert"} ,method=RequestMethod.GET)
	public String insert(@ModelAttribute("MEMBER") MemberDto mDto) {
		return "member/input";
	}
	@RequestMapping(value= {"/insert"} ,method=RequestMethod.POST)
	public String insert(@ModelAttribute("MEMBER") MemberDto mDto, Model model) {
		log.debug("(컨트롤러)회원정보 확인 : {}",mDto);
		try {
			int result = mService.insert(mDto);
		} catch (Exception e) {
			String message = e.getMessage();
			model.addAttribute("MESSAGE",message);
			model.addAttribute("MEMBER",mDto);
			return "member/input";
		}
		
		return "redirect:/member";
	}

	@RequestMapping(value="/{m_code}/detail",method=RequestMethod.GET)
	public String detail(@PathVariable("m_code") String mcode, Model model ) {
		MemberDto mDto = mService.findById(mcode);
		model.addAttribute("MEMBER",mDto);
		return "member/detail";
	}
	
	@RequestMapping(value="/{m_code}/update",method=RequestMethod.GET)
	public String update(@PathVariable("m_code") String mcode, Model model ) {
		MemberDto mDto = mService.findById(mcode);
		model.addAttribute("MEMBER",mDto);
		model.addAttribute("STATE","UPDATE");
		return "member/input";
	}
	@RequestMapping(value="/{m_code}/update",method=RequestMethod.POST)
	public String update(@PathVariable("m_code") String mcode, MemberDto mDto ,Model model ) {
		log.debug("(컨트롤러)업데이트 확인 : {}",mDto);
		if(!mcode.isBlank()) mDto.setM_code(mcode);
		try {
			int result = mService.update(mDto);
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			model.addAttribute("MESSAGE",message);
			model.addAttribute("MEMBER",mDto);
			e.printStackTrace();
			
			return "member/input";
		}
//		return String.format("redirect:/member/%s/detail", mcode);
		return "redirect:/member/{m_code}/detail";
		
	}
	
	
	@ModelAttribute("MEMBER")
	public MemberDto newMemberDto() {
		return MemberDto.builder().build();
	}
	
}
