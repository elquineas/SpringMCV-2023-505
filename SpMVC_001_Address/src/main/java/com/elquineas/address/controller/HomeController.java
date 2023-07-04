package com.elquineas.address.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elquineas.address.model.AddrDto;
import com.elquineas.address.service.AddrService;
/*
 * Controller class
 * @Controller Annotation이 부착된 Class
 * Client 로 부터 Request 요첨이 다다르면, 어디로 요청을 전달할지
 * Routing 역할을 하는 class 
 */
@Controller
public class HomeController {

//	@Autowired
//	protected AddrDao addrDao;
	
	protected final AddrService addrService;
	public HomeController(AddrService addrService) {
		this.addrService = addrService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(String message, Model model) {
		
		model.addAttribute("MSG",message);
		List<AddrDto> addrList = addrService.selectAll();
		model.addAttribute("ADDRS",addrList);
		return "home";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	@ResponseBody
	public List<AddrDto> list() {
		List<AddrDto> addrList = addrService.selectAll();
		return addrList;
	}
	
	
	/*
	 * localhost:8080/address/insert 로 요청이오면
	 * addr/input.jsp 파일을 열어서 Response 하도록 method 생성
	 */

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {
		model.addAttribute("BODY","INPUT");
		return "home";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
//	@ResponseBody
//	public String insert(String a_id, String a_name, String a_tel, String a_addr) {
////		model.addAttribute("BODY","INPUT");
//		return String.format("이름:%s, 전화번호:%s, 주소:%s",a_name,a_tel,a_addr);
//	}
	public String insert(@ModelAttribute AddrDto aDto) {
//		model.addAttribute("BODY","INPUT");
		addrService.insert(aDto);
		return "redirect:/";
//		return String.format("이름:%s, 전화번호:%s, 주소:%s",aDto.getA_name(),aDto.getA_tel(),aDto.getA_addr());
	}
	
	
	@RequestMapping(value = "/insert/test", method = RequestMethod.GET)
	public String insert() {
		return "addr/input";
	}
	
	@RequestMapping(value="/id_check", method=RequestMethod.GET)
	@ResponseBody
	public String idCheck(String id) {
		return addrService.idCheck(id);	
//		if(addrDto == null) {
//			return "OK";
//		}else if(addrDto.getA_id().equals(id)) {
//			return "FAIL";
//		}else {
//			return "FAIL";
//		}
	}
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(String id, Model model) {
		AddrDto aDto = addrService.findById(id); 
		model.addAttribute("ADDR",aDto);
		model.addAttribute("BODY","DETAIL");
		return "home";
	}

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(String id, Model model) {
		int result = addrService.delete(id); 
		
		if(result > 0) {
			return "redirect:/";
		}else {
			return "redirect:/detail?id="+id;
		}
	}

	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(String id, Model model) {
		AddrDto addrDto = addrService.findById(id);
		model.addAttribute("ADDR",addrDto);
		model.addAttribute("BODY","UPDATE");
		return "home";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public String update(@ModelAttribute AddrDto aDto, Model model) {
		int result = addrService.update(aDto); 
		String id = aDto.getA_id();
		if(result > 0) {
			return "redirect:/detail?id="+id;
		}else {
			return "redirect:/update?id="+id;
		}
//		return "redirect:/";
	}
}
