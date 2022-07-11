package com.harsh.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.harsh.flightreservation.dto.ReservationUpdateRequest;
import com.harsh.flightreservation.entities.Reservation;
import com.harsh.flightreservation.repos.ReservationRepository;

public class ReservationRestController {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id")Long id) {
		
		return reservationRepository.findById(id).get();
	}

	@RequestMapping("/reservations")
	public Reservation updateReservationRequest(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation= reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNoOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		return reservationRepository.save(reservation);
	}
}
