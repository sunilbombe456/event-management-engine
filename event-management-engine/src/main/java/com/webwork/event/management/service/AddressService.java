package com.webwork.event.management.service;

import java.util.List;

import com.webwork.event.management.entity.Country;
import com.webwork.event.management.entity.States;

public interface AddressService {
	List<Country> findAll();
	
	List<States> findByCountryId(int countryId);
}
