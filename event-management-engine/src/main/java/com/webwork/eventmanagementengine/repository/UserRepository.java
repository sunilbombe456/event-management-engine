package com.webwork.eventmanagementengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webwork.eventmanagementengine.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
