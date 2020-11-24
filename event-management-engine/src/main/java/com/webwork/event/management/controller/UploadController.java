package com.webwork.event.management.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.webwork.event.management.dto.ResponseMessage;
import com.webwork.event.management.entity.Images;
import com.webwork.event.management.repository.ImagesRepository;
import com.webwork.event.management.service.FileStorageService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/private/event/1/0")
public class UploadController {
	@Autowired
	FileStorageService storageService;

	@Autowired
	private ImagesRepository imageRepo;

	private final Path root = Paths.get("uploads");

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFiles(@RequestParam("file") MultipartFile file) {
		if (!Files.exists(root)) {
			storageService.init(root);
		}

		Images image = new Images();
		ResponseMessage message = new ResponseMessage();

		if (null != file) {
			message.setMessage("File uploaded successfully..>");
			image.setName(file.getOriginalFilename());
			storageService.save(file);
			imageRepo.save(image);

		} else {
			message.setMessage("File NOT  uploaded successfully..>");
		}

		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	@PostMapping("/upload/multiple")
	public ResponseEntity<?> uploadMultipleFiles(@RequestParam("file") List<MultipartFile> file) {

		ResponseMessage message = new ResponseMessage();
	
		List<Images> image = new ArrayList<>();
		
		int uploadCount = 0;
		if (!file.isEmpty()) {

			for (MultipartFile f : file) {
				image.add(new Images(f.getOriginalFilename()));
				storageService.save(f);
				uploadCount++;
			}
		} else {
			message.setMessage("File NOT  uploaded successfully..>");
		}
		image =imageRepo.saveAll(image);
		return new ResponseEntity<>(image, HttpStatus.OK);

	}

//	@PostMapping(path="/upload",consumes="multipart/form-data")
//	public ResponseEntity<ResponseMessage> uploadFiles(@RequestBody FormFileData form) {
//		ResponseMessage message = new ResponseMessage();
//
//		if (null != form.getFile()) {
//			message.setMessage("File uploaded successfully..>");
//
//		} else {
//			message.setMessage("File NOT  uploaded successfully..>");
//		}
//
//		return new ResponseEntity<>(message, HttpStatus.OK);
//	}
//	
	@GetMapping("/load/{fileName}")
	public Resource loadFile(@PathVariable String fileName) {
		return storageService.load(fileName);
	}

//	@GetMapping("/load/all")
//	public Stream<Path> loadFile() {
//		return storageService.loadAll();
//	}
	
	@GetMapping("/load/all")
	public List<Images> loadFile() {
		return imageRepo.findAll();
	}

	@GetMapping("/delete/all")
	public void deleteFile() {
		storageService.deleteAll();
	}

	@DeleteMapping("/delete/{fileName}")
	public void deleteFile(@PathVariable String fileName) {
		imageRepo.deleteByName(fileName);
		storageService.delete(fileName);
	}

}
