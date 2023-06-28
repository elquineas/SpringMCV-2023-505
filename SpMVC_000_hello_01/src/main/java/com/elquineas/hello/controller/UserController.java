package com.elquineas.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elquineas.hello.models.UserDto;

import lombok.extern.slf4j.Slf4j;

/*
 * class를 만들고 @Controller라는 Annotation을 부착하면 
 * Spring Framework에서 자동으로 이 클래스에 
 * Controller 기능을 부여한다
 * 
 * Controller class는 Web Application에서 Request를 가장 먼저 수신하는 객체이다.
 * 
 * 이 클래스에 method를 선언하고 
 * method에 @Request Annotation을 부착하면 
 * Web의 URL(RUI)를 처리하는 method가 된다
 * 
 */
@Slf4j
@Controller
public class UserController {
	// method=GET
	// Browser 의 주소창에 URL 을 입력하여 요청
	// 또는 a tag 의 href 에 주소를 연결하여 요청
	// 일반적인 (결과)화면을 요청하거나 할때
	@RequestMapping(value="/user/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	// method=POST
	// form 으로 감싼 input data 를 보낼때 주로 사용
	// form tag의 method 속성을 반드시 POST로 지정해야 한다
	// 데이터를 서버로 보낼때 사용하는 Request
	
	// client(web)에서 보낸 username 변수, password 변수에
	// 담긴 데이터를 받을때는 method의 매개변수를 설정해 주면된다.
	@RequestMapping(value = "/user/login", method=RequestMethod.POST)
	public String login(String username, String password,  Model model) {
		model.addAttribute("name", username);
		model.addAttribute("password", password);
		return "login_ok";
	}
	
	@RequestMapping(value = "/user/join", method=RequestMethod.GET)
	public String join() {
		/*
		 method 에서 String 값을 return 하면
		 views 폴더에서 해당 String 의 jsp 파일을 찾아
		 rendering을 실행한다
		 
		 method에서 null 값을 return 하면
		 views 폴더에서 RequestMapping 과 같은 path 위치에서
		 jsp 파일을 찾는다.
		 views/user/join.jsp 를 찾는다.
		*/
		return null;
	}
	
//	@RequestMapping(value = "/user/join", method=RequestMethod.POST)
//	public String join(String username, String password, String re_password, String name, String tel, String addr, Model model) {
//		model.addAttribute("username", username);
//		model.addAttribute("password", password);
//		model.addAttribute("re_password", re_password);
//		model.addAttribute("name", name);
//		model.addAttribute("tel", tel);
//		model.addAttribute("addr", addr);
//		return "user/join_ok";
//	}
	
	@RequestMapping(value = "/user/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserDto user, String re_password, Model model) {
		
		// Web project에서 system.out 사용 금지
		
		// logback을 사용하여 Console에 확인 메시지 출력하기
		log.debug(user.toString());
		
		model.addAttribute("USER", user);
		model.addAttribute("re_password", re_password);
		return "user/join_ok";
	}
}
