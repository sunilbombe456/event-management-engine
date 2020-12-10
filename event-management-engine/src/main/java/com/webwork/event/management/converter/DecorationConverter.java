package com.webwork.event.management.converter;

import com.webwork.event.management.dto.DecorationDTO;
import com.webwork.event.management.entity.Decoration;

public class DecorationConverter extends Converter<DecorationDTO, Decoration> {

	public DecorationConverter() {
		super(DecorationConverter::convertToEntity, DecorationConverter::convertToDto);
		// TODO Auto-generated constructor stub
	}

	private static DecorationDTO convertToDto(Decoration decoration) {
		return new DecorationDTO(decoration.getId(), decoration.getName(), decoration.getDescription(),
				decoration.getDecorationSize(), decoration.getPrice(), decoration.getEventType(),
				decoration.getImagesFile(), decoration.getrId());
	}



	private static Decoration convertToEntity(DecorationDTO decorationDto) {
		return new Decoration(decorationDto.getId(), decorationDto.getName(), decorationDto.getDescription(),
				decorationDto.getDecorationSize(), decorationDto.getPrice(), decorationDto.getEventType(),
				decorationDto.getImagesFile(), decorationDto.getrId());
	}
}
