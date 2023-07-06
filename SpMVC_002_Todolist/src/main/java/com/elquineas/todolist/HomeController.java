package com.elquineas.todolist;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elquineas.todolist.models.TodoDto;
import com.elquineas.todolist.service.TodoService;

@Controller
public class HomeController {
	
	protected final TodoService todoService;
	
	public HomeController(TodoService todoService){
		this.todoService = todoService;
		
	}
	
	@ModelAttribute
	public TodoDto tDto() {
		TodoDto dto = new TodoDto();
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		dto.setTo_sdate(dateFormat.format(date));
		dto.setTo_stime(timeFormat.format(date));
		return dto;
	}
	/*
	 * 매개변수에 Dto를 사용하고 @ModelAttribut 를 부착해 두면
	 * Dto 변수가 null 값이면, 어딘가에 이 Dto를 생성하는 method가 있는 찾는다
	 * 이때 method 에도 @ModelAttribute 가 있어야 한다.
	 * 
	 * @ModelAttribute 가 있는 method 를 찾으면 해당 method 를 실행하여
	 * return 값을 매개변수에 setting 하여 전달한다.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@ModelAttribute TodoDto dto, Model model) {
		
		if(dto.getTo_content() != null) {
			todoService.insert(dto);
		}
		List<TodoDto> todoList = todoService.selectAll();
		
		model.addAttribute("TODO",dto);
		model.addAttribute("TODOS",todoList);
		
		return "home";

	}
	
}
