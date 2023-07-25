package com.callor.rent.service;

import java.util.List;

import com.callor.rent.models.MemberDto;

public interface MemberService  {
	
	public List<MemberDto> selectAll();

	public int insert(MemberDto mDto) throws Exception;
	
	public String getNewCode();

	public MemberDto findById(String mcode);

	public int update(MemberDto mDto) throws Exception;

}
