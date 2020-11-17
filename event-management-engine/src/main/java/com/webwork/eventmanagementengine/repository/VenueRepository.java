package com.webwork.eventmanagementengine.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webwork.eventmanagementengine.entity.Venue;

public interface VenueRepository extends MongoRepository<Venue, String> {

}
