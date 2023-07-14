package com.callor.bbs.service.impl;

import java.io.File;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.bbs.config.QualifierConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.FILE_V2)
public class FileServiceImplV2 extends FileServiceImplV1 {

	protected final String windowsPath;
	protected final String winPath;
	protected final String macHome;
	protected final String macPath;
	public FileServiceImplV2(ResourceLoader resource, String windowsPath, String winPath, String macPath, String macHome) {
		super(resource);
		this.windowsPath = windowsPath;
		this.winPath = winPath;
		this.macHome = macHome;
		this.macPath = macPath;
	}
	

	@Override
	public String fileUp(MultipartFile file) throws Exception {
		log.debug("win Path : {}",winPath);
		log.debug("mac Path : {}",macPath);
		
//		String fileUpPath = winPath;
//		File path = new File(macHome);
//		if(path.exists()) {
//			fileUpPath = macHome + macPath;
//		}
		String fileUpPath = macHome + macPath;
		File path = new File(windowsPath);
		if(path.exists()) {
			fileUpPath = winPath;
		}
		
		log.debug("Up folder : {}",fileUpPath);
		
		path = new File(fileUpPath);
		if(!path.exists()) {
			path.mkdirs();
		}
		
		//실제 업로드될 파일이름
		String fileName = file.getOriginalFilename();
		
		//0000-0000-0000
		String strUUID = UUID.randomUUID().toString();

		fileName = String.format("%s-%s",strUUID, fileName);
		File upLoadFile = new File(fileUpPath, fileName);
		file.transferTo(upLoadFile);
		return fileName;
	}
}
