package com.webwork.event.management.converter;

import com.webwork.event.management.dto.VenueDTO;
import com.webwork.event.management.entity.Venue;

public class VenueConverter extends Converter<VenueDTO, Venue> {
	public VenueConverter() {
		super(VenueConverter::convertToEntity, VenueConverter::convertToDto);
	}

	private static VenueDTO convertToDto(Venue venue) {
		return new VenueDTO(venue.getId(), venue.getName(), venue.getAddress(), venue.getImagesFile(), venue.getrId(),
				venue.getEventType(), venue.getPeopleCapacity(), venue.getRent(), venue.getBookingId());
	}

	private static Venue convertToEntity(VenueDTO venueDto) {
		return new Venue(venueDto.getId(), venueDto.getName(), venueDto.getAddress(), venueDto.getImagesFile(),
				venueDto.getrId(), venueDto.getEventType(), venueDto.getPeopleCapacity(), venueDto.getRent(),venueDto.getBookingId());
	}

}
