package com.callor.car.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.callor.car.model.UserDto;
import com.callor.car.service.UserService;

import lombok.extern.slf4j.Slf4j;

@SessionAttributes("USER")
@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserContorller {
	
	protected final UserService userService;
	public UserContorller(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@ModelAttribute("USER") UserDto userDto, String ERROR, Model model) {
		model.addAttribute("ERROR",ERROR);
		return "user/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@ModelAttribute("USER") UserDto userDto, HttpSession httpSession, SessionStatus sessionStatus) {
		try {
			UserDto resultDto = userService.login(userDto);
			httpSession.setAttribute("LOGIN_USER", resultDto);
		} catch (Exception e) {
			// service 에서 new Exception(message) 라고 보낸 message get 하기 
			String message = e.getMessage();
			return "redirect:/user/login?ERROR="+message;
		}
		sessionStatus.setComplete();
		return "redirect:/";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(@ModelAttribute("USER") UserDto userDto) {
		return "user/join";
	}
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@ModelAttribute("USER") UserDto userDto,Model model, SessionStatus sessionStatus) {
		int result = userService.join(userDto);
		sessionStatus.setComplete();
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("LOGIN_USER");
		return "redirect:/";
	}
	
	
	@ModelAttribute("USER")
	public UserDto userDto() {
//		return UserDto.builder().build();
		return new UserDto();
	}

}
