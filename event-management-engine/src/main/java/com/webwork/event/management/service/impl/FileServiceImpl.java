package com.webwork.event.management.service.impl;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.webwork.event.management.entity.Images;
import com.webwork.event.management.repository.ImagesRepository;
import com.webwork.event.management.service.FileService;
import com.webwork.event.management.util.FileStorageUtils;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileStorageUtils fileStorage;
	
	@Autowired
	private ImagesRepository imageRepo;
	
	@Override
	public void init() {
		 fileStorage.init();
	}

	@Override
	public void init(Path root) {
		 fileStorage.init(root);
	}

	@Override
	public byte[] loadImage(String fileName) throws IOException {
		// TODO Auto-generated method stub
		return fileStorage.loadImage(fileName);
	}
	
	@Override
	public String loadEncodedImage(String fileName) throws NoSuchFileException {
				return fileStorage.loadImageString(fileName);
	}

	
	@Override
	public String save(MultipartFile file) {
		Images image = new Images(file.getOriginalFilename());
		fileStorage.save(file);
		image = imageRepo.save(image);
		return image.getEncodedUrls();
	}

	

}
