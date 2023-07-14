package com.elquineas.car.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.elquineas.car.models.CarDto;

public interface CarDao {
	
	@Select("SELECT * FROM tbl_car ORDER BY c_seq DESC LIMIT 10 ")
	public List<CarDto> selectList();

	@Select("SELECT COUNT(*) FROM tbl_car WHERE c_eDate is null ORDER BY c_seq DESC LIMIT 1 ")
	public int lastSelectCheck();
	@Select("SELECT * FROM tbl_car WHERE c_eDate is null ORDER BY c_seq DESC LIMIT 1 ")
	public CarDto lastSelect();
	
	public int insertDrive(CarDto cDto);

	public int updateDrive(CarDto cDto);
}
