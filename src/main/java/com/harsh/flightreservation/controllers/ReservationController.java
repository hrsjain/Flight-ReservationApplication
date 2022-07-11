package com.harsh.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harsh.flightreservation.dto.ReservationRequest;
import com.harsh.flightreservation.entities.Flight;
import com.harsh.flightreservation.entities.Reservation;
import com.harsh.flightreservation.repos.FlightRepository;
import com.harsh.flightreservation.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository  flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap modelMap) {
		Flight flight= flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight",flight);
		return "completeReservation";	
	}
	
	@RequestMapping("/completeReservation")
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		
		Reservation reservation=reservationService.bookFlight(request);
		modelMap.addAttribute("msg","Reservation Done Successfully and the Id is"+reservation.getId());
		return "reservationConfirmation";  
	}
	

}
