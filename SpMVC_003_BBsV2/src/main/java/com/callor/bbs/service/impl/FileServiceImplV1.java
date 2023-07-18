package com.callor.bbs.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.bbs.models.FileDto;
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
	public List<FileDto> filesUp(MultipartHttpServletRequest files) throws Exception {
		
		/*
		 * 멀티파일을 각 파일로 분리하여 fileUp() 에게 파일을 업로드 하도록 요청하고, 
		 * 원본이름과 변경된 이름을 받아서 returnFiles 를 만들기
		 */
		List<MultipartFile> fileList = files.getFiles("b_images");
		List<FileDto> returnFiles = new ArrayList<FileDto>();
		for(MultipartFile file : fileList) {
			FileDto fileDto = new FileDto();
			fileDto.setI_originalName(file.getOriginalFilename());
			fileDto.setI_uploadName(this.fileUp(file));
			returnFiles.add(fileDto);
		}
		return returnFiles;
	}
	@Override
	public String delete(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
