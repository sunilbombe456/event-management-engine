package com.webwork.event.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webwork.event.management.entity.Venue;

public interface VenueRepository extends MongoRepository<Venue, String> {

	Venue findByName(String name);

}
