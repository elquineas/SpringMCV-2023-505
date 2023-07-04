package com.elquineas.address.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.elquineas.address.model.AddrDto;
import com.elquineas.address.model.UserDto;

public interface UserService {
	
	public UserDto findById(String id);
	public String userLogin(UserDto uDto);
	public int userJoin(UserDto uDto);
	
}
