package com.webwork.event.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webwork.event.management.entity.States;

public interface StatesRepository extends JpaRepository<States, Integer> {
	
}
