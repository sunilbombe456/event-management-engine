package com.webwork.event.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webwork.event.management.entity.Decoration;

public interface DecorationRepository extends MongoRepository<Decoration, String> {

}
