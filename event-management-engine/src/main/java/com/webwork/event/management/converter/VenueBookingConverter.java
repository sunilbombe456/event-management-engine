package com.webwork.event.management.converter;

import java.text.ParseException;
import java.util.function.Function;

import com.webwork.event.management.dto.VenueBookingDTO;
import com.webwork.event.management.dto.VenueDTO;
import com.webwork.event.management.entity.Venue;
import com.webwork.event.management.entity.VenueBooking;
import com.webwork.event.management.util.DateUtils;

public class VenueBookingConverter extends Converter<VenueBookingDTO, VenueBooking>{

	public VenueBookingConverter() {
		super(arg0 -> {
			try {
				return convertToEntity(arg0);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}, VenueBookingConverter::convertToDto);
		// TODO Auto-generated constructor stub
	}
	

	private static VenueBookingDTO convertToDto(VenueBooking venueBooking) {
		return new VenueBookingDTO(venueBooking.getId(), venueBooking.getVenueId(), venueBooking.getVenueName(), venueBooking.getUserId(),DateUtils.formatDate(venueBooking.getDate()));
	}

	private static VenueBooking convertToEntity(VenueBookingDTO venueBookingDto) throws ParseException {
		return new VenueBooking(venueBookingDto.getId(), venueBookingDto.getVenueId(), venueBookingDto.getVenueName(), venueBookingDto.getUserId(), DateUtils.parseDate(venueBookingDto.getDate()));
	}

}
