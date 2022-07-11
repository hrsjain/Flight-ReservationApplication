package com.harsh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harsh.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
