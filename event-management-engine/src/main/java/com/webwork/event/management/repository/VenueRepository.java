package com.webwork.event.management.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.webwork.event.management.entity.Venue;

public interface VenueRepository extends MongoRepository<Venue, String> {

	Venue findByName(String name);

	@Query("db.venue.find({peopleCapacity: peopleCount})")
	List<Venue> findByPeopleCapacity(int peopleCount);

}
