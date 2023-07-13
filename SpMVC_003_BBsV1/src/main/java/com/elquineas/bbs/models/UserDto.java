package com.elquineas.bbs.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private String u_username;//	varchar(125)
	private String u_nickanem;//	varchar(125)
	private String u_tel;//	varchar(20)
}
