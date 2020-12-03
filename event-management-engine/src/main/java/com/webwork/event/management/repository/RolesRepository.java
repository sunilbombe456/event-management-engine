package com.webwork.event.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webwork.event.management.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {

	Roles findByName(String string);

}
