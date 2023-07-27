package com.callor.rent.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.rent.config.QualifierConfig;
import com.callor.rent.dao.BookDao;
import com.callor.rent.models.BookDto;
import com.callor.rent.models.PageDto;
import com.callor.rent.service.BookService;

@Service(QualifierConfig.SERVICE.BOOK_V1)
public class BookServiceImplV1 implements BookService{
	
	protected final BookDao bookDao;
	public BookServiceImplV1(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@Autowired
	public void create_table() {
		try {
			bookDao.create_book_table(null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<BookDto> selectAll() {
		// TODO Auto-generated method stub
		return bookDao.selectAll();
	}

	@Override
	public int insert(BookDto bookDto) {
		return bookDao.insert(bookDto);
	}

	@Override
	public BookDto findById(String bcode) {
		return bookDao.findById(bcode);
	}

	@Override
	public int update(BookDto bookDto) {
		// TODO Auto-generated method stub
		return bookDao.update(bookDto);
	}

	@Override
	public List<BookDto> findByBName(String bname) {
		return bookDao.findByBName(bname.trim());
	}

	@Override
	public List<BookDto> selectPage(String page) {
		try {
			int intPageNum = Integer.valueOf(page);
			intPageNum = --intPageNum * 10;
			int intLimit = 10;
			return bookDao.selectPage(intLimit, intPageNum);
		} catch (Exception e) {
			return null;
		}
	}

	
	
	// 오라클 mysql 같이 사용가능
//	@Override
//	public void selectPage(String page, Model model) {
//		List<BookDto> books = bookDao.selectAll();
//		int totalCount = books.size(); 
//		int intPageNum = Integer.valueOf(page);
//		
//		PageDto pageDto = PageDto.builder()
//								 .pageNum(intPageNum)
//								 .totalCount(totalCount)
//								 .build();
//		
//		List<BookDto> pageBooks = new ArrayList<>();
//		for(int index = pageDto.getOffSetNum() ; index < pageDto.getLimitCount() + pageDto.getOffSetNum(); index++) {
//			pageBooks.add(books.get(index));
//		}
//		
//		model.addAttribute("BOOKS",pageBooks);
//		model.addAttribute("PAGINATION",pageDto);
//	}
	
	@Override
	public void selectPage(String page, Model model) {
		//List<BookDto> books = bookDao.selectAll();
		
		int totalCount = bookDao.selectCount();
		int intPageNum = Integer.valueOf(page);
		
		PageDto pageDto = PageDto.builder()
								 .pageNum(intPageNum)
								 .totalCount(totalCount)
								 .build();
		
		List<BookDto> books = bookDao.selectPage(pageDto.getLimitCount(), pageDto.getOffSetNum());
		model.addAttribute("BOOKS",books);
		model.addAttribute("PAGINATION",pageDto);
	}
	
	@Override
	public void selectPage(String page, Model model, String search) {
		String[] searchs = search.split(" ");
		// 배열을 리스트로 바꾸는 방법
		List<String> searchList = Arrays.asList(searchs);
		int totalCount = bookDao.selectSearchCount(searchList);
		int intPageNum = Integer.valueOf(page);
		
		PageDto pageDto = PageDto.builder()
								 .pageNum(intPageNum)
								 .totalCount(totalCount)
								 .build();
		
		List<BookDto> books = bookDao.selectSearchPage(pageDto.getLimitCount(), pageDto.getOffSetNum(), searchList);
		model.addAttribute("BOOKS",books);
		model.addAttribute("PAGINATION",pageDto);
	}
	

}
