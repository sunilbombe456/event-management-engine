package com.webwork.event.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webwork.event.management.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
