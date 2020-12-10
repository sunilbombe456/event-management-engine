package com.webwork.event.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webwork.event.management.dto.SearchDTO;
import com.webwork.event.management.entity.Venue;
import com.webwork.event.management.exception.DuplicateEntityException;
import com.webwork.event.management.exception.EntityNotFoundException;
import com.webwork.event.management.repository.VenueRepository;
import com.webwork.event.management.service.VenueService;

@Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	private VenueRepository venueRepo;

	@Override
	@Transactional
	public Venue save(Venue venue) {
		// TODO Auto-generated method stub
		if (null != venue.getId()) {
			return venueRepo.save(venue);
		} else if (null != venueRepo.findByName(venue.getName())) {
			throw new DuplicateEntityException("Venue already Exists.!");
		}
		return venueRepo.save(venue);

	}

	@Override
	@Transactional
	public List<Venue> saveAll(List<Venue> venueList) {
		List<Venue> result = new ArrayList<>();
		for(Venue venue : venueList) {
			if(null!=venue.getId()) {
				result.add(venueRepo.save(venue));
			}else {
				if(null!=venueRepo.findByName(venue.getName())) {
					throw new DuplicateEntityException("Already Exists");
				}
				result.add(venue);
			}
		}
		return result;
	}

	@Override
	@Transactional
	public boolean delete(String venueId) {
		// TODO Auto-generated method stub
		Venue venue = null;
		Optional<Venue> result = venueRepo.findById(venueId);
		if (!result.isPresent()) {
			throw new EntityNotFoundException("Entity of Id " + venueId + " not available");
		} else {
			venue = result.get();
			venueRepo.delete(venue);
			return true;
		}
	}

	@Override
	@Transactional
	public List<Venue> getAll() {
		List<Venue> venueList = venueRepo.findAll();
		if (venueList == null) {
			throw new EntityNotFoundException("Venue List not found..!");
		}
		return venueList;
	}

	@Override
	@Transactional
	public Venue get(String id) {
		Optional<Venue> result = venueRepo.findById(id);
		if (!result.isPresent()) {
			throw new EntityNotFoundException("Venue Not Found..!");
		} else {
			return result.get();
		}
	}

	@Override
	public List<Venue> searchVenue(SearchDTO searchDto) {
		List<Venue> venueList = venueRepo.findByPeopleCapacity(searchDto.getPeopleCount());
		return null;
	}

}
