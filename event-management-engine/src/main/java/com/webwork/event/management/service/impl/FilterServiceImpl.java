package com.webwork.event.management.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webwork.event.management.dto.SearchDTO;
import com.webwork.event.management.entity.Decoration;
import com.webwork.event.management.entity.Venue;
import com.webwork.event.management.entity.VenueBooking;
import com.webwork.event.management.enums.EventType;
import com.webwork.event.management.enums.LocationType;
import com.webwork.event.management.repository.DecorationRepository;
import com.webwork.event.management.repository.VenueBookingRepository;
import com.webwork.event.management.repository.VenueRepository;
import com.webwork.event.management.service.FilterService;

@Service
public class FilterServiceImpl implements FilterService {

	@Autowired
	private VenueRepository venueRepo;

	@Autowired
	private DecorationRepository decorationRepo;

	@Autowired
	private VenueBookingRepository venueBookingRepo;

	@Override
	public List<Venue> getFilteredVenue(SearchDTO searchDto) throws ParseException {

		List<Venue> venueList = venueRepo.findAll();
		if (null != venueList || !venueList.isEmpty()) {
			venueList = getFilterByEventType(venueList, searchDto.getEventType());

			venueList = getFilterByLocation(venueList, searchDto.getLocation());

			venueList = getFilterByDate(venueList, searchDto.getDate());
		}
		return venueList;
	}

	@Override
	public List<Decoration> getFilteredDecoration(SearchDTO searchDto) {
		return null;
	}

	private List<Venue> getFilterByDate(List<Venue> venueList, Date theDate) throws ParseException {
		if (theDate == null) {
			return venueList;
		}
		System.out.println("Given Date" + theDate);
		List<Venue> dateFilteredList = new ArrayList<Venue>();
		for (Venue venue : venueList) {
			System.out.println("\n Venue : " + venue);
			List<String> bookingIdList = venue.getBookingId();
			if (null != bookingIdList && !bookingIdList.isEmpty()) {
				boolean flag = false;
				for (String bookingId : venue.getBookingId()) {
					Optional<VenueBooking> result = venueBookingRepo.findById(bookingId);
					if (result.isPresent()) {
						VenueBooking venueBook = (VenueBooking) result.get();
						System.out.println("\n ==>" + venueBook.getDate());
						System.out.println("\n booking Id" + bookingId);
						if (theDate.compareTo(venueBook.getDate()) == 0) {
							System.out.println("matched Date" + venueBook.getDate());
							flag = false;
						} else {
							flag = true;
						}
					}
				}
				if (flag) {
					dateFilteredList.add(venue);
				}
			} else {
				dateFilteredList.add(venue);
			}
		}
		return dateFilteredList;
	}

	private List<Venue> getFilterByLocation(List<Venue> venueList, LocationType location) {
		List<Venue> locationFilteredList = new ArrayList<Venue>();
		if (location != null) {
			for (Venue venue : venueList) {
				if (venue.getAddress().getDistrict().equalsIgnoreCase(location.toString())) {
					locationFilteredList.add(venue);
				}
			}
		} else {
			locationFilteredList = venueList;
		}
		return locationFilteredList;
	}

	private List<Venue> getFilterByEventType(List<Venue> venueList, EventType eventType) {
		List<Venue> eventTypeFilteredList = new ArrayList<Venue>();
		if (eventType != null) {
			for (Venue venue : venueList) {
				if (venue.getEventType().contains(eventType)) {
					eventTypeFilteredList.add(venue);
				}
			}
		} else {
			eventTypeFilteredList = venueList;
		}
		return eventTypeFilteredList;
	}

}
