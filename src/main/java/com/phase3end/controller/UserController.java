package com.phase3end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.phase3end.entity.User;
import com.phase3end.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	boolean userExists = false;
	long sessionUid = 0;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView userRegistration() {
		User usr = new User();
		return new ModelAndView("registration", "form", usr);
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView userLoginPage() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public RedirectView userLogin(@RequestParam("username") String userName, @RequestParam("password") String password) {
		
		userService.getAllUsers().stream().filter(user -> user.getUserName().equals(userName) && user.getPassword().equals(password)).findAny()
				.ifPresent(user -> {
					userExists = true;
					sessionUid = user.getUId();
				});
		if(userExists) {
			userExists = false;
			return new RedirectView("/dashboard/" + sessionUid);
		}
		return new RedirectView("/login");
	}

	@RequestMapping(value = "/dashboard/{uId}", method = RequestMethod.GET)
	public ModelAndView userTaskDashboard() {
		
		return new ModelAndView("taskdashboard");
	}
	
}
