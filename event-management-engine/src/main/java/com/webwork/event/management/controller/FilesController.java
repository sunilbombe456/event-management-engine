package com.webwork.event.management.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.webwork.event.management.exception.FileNotFoundException;
import com.webwork.event.management.service.FileService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/private/event/1/0/files")
public class FilesController {

	@Autowired
	private FileService fileService;

	private final Path root = Paths.get("uploads");

	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file) {
		List<String> urls = new ArrayList<>();
		if (!Files.exists(root)) {
			fileService.init(root);
		}
		if (null != file) {
			urls.add(fileService.save(file));
		} else {
			throw new FileNotFoundException("file Not Found..!");
		}
		return new ResponseEntity<>(urls, HttpStatus.OK);
	}

	@PostMapping("/upload/multiple")
	public ResponseEntity<?> uploadMultipleFiles(@RequestParam("file") List<MultipartFile> file) {
		List<String> urls = new ArrayList<>();
		int uploadCount = 0;
		if (!file.isEmpty()) {
			for (MultipartFile f : file) {
				urls.add(fileService.save(f));
				uploadCount++;
			}
		} else {
			throw new FileNotFoundException("file Not Found..!");
		}
		return new ResponseEntity<>(urls, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{fileName}")
	public ResponseEntity<?> deleteFile(@PathVariable String fileName) {
		return null;
	}
}
