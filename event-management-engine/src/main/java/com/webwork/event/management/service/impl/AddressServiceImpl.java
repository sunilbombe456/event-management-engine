package com.webwork.event.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webwork.event.management.entity.Country;
import com.webwork.event.management.entity.States;
import com.webwork.event.management.repository.CountryRepository;
import com.webwork.event.management.repository.StatesRepository;
import com.webwork.event.management.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private CountryRepository countryRepo;
	
	private StatesRepository stateRepo;

	@Override
	public List<Country> findAll() {
		return countryRepo.findAll();
	}

	@Override
	public List<States> findByCountryId(int countryId) {
		// TODO Auto-generated method stub
		return stateRepo.findAll();
	}

}
