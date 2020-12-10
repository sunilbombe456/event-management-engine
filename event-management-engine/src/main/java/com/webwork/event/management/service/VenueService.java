package com.webwork.event.management.service;

import java.util.List;

import com.webwork.event.management.dto.SearchDTO;
import com.webwork.event.management.entity.Venue;

public interface VenueService {

	Venue save(Venue venue);

	boolean delete(String venueId);

	List<Venue> getAll();

	Venue get(String id);

	List<Venue> saveAll(List<Venue> venueList);

	List<Venue> searchVenue(SearchDTO searchDto);

}
