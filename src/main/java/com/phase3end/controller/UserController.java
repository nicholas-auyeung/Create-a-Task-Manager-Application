package com.phase3end.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.phase3end.entity.User;

@Controller
public class UserController {
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView userRegistration() {
		User usr = new User();
		return new ModelAndView("registration", "form", usr);
	}
	
	
	//dashboard function
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView userTaskDashboard() {
		
		return new ModelAndView("taskdashboard");
	}
	
}
