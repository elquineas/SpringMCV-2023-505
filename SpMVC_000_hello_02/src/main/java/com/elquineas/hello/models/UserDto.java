package com.elquineas.hello.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

// Super 생성자
@NoArgsConstructor
// Filed 생성자
@AllArgsConstructor
public class UserDto {
	private String username;
	private String password;
	private String name;
	private String tel;
	private String addr;
	private int age;
	
}
