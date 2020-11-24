package com.webwork.event.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webwork.event.management.entity.Venue;
import com.webwork.event.management.repository.VenueRepository;
import com.webwork.event.management.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private VenueRepository venueRepo;
	


	@Override
	public Object saveVenue(Venue venue) {
		// TODO Auto-generated method stub
		return venueRepo.save(venue);

	}

}
