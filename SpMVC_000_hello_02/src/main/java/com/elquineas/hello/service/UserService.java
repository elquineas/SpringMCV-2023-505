package com.elquineas.hello.service;

import java.util.List;

import com.elquineas.hello.models.UserDto;

public interface UserService {

	public List<UserDto> selectAll();
	public UserDto findById(String id);
	public int input(UserDto dto);
}
