package com.elquineas.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.elquineas.bbs.models.BBsDto;

public interface BBsDao {
	
	@Select(" SELECT * FROM tbl_bbs ORDER BY b_date DESC, b_time DESC ")
	public List<BBsDto> selectAll();
	
	public List<BBsDto> findUserSelectLimit();
	public BBsDto findDetail(String b_seq);
}
