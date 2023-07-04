package com.elquineas.address.service;

import java.util.List;

import com.elquineas.address.model.AddrDto;

public interface AddrService {
	public List<AddrDto> selectAll();
	public AddrDto findById(String id);
	public String idCheck(String id);
	public List<AddrDto> findByName(String name);
	public List<AddrDto> findByTel(String tel);
	
	public int insert(AddrDto addrDto);
	public int update(AddrDto addrDto);
	public int delete(String id);
	
}
