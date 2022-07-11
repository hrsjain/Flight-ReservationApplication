package com.harsh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harsh.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
