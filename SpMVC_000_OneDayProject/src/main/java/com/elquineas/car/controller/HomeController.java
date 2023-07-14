package com.elquineas.car.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elquineas.car.dao.CarDao;
import com.elquineas.car.models.CarDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private final CarDao cDao;
	public HomeController(CarDao cDao) {
		super();
		this.cDao = cDao;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<CarDto> cList = cDao.selectList();
		CarDto cDto = null;
		int count = cDao.lastSelectCheck();
		if(count > 0) {
			cDto = cDao.lastSelect();
			log.debug("UPDATE DATA : {}",cDto);
			model.addAttribute("CAR", "UPDATE");
		}else {
			model.addAttribute("CAR", "INSERT");
		}
		model.addAttribute("CAR_UPDATE", cDto);
		model.addAttribute("CAR_LIST", cList);
		return "home";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(CarDto cDto, Model model) {
		log.debug("SAVE DATA : {}",cDto);
		int result = cDao.insertDrive(cDto);
		return "redirect:/";
	}
	

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(CarDto cDto, Model model) {
		log.debug("SAVE DATA : {}",cDto);
		int result = cDao.updateDrive(cDto);
		return "redirect:/";
	}
}
