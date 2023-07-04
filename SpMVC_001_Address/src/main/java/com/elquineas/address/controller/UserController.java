package com.elquineas.address.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elquineas.address.model.UserDto;
import com.elquineas.address.service.UserService;
/*
 * Controller class
 * @Controller Annotation이 부착된 Class
 * Client 로 부터 Request 요첨이 다다르면, 어디로 요청을 전달할지
 * Routing 역할을 하는 class 
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	protected final UserService uService; 
	
	public UserController(UserService uService) {
		this.uService = uService;
	}
	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String home() {
		/*
		 * Controller.method() 에서 response 결과인 view 이름을 return 하면 
		 * /WEB-INF/views/ 폴더에서 파일을 찾아 rendering 할 후 응답을 한다.  
		 * 
		 * 그런데, 문자열이 아니고 null을 return 하면
		 * 이 method 가 호출된 requestMapping 주소가 view 파일 이름을 대신하게 된다
		 * 
		 */
		return null;
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(String error, Model model) {
		model.addAttribute("ERROR",error);
		model.addAttribute("BODY","LOGIN");
		return "home";
	}
	
	/*
	 * HttpSession : Servlet Session
	 * Java 기반 MVC 프로젝트에서 가장 많이 사용하는 Session 관리 객체
	 * method 의 매개변수에 HttpSession 객체를 설정하면 
	 * Spring 에서는 DespatcherServlet 이 httpSession 객체를 생성하여 method 에 매개변수로 전달해 준다 
	 * 
	 * 이 Session 에 데이터를 저장하면 그 데이터는 model 에 데이터를 담는 것과 똑같이 사용이 가능하며,
	 * 일정조건 하에서 데이터는 계속해서 유지된다.
	 * model 에 데이터를 담는것과 차이는 
	 * model 데이터는 한번 view와 rendering을 수행한 후 소멸 Session 데이터는 특별한 조건하에서는 계속 유지된다.
	 * 또한 Session 데이터가 필요 없을 경우 이 데이터는 강제 소멸 시켜야 한다.
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(UserDto uDto, HttpSession httpSession) {
		String result = uService.userLogin(uDto); 
		if(result.equals("OK")) {
			httpSession.setAttribute("USER", uDto);
			return "redirect:/";
		}else {
			return "redirect:/user/login?error="+result;
		}
	}
	

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return null;
	}
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String mypage() {
		return null;
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		// 세션에 저장된 데이터 Clear
		httpSession.setAttribute("USER",null);
		// 세션에 저장된 데이터 삭제
		httpSession.removeAttribute("USER");
		return "redirect:/?message=LOGOUT";
	}
	
	
}
