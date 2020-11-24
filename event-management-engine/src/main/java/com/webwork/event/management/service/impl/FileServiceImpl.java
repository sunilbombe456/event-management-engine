package com.webwork.event.management.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webwork.event.management.service.FileService;
import com.webwork.event.management.util.FileStorageUtils;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileStorageUtils fileStorage;

	@Override
	public byte[] loadImage(String fileName) throws IOException {
		// TODO Auto-generated method stub
		return fileStorage.loadImage(fileName);
	}

}
