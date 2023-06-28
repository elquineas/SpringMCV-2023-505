package com.eqluineas.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eqluineas.hello.models.AddressDto;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 33);
		model.addAttribute("tel", "010-1111-1111");
		return "home";
	}

	@RequestMapping(value = "/hello")
	public String hello(Model model) {
		AddressDto addrDto = new AddressDto();
		addrDto.setName("성춘향");
		addrDto.setTel("010-2222-2222");
		addrDto.setAge(16);
		addrDto.setAddress("광주광역시");
		model.addAttribute("ADDR",addrDto);
		return "hello";
	}
	
	@RequestMapping(value = "/user")
	public String user(Model model) {
		List<AddressDto> addrList = new ArrayList<AddressDto>();
		AddressDto addrDto = new AddressDto();
		
		addrDto.setName("성춘향");
		addrDto.setTel("010-1111-1111");
		addrDto.setAge(16);
		addrDto.setAddress("광주광역시");
		addrList.add(addrDto);
		
		addrDto = new AddressDto();
		addrDto.setName("이몽룡");
		addrDto.setTel("010-2222-2222");
		addrDto.setAge(20);
		addrDto.setAddress("서울특별시");
		addrList.add(addrDto);
		
		addrDto = new AddressDto();
		addrDto.setName("홍길동");
		addrDto.setTel("010-3333-3333");
		addrDto.setAge(24);
		addrDto.setAddress("부산광역시");
		addrList.add(addrDto);
		
		model.addAttribute("ADDRS",addrList);
		
		for(AddressDto dto : addrList) {
			System.out.println(dto.toString());
		}
		
		return "user2";
	}
}
