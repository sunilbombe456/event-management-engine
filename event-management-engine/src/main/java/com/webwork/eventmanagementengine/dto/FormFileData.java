package com.webwork.eventmanagementengine.dto;

import org.springframework.web.multipart.MultipartFile;

public class FormFileData {

	private String name;

	private String url;

	private MultipartFile file;

	public FormFileData() {
	}

	public FormFileData(String name, String url, MultipartFile file) {
		this.name = name;
		this.url = url;
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "FormFileData [name=" + name + ", url=" + url + ", file=" + file + "]";
	}

}
