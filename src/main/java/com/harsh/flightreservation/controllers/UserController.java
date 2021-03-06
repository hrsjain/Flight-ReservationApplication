package com.harsh.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.harsh.flightreservation.entities.User;
import com.harsh.flightreservation.repos.UserRepository;
import com.harsh.flightreservation.service.SecurityService;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "login/registerUser";
	}
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";
	}
	
	@RequestMapping("/showlogin")
	public String showLoginPage() {
		return "login/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("email")String email,@RequestParam("password")String password,ModelMap modelmap) {
	 	
		boolean loginResponse= securityService.login(email,password);
		if(loginResponse)
			return "findFlights";
		else {
			modelmap.addAttribute("msg","Invalid username and password. Please try again...");
		}
		return "login/login";
	}
	
	
}
