package com.callor.car.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.car.model.UserDto;
import com.callor.car.persistance.UserDao;
import com.callor.car.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImplV1 implements UserService {
	protected final UserDao userDao;

	public UserServiceImplV1(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void create_table() {
		try {
			userDao.create_user_table();
		} catch (Exception e) {
		}
	}

	// 테이블에 유저가 있는가
	@Override
	public int join(UserDto userDto) {
		int userCount = userDao.userCount();
		if (userCount > 0) {
			userDto.setU_role("USER");
		} else {
			userDto.setU_role("ADMIN");
		}
		return userDao.insert(userDto);
	}

	// 로그인을 했는데
	@Override
	public UserDto login(UserDto userDto) throws Exception {
		log.debug("로그인확인 : {}", userDto);

		if (userDto.getUsername().isBlank()) {
			throw new Exception("USER_EMPTY");
		}else if (userDto.getPassword().isBlank()) {
			throw new Exception("PASSWORD_EMPTY");
		}

		UserDto resultDto = userDao.findById(userDto.getUsername());
		if (resultDto == null) {
			// username 이 없는경우
			// throw : 나를 호출한 곳으로 Exception 을 되돌린다
			throw new Exception("USERNAME");
		} else if (resultDto != null && !userDto.getPassword().equals(resultDto.getPassword())) {
			// username 이 있는데 비번이 다른경우
			throw new Exception("PASSWORD");
		}
		return resultDto;
	}

}
