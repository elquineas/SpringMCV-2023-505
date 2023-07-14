package com.elquineas.car.models;

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
public class CarDto {
	private long c_seq;//	bigint			PRIMARY KEY,
	private String c_division;//	varchar(10)	NOT NULL	,
	private String c_sDate;//	varchar(10)		NOT NULL,
	private String c_eDate;//	varchar(10)	,
	private String c_sTime;//	varchar(10)		NOT NULL,
	private String c_eTime;//	varchar(10)	,
	private String c_sDistance;//	varchar(10)	NOT NULL,	
	private String c_eDistance;//	varchar(10)	,	
	private String c_place;//	varchar(50)		NOT NULL,
	private String c_cost;//	varchar(10)		
}
