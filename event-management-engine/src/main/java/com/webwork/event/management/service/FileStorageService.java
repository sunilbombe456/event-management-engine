package com.webwork.event.management.service;

import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
	public void init();

	public void init(Path path);

	public void save(MultipartFile file);

	public Resource load(String filename);

	public Stream<Path> loadAll();

	public void delete(String name);

	public void deleteAll();

}
