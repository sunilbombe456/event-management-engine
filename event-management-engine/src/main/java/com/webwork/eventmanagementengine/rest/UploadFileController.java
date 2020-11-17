package com.webwork.eventmanagementengine.rest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.webwork.eventmanagementengine.dto.ResponseMessage;
import com.webwork.eventmanagementengine.service.FileStorageService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/public/event/1/0")
public class UploadFileController {
	@Autowired
	FileStorageService storageService;
	
	private final Path root = Paths.get("uploads/images");

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFiles(@RequestParam("file") MultipartFile file) {
		
		ResponseMessage message = new ResponseMessage();
		
		if(null != file) {
			message.setMessage("File uploaded successfully..>");
			storageService.save(file);
			
		}else {
			message.setMessage("File NOT  uploaded successfully..>");
		}
		
		return new ResponseEntity<>(message, HttpStatus.OK);

	}
	
	@PostMapping("/upload/multiple")
	public ResponseEntity<ResponseMessage> uploadMultipleFiles(@RequestParam("file") List<MultipartFile> file) {
		
		ResponseMessage message = new ResponseMessage();
		int uploadCount= 0;
		
		if(!file.isEmpty()) {
			
			for(MultipartFile f: file) {
				storageService.save(f);
				uploadCount++;
			}
			
			message.setMessage(uploadCount+" Files uploaded successfully..>");
			
		}else {
			message.setMessage("File NOT  uploaded successfully..>");
		}
		
		
		
		return new ResponseEntity<>(message, HttpStatus.OK);

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
//	@GetMapping("/load/{fileName}")
//	public Resource loadFile(@PathVariable String fileName) {
//		return storageService.load(fileName);
//	}
	
	@GetMapping("/load/all")
	public Stream<Path> loadFile() {
		return storageService.loadAll();
	}
	
	@GetMapping("/delete/all")
	public void deleteFile() {
		storageService.deleteAll();
	}
	
	@RequestMapping(value="/load/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] load(@PathVariable String fileName) throws IOException {
		File file = new File(this.root.toString()+"/"+ fileName);
		System.out.println("\n==>"+this.root.toString()+"/"+ fileName);
		return Files.readAllBytes(file.toPath());
	}

}
