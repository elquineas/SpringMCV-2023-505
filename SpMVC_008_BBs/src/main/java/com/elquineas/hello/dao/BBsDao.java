package com.elquineas.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.elquineas.hello.models.BBsDto;

public interface BBsDao {

	@Select("SELECT * FROM tbl_bbs")
	public List<BBsDto> selectAll();
	
}
