package com.elquineas.address.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.elquineas.address.model.AddrDto;

public interface AddrDao {
	
	@Select("SELECT * FROM tbl_address ORDER BY a_id")
	public List<AddrDto> selectAll();
	
	@Select("SELECT * FROM tbl_address WHERE a_id = #{id}")
	public AddrDto findById(String id);
	
	public List<AddrDto> findByName(String name);

	public int insert(AddrDto addrDto);

	public int update(AddrDto addrDto);

	public int delete(String id);
}
