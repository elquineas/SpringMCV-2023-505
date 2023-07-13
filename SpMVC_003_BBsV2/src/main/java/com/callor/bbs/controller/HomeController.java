package com.callor.bbs.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.bbs.config.QualifierConfig;
import com.callor.bbs.dao.BBsDao;
import com.callor.bbs.models.BBsDto;
import com.callor.bbs.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private final FileService fileService;
	private final BBsDao bbsDao;
	
	public HomeController(@Qualifier(QualifierConfig.SERVICE.FILE_V2)FileService fileService, BBsDao bbsDao) {//
//		super();
		this.fileService = fileService;
		this.bbsDao = bbsDao;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
//		List<BBsDto> bbsList = bbsDao.selectAll();
		List<BBsDto> bbsList = bbsDao.findUserSelectLimit();
		model.addAttribute("BBS_LIST", bbsList);
		return "home";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(String seq,Model model) {
		
		BBsDto bbsDto = bbsDao.findById(seq);
		model.addAttribute("BBS",bbsDto);
		return "detail";
		
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return "input";
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@RequestParam(value="b_username") String username, @RequestParam(value="b_file") MultipartFile b_file, Model model) {
//		String b_file
		log.debug("사용자 이름 : {}", username);
		log.debug(b_file.getOriginalFilename());
		
		String fileName = "";
		try {
			fileName = fileService.fileUp(b_file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("FILE_NAME", fileName);
		return "input";
	}
	
	
	
}
