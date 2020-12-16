package com.webwork.event.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webwork.event.management.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {


}
