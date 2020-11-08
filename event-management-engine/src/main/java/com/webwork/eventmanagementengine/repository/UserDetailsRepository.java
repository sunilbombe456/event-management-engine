package com.webwork.eventmanagementengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webwork.eventmanagementengine.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

	boolean existsByEmail(String email);

}
