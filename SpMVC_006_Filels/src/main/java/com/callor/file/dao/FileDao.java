package com.callor.file.dao;

import java.util.List;

import com.callor.file.model.BBsDto;
import com.callor.file.model.FileDto;

public interface FileDao extends GenericDao<FileDto, Long> {
	
	public List<FileDto> findByBSeq(Long seq);
	
	public void create_file_table(String dumy);
}
