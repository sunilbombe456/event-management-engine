package com.webwork.event.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webwork.event.management.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String username);

	boolean existsByUserName(String userName);

}
