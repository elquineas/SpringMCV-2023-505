package com.elquineas.hello.models.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.elquineas.hello.models.UserService;

@Service
public class UserServiceImplV1 implements UserService{
	
	protected List<String> strList;

	@Override
	public List<String> selectAll() {
		strList = new ArrayList<String>();
		strList.add("홍길동");
		strList.add("성춘향");
		strList.add("이몽룡");
		
		return null;
	}

	@Override
	public String findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
