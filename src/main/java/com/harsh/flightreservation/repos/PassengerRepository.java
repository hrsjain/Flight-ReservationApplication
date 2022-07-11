package com.harsh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harsh.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
