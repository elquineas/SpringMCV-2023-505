package com.elquineas.todolist.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.elquineas.todolist.dao.TodoDao;
import com.elquineas.todolist.models.TodoDto;
import com.elquineas.todolist.service.TodoService;

@Service
public class TodoServiceImplV1 implements TodoService{

	protected final TodoDao todoDao;
	public TodoServiceImplV1(TodoDao todoDao) {
		this.todoDao = todoDao;
	}

	@Override
	public List<TodoDto> selectAll() {
		return todoDao.selectAll();
	}

	@Override
	public TodoDto fineById(Long id) {
		return null;
	}

	@Override
	public int insert(TodoDto dto) {
		return todoDao.insert(dto);
	}

	@Override
	public int update(TodoDto dto) {
		return 0;
	}

	@Override
	public int delete(Long id) {
		return 0;
	}

}
