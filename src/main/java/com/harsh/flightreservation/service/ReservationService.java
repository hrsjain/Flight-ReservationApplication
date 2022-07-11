package com.harsh.flightreservation.service;

import com.harsh.flightreservation.dto.ReservationRequest;
import com.harsh.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}

