package com.callor.bbs.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.bbs.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service()
public class FileServiceImplV1 implements FileService {

	protected final ResourceLoader resourceLoader;
	protected final String filepath;
	
	public FileServiceImplV1(ResourceLoader resource) {
		this.resourceLoader = resource;
		this.filepath = "/files";
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {
		
		Resource res = resourceLoader.getResource(filepath);
		String orginalFileName = file.getOriginalFilename();
		String savePath = res.getURI().getPath();
		
		
		File upLoadFile = new File(savePath, orginalFileName);
		
		log.debug(upLoadFile.getAbsolutePath());
		
		file.transferTo(upLoadFile);
		
		return orginalFileName;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest files) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
