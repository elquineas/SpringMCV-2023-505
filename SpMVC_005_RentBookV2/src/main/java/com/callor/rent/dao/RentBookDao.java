package com.callor.rent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.rent.models.RentBookDto;
import com.callor.rent.models.RentBookVO;

public interface RentBookDao {
	
//	@Select(" SELECT * FROM tbl_rent_book ORDER BY rent_seq ")
	@Select("  SELECT * FROM tbl_rent_book "
			+ "   LEFT JOIN tbl_members ON RENT_MCODE = M_CODE "
			+ "   LEFT JOIN tbl_books ON RENT_BCODE = B_CODE "
			+ "  ORDER BY rent_seq ")
	public List<RentBookVO> selectAll();
	@Select(" SELECT * FROM tbl_rent_book WHERE rent_seq = #{rent_seq} ")
	public RentBookDto findById(long id);

	@Select(" SELECT * FROM tbl_rent_book WHERE rent_bcode = #{bcode} ORDER BY rent_bcode ")
	public List<RentBookDto> findByBCode(String bcode);
	@Select(" SELECT * FROM tbl_rent_book WHERE rent_mcode = #{mcode} ORDER BY rent_mcode ")
	public List<RentBookDto> findByMCode(String mcode);
	
	public int insert(RentBookVO rentBookVO);
	public int update(RentBookDto rDto);
	
	public void create_rent_table(String dumy);
}
