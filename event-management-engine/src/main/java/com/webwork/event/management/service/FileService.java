package com.webwork.event.management.service;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	public void init();
	
	public void init(Path root);

	byte[] loadImage(String fileName) throws IOException;

	public String save(MultipartFile file);

	public String loadEncodedImage(String fileName)throws NoSuchFileException;

}
