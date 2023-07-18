package com.callor.bbs.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.springframework.web.bind.annotation.ModelAttribute;


/*
 * 날짜클래스
 * Java에서는 전통적으로 Date, Calendar 와 같은 날짜(시간) 관련
 * 클래스를 가지고 있다. 이 클래스들은 날짜 값에서 여러가지 이슈들이 많이 발견되었다.
 * 또한 Java가 업그레이드 되는 동안에 날짜와 관련된 여러가지 문제를 해결하지 못하는 단점이 있었다.
 * Java 1.8 이후에 LocalDate, LocalTime, LocalDateTime 이라는 새로운 날짜 시간관련 클래스가 새롭게 만들어졌다.
 * 현재 최신의 Java에서는 가급적 Local** class를 사용하여 날짜 관련 문제를 해결하도록 권장하고있다.
 * 
 * DB 와 연동되는 프로젝트에서 날짜 시간 관련된 데이터를 취급하는데 있어서
 * Java 와 DB 서버간에 데이터 교환에 문제를 일으키기도 한다.
 */
public class BBsAttribute {
	
//	@ModelAttribute("BBS")
//	public BBsDto getBBsDto() {
//		BBsDto bbsDto = new BBsDto();
//		
//		Date date = new Date(System.currentTimeMillis());
//		Calendar calendar = Calendar.getInstance();
//		
//		// 날짜 시간 
//		LocalDateTime localDataTime = LocalDateTime.now();
//		
//		// 날짜를 문자열로 변환
//		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		// 시간을 문자열로 변환
//		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//		
//		String strDate = localDataTime.format(dateFormatter);
//		String strTime = localDataTime.format(timeFormatter);
//		
//		bbsDto.setB_date(strDate);
//		bbsDto.setB_time(strTime);
//	 	return bbsDto;
//	}
}
