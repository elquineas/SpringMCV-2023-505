package com.elquineas.bbs;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elquineas.bbs.dao.BBsDao;
import com.elquineas.bbs.models.BBsDto;

import lombok.extern.log4j.Log4j;

@Controller
public class BBsController {

	private final BBsDao bbsDao;
	public BBsController(BBsDao bbsDao) {
		this.bbsDao = bbsDao;
	}
	


	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String home(String seq, Model model) {
		System.out.println("@@@@@@@@@@@@@ : " + seq);
		BBsDto bDto = bbsDao.findDetail(seq);
		model.addAttribute("BBS",bDto);
		model.addAttribute("BODY","DETAIL");
		return "home";
	}
	
}
