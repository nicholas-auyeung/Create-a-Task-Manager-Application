package com.phase3end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.phase3end.entity.User;
import com.phase3end.service.UserService;


@RestController
public class UserRESTController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public RedirectView addUser(User usr) {
		userService.addUser(usr);
		return new RedirectView("/dashboard");
	}
	
	//login
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String getUser(S)
	
}
