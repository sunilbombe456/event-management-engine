package com.webwork.event.management.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.webwork.event.management.exception.FileNotFoundException;

@Component
public class FileStorageUtils {

	private final Path root = Paths.get("uploads");

	public void init() {
		// TODO Auto-generated method stub
		try {
			Files.createDirectory(root);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize folder for upload!");
		}

	}

	public void init(Path path) {
		// TODO Auto-generated method stub
		try {
			Files.createDirectory(path);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize folder for upload!");
		}

	}

	public void save(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}

	}

	public Resource load(String filename) {
		// TODO Auto-generated method stub
		try {
			Path file = root.resolve(filename);
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Could not read the file!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		FileSystemUtils.deleteRecursively(root.toFile());
	}

	public void delete(String name) {
		try {
			FileSystemUtils.deleteRecursively(root.resolve(name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Stream<Path> loadAll() {
		// TODO Auto-generated method stub
		try {
			return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
		} catch (IOException e) {
			throw new RuntimeException("Could not load the files!");
		}
	}

	public byte[] loadImage(String fileName) throws IOException {

		File file = null;
		byte[] loadedFile = null;
		try {
			file = new File(this.root.toString() + "/" + fileName);
			System.out.println("\n==>" + this.root.toString() + "/" + fileName);
			loadedFile = Files.readAllBytes(file.toPath());
		} catch (NoSuchFileException exe) {
			throw new FileNotFoundException("File Resources not Found");
		}
		return loadedFile;
	}

	public String loadImageString(String fileName) throws NoSuchFileException {
		File file = null;
		file = new File(this.root.toString() + "/" + fileName);
		return encodeFileToBase64Binary(file);
	}

	private String encodeFileToBase64Binary(File file) {
		String encodedfile = null;
		try {
			FileInputStream fileInputStreamReader = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fileInputStreamReader.read(bytes);
//			encodedfile = Base64.encodeBase64(bytes).toString();
			encodedfile =  Base64.getEncoder().encodeToString(bytes);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return encodedfile;
	}

}
