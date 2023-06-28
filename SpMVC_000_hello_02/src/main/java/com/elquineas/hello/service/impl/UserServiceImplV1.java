package com.elquineas.hello.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.elquineas.hello.models.UserDto;
import com.elquineas.hello.service.UserService;

//@Service(value="userService")
@Service
public class UserServiceImplV1 implements UserService{

	@Override
	public List<UserDto> selectAll() {
		List<UserDto> uList = new ArrayList();
		UserDto uDto = new UserDto();
		uDto.setUsername("thiefHong");
		uDto.setPassword("12345678");
		uDto.setName("홍길동");
		uDto.setTel("010-0000-0000");
		uDto.setAddr("광주광역시");
		uDto.setAge(20);
		uList.add(uDto);
		
		uDto = new UserDto();
		uDto.setUsername("mongDragon");
		uDto.setPassword("qwer1234");
		uDto.setName("이몽룡");
		uDto.setTel("010-1111-2222");
		uDto.setAddr("서울특별시");
		uDto.setAge(22);
		uList.add(uDto);
		
		// setter를 사용하여 데이터 추가하기
		uDto = new UserDto();
		uDto.setUsername("springScent");
		uDto.setPassword("q1w2e3r4");
		uDto.setName("성춘향");
		uDto.setTel("010-3333-3333");
		uDto.setAddr("전라북도 남원시");
		uDto.setAge(17);
		uList.add(uDto);
		
		// 필드생성자를 사용하여 데이터 추가
		uDto = new UserDto("thiefrim","11111111","임꺽정","010-444-4444","함경도",20);
		uList.add(uDto);
		
		return uList;
	}

	@Override
	public UserDto findById(String id) {
		return null;
	}

	@Override
	public int input(UserDto dto) {
		return 0;
	}

}
