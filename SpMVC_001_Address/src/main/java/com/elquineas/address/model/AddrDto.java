package com.elquineas.address.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddrDto {
	private String a_id;
	private String a_name;
	private String a_tel;
	private String a_addr;
}
