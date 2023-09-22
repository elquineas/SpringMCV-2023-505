package com.callor.file.service.impl;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.file.model.FileDto;
import com.callor.file.service.FileService;

@Service
public class FileServiceImplV1 implements FileService{

	protected final String fileUpPath;
	public FileServiceImplV1() {
		this.fileUpPath = "/app/upload";
	}

	@Override
	public String fileup(MultipartFile file) throws Exception {
		if(file.getOriginalFilename().isEmpty()) {
			return null;
		}
		File path = new File(fileUpPath);
		if(!path.exists()) {
			path.mkdirs();
		}
		
		String fileName = file.getOriginalFilename();
		String uuid = UUID.randomUUID().toString();
		
		fileName = String.format("%s-%s", uuid, fileName);
		
		File uploadFile = new File(fileUpPath, fileName);
		// file 에 담긴 파일을 uploafFile 서버에 전송
		file.transferTo(uploadFile);
		
		// 새로 만든 파일네임을 리턴
		return fileName;
	}

	@Override
	public List<FileDto> filesUp(MultipartHttpServletRequest files) throws Exception {
		return null;
	}

	@Override
	public String delete(String fileName) {
		if(fileName == null || fileName.isBlank()) {
			return null;
		}
		
		File delFile = new File(fileUpPath, fileName);
		if(delFile.exists()){
			if(delFile.delete()) {
				return "ok";
			}
		}else {
			bbsDao.update(bbsDao);
		}
		
		return null;
	}

}
