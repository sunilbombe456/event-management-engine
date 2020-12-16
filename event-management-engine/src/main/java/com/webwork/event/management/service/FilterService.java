package com.webwork.event.management.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.webwork.event.management.dto.SearchDTO;
import com.webwork.event.management.entity.Decoration;
import com.webwork.event.management.entity.Venue;

public interface FilterService {
	
	public List<Venue> getFilteredVenue(SearchDTO searchDto) throws ParseException;
	
	public List<Decoration> getFilteredDecoration(SearchDTO searchDto);
	
}
