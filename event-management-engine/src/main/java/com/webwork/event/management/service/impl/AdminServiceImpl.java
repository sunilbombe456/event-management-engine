package com.webwork.event.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webwork.event.management.entity.Venue;
import com.webwork.event.management.exception.DuplicateEntityException;
import com.webwork.event.management.repository.VenueRepository;
import com.webwork.event.management.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private VenueRepository venueRepo;



}
