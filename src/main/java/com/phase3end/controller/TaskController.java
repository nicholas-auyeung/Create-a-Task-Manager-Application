package com.phase3end.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.phase3end.entity.Task;
import com.phase3end.entity.User;

@Controller
public class TaskController {
	
	/*
	 * @RequestMapping(value = "/addtask/{uId}", method = RequestMethod.GET) public
	 * ModelAndView addTask() { Task task = new Task(); return new
	 * ModelAndView("createtask", "form", task); }
	 */
	/*
	@RequestMapping(value = "/addtask", method = RequestMethod.POST)
	public RedirectView redirectTask() {
		return new RedirectView("/dashboard");
	}*/

}
