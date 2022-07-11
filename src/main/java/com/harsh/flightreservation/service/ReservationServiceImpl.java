package com.harsh.flightreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harsh.flightreservation.dto.ReservationRequest;
import com.harsh.flightreservation.entities.Flight;
import com.harsh.flightreservation.entities.Passenger;
import com.harsh.flightreservation.entities.Reservation;
import com.harsh.flightreservation.repos.FlightRepository;
import com.harsh.flightreservation.repos.PassengerRepository;
import com.harsh.flightreservation.repos.ReservationRepository;
import com.harsh.flightreservation.util.EmailUtil;
import com.harsh.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Value("{com.harsh.flightreservation.itinerary.dirpath}")
	private String ITINERARY_DIR;

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {

		Long flightId=request.getFlightId();
		Flight flight=flightRepository.findById(flightId).get();
		
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger=passengerRepository.save(passenger);
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		Reservation savedReservation = reservationRepository.save(reservation);
		
		
		
		String filePath = ITINERARY_DIR+savedReservation.getId()+".pdf";
		
		pdfGenerator.generateItinerary(savedReservation,filePath);
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		
		return savedReservation;
		
	}
}

