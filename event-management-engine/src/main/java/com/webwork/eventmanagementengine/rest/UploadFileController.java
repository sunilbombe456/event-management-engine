package com.webwork.eventmanagementengine.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.webwork.eventmanagementengine.dto.ResponseMessage;
import com.webwork.eventmanagementengine.service.FileStorageService;

@RestController
public class UploadFileController {
	@Autowired
	FileStorageService storageService;

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

//	@PostMapping("/upload")
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

}
