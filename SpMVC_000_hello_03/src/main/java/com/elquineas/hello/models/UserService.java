package com.elquineas.hello.models;

import java.util.List;

import org.springframework.stereotype.Service;

public interface UserService {

	public List<String> selectAll();
	public String findByName(String name);
}
