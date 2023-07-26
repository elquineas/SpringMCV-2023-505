package com.callor.rent.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.rent.dao.RentBookDao;
import com.callor.rent.models.RentBookDto;
import com.callor.rent.models.RentBookVO;
import com.callor.rent.service.RentBookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RentBookServiceImplV1 implements RentBookService {

	protected final RentBookDao rDao;
	public RentBookServiceImplV1(RentBookDao rDao) {
		this.rDao = rDao;
	}

	@Override
	public List<RentBookVO> selectAll() {
		return rDao.selectAll();
	}

	@Override
	public int insert(RentBookVO rentBookVO) {
		return rDao.insert(rentBookVO);
	}
	
	

}
