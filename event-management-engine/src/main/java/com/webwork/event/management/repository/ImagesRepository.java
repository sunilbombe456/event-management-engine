package com.webwork.event.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webwork.event.management.entity.Images;

public interface ImagesRepository extends MongoRepository<Images, String> {

	void deleteByName(String fileName);

}
