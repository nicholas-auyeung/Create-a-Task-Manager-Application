package com.phase3end.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.phase3end.entity.User;
import com.phase3end.service.UserService;


@RestController
public class UserRESTController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public RedirectView addUser(User usr, HttpSession session) {
			session.setAttribute("userExists", true);
			userService.addUser(usr);
			return new RedirectView("/dashboard/" + usr.getUId());
	}
	
}
