package com.callor.bbs.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.bbs.config.QualifierConfig;
import com.callor.bbs.dao.BBsDao;
import com.callor.bbs.dao.FileDao;
import com.callor.bbs.models.BBsDto;
import com.callor.bbs.models.FileDto;
import com.callor.bbs.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private final FileService fileService;
	
	private final BBsDao bbsDao;
	private final FileDao fileDao;
	
	public HomeController(@Qualifier(QualifierConfig.SERVICE.FILE_V2)FileService fileService, BBsDao bbsDao, FileDao fileDao) {//
//		super();
		this.fileService = fileService;
		this.bbsDao = bbsDao;
		this.fileDao = fileDao;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
//		List<BBsDto> bbsList = bbsDao.selectAll();
		List<BBsDto> bbsList = bbsDao.findUserSelectLimit();
		model.addAttribute("BBS_LIST", bbsList);
		return "home";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(String seq, @ModelAttribute("BBS") BBsDto bbsDto, Model model) {
		
		bbsDto = bbsDao.findById(seq);
		List<FileDto> files = fileDao.findByBSeq(bbsDto.getB_seq());
		model.addAttribute("BBS",bbsDto);
		model.addAttribute("FILES",files);
		return "detail";
		
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(@ModelAttribute("BBS") BBsDto bbsDto, Model model) {
		
//		model.addAttribute("BBS",bbsDto);
		return "input";
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(BBsDto bbsDto, @RequestParam(value="b_file") MultipartFile b_file, MultipartHttpServletRequest b_images, Model model) {
//		String b_file
		
		log.debug("사용자 이름 : {}", bbsDto.getB_username());
		log.debug(b_file.getOriginalFilename());
		
		String fileName = null;
		try {
			log.debug("확인 : {}",b_file.getOriginalFilename().isEmpty());
			if(!b_file.getOriginalFilename().isEmpty()) {
				fileName = fileService.fileUp(b_file);
				bbsDto.setB_image(fileName);
			}

			int result = bbsDao.insert(bbsDto);
			log.debug("새로 생성된 PK : {}", bbsDto.getB_seq());
			
			// getFiles.size()
			// 이미지를 리스트로 변환하고 개수 새기
			
			// getFile.getSize()
			// 업로드한 파일의 개수가 담긴 변수값 참조
			if(b_images.getFiles("b_images").size() > 0) {
//				fileService.filesUp(b_images);
				List<FileDto> files = fileService.filesUp(b_images);
				fileDao.insert(files, bbsDto.getB_seq());
			}

			
			return "redirect:/";
		} catch (Exception e) {
//			e.printStackTrace();
			log.debug("파일을 업로드 할수 없음 오류 발생!");
			return "redirect:/insert?error=FILE_UP_ERROR";
		}
		
//		model.addAttribute("FILE_NAME", fileName);
//		return "input";
	}
	
	
	@RequestMapping(value="/image_delete", method=RequestMethod.GET)
	public String image_delete(String seq) {
		long seqNum = Long.valueOf(seq);
		FileDto fileDto = fileDao.findByid(seqNum);
		fileService.delete(fileDto.getI_uploadName());
		int result = fileDao.delete(seqNum);
		
		return "redirect:/detail?seq="+fileDto.getI_bseq();
	}
	
	
	
	
	@ModelAttribute("BBS")
	public BBsDto getBBsDto() {
		BBsDto bbsDto = new BBsDto();
		
		Date date = new Date(System.currentTimeMillis());
		Calendar calendar = Calendar.getInstance();
		
		// 날짜 시간 
		LocalDateTime localDataTime = LocalDateTime.now();
		
		// 날짜를 문자열로 변환
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// 시간을 문자열로 변환
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		String strDate = localDataTime.format(dateFormatter);
		String strTime = localDataTime.format(timeFormatter);
		
		bbsDto.setB_date(strDate);
		bbsDto.setB_time(strTime);
		bbsDto.setB_username("elquineas");
	 	return bbsDto;
	}
	
}
