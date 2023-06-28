package com.elquineas.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elquineas.hello.models.UserDto;
import com.elquineas.hello.service.UserService;
import com.elquineas.hello.service.impl.UserServiceImplV1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	protected UserService uService;
	
//	public UserController() {
//		uService = new UserServiceImplV1();
//	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String UserList(Model model) {
		List<UserDto> uList = uService.selectAll();
//		log.info(uList.toString());
//		log.debug(uList.toString());
		model.addAttribute("USERS",uList);
		return "user/list";
	}

	@RequestMapping(value="/input", method = RequestMethod.GET)
	public String Input(Model model) {
		return "user/input";
	}
	
	@RequestMapping(value="/input", method = RequestMethod.POST)
	public String Input(@ModelAttribute UserDto user, String re_password, Model model) {
		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		log.debug(user.toString());
		model.addAttribute("USER",user);
		model.addAttribute("REPW",re_password);
		return "user/view";
	}
	
//	@RequestMapping(value="/view", method = RequestMethod.GET)
//	public String View(Model model) {
//		
//		return "user/input";
//	}
}
