package com.callor.rent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.rent.config.QualifierConfig;
import com.callor.rent.dao.MemberDao;
import com.callor.rent.models.MemberDto;
import com.callor.rent.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.MEMBER_V1)
public class MemberServiceImplV1 implements MemberService{
	
	protected final MemberDao mDao;
	public MemberServiceImplV1(MemberDao mDao) {
		this.mDao = mDao;
	}

	@Override
	public List<MemberDto> selectAll(){
		List<MemberDto> mList = mDao.selectAll();
		return mList;
	}

	@Autowired
	public void create_table() {
		try {
			mDao.create_member_table(null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public int insert(MemberDto mDto) throws Exception {
		String tel = mDto.getM_tel().trim();
		String name = mDto.getM_name().trim();
				
		MemberDto resultDto = mDao.findNameAndTel(name, tel);
				
		if(resultDto != null) {
			throw new Exception("NAME_TEL");
		}
		
		String mCode = this.getNewCode();
		mDto.setM_code(mCode);
		log.debug("(서비스)회원정보 확인 : {}",mDto);
		return mDao.insert(mDto);
	}

	@Override
	public MemberDto findById(String mcode) {
		log.debug("(서비스)회원정보 코드 확인 : {}",mcode);
		MemberDto mDto = mDao.fineById(mcode);
		return mDto;
	}
	
	@Override
	public int update(MemberDto mDto) throws Exception {
		String tel = mDto.getM_tel().trim();
		String name = mDto.getM_name().trim();
				
		MemberDto resultDto = mDao.findNameAndTel(name, tel);

		if(resultDto != null && !resultDto.getM_code().equals(mDto.getM_code())) {
			throw new Exception("NAME_TEL");
		}
		
		return  mDao.update(mDto);
	}

	@Override
	public List<MemberDto> findByMName(String mName) {
		return mDao.findByName(mName);
	}
	
	
	
	@Override
	public String getNewCode() {
		String mCode = mDao.getMaxMcode();
		String newCode = "000001";
		if(mCode != null) {
			newCode = String.format("%06d", Integer.valueOf(mCode)+1);
		}
		return newCode;
	}

}
