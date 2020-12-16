package com.webwork.event.management.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webwork.event.management.entity.VenueBooking;

public interface VenueBookingRepository extends MongoRepository<VenueBooking, String> {

	VenueBooking findByVenueIdAndDate(String venueId, Date date);

}
