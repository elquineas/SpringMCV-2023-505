package com.elquineas.address.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elquineas.address.model.UserDto;
import com.elquineas.address.service.UserService;

@Service
public class UserServiceImplV1 implements UserService{

	@Override
	public UserDto findById(String id) {
		return null;
	}
	
	@Transactional
	@Override
	public String userLogin(UserDto uDto) {
		String username = uDto.getUsername();
		String password = uDto.getPassword();
		if(!username.equalsIgnoreCase("elquineas")) {
			return "F_USERNAME";
		}else if(!password.equals("qwer1234")){
			return "F_PASSWORD";
		}else {
			return "OK";
		}
		
	}

	@Override
	public int userJoin(UserDto uDto) {
		return 0;
	}

}
