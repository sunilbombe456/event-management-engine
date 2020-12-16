package com.webwork.event.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webwork.event.management.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

	Event save(Event event);


}
