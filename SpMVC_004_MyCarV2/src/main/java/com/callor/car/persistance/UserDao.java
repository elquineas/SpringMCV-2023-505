package com.callor.car.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.car.model.CarDto;
import com.callor.car.model.UserDto;

public interface UserDao {
	@Select(" SELECT COUNT(*) FROM tbl_users ")
	public int userCount();
	
	@Select(" SELECT * FROM tbl_users WHERE username = #{username} ")
	public UserDto findById(String username);
	
	public void create_user_table();

	public int insert(UserDto userDto);
	
}
