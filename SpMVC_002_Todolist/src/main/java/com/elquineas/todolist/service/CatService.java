package com.elquineas.todolist.service;

import com.elquineas.todolist.models.CategoryDto;

public interface CatService extends TodoGeneric<CategoryDto, String>{
	public void printCategory();
}
