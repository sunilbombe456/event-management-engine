package com.webwork.event.management.converter;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Converter<T, C> {

	private final Function<T, C> fromDto;

	private final Function<C, T> fromEntity;
		

	/**
	 * @param fromDto    Function that converts given dto entity into the domain
	 *                   entity.
	 * @param fromEntity Function that converts given domain entity into the dto
	 *                   entity.
	 */
	public Converter(final Function<T, C> fromDto, final Function<C, T> fromEntity) {
		this.fromDto = fromDto;
		this.fromEntity = fromEntity;
	}
	
	

	/**
	 * @param customerDto DTO entity
	 * @return The domain representation - the result of the converting function
	 *         application on dto entity.
	 */

	public final C convertFromDto(final T customerDto) {
		return fromDto.apply(customerDto);
	}

	/**
	 * @param customer domain entity
	 * @return The DTO representation - the result of the converting function
	 *         application on domain entity.
	 */

	public final T convertFromEntity(final C customer) {
		return fromEntity.apply(customer);
	}

	/**
	 * @param dtoCustomers collection of DTO entities
	 * @return List of domain representation of provided entities retrieved by
	 *         mapping each of them with the conversion function
	 */
	public final List<C> createfromDtos(final Collection<T> dtoCustomers) {
		return dtoCustomers.stream().map(this::convertFromDto).collect(Collectors.toList());
	}

	/**
	 * @param customers collection of domain entities
	 * @return List of domain representation of provided entities retrieved by
	 *         mapping each of them with the conversion function
	 */

	public final List<T> createFromEntities(final Collection<C> customers) {
		return customers.stream().map(this::convertFromEntity).collect(Collectors.toList());
	}

}
