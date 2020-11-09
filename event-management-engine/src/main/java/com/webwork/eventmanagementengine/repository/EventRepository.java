package com.webwork.eventmanagementengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webwork.eventmanagementengine.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
