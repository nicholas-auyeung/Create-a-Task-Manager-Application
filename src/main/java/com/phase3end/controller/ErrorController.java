package com.phase3end.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
	
	@RequestMapping(value ="/errors", method = RequestMethod.GET)
	public ModelAndView errors() {
		return new ModelAndView("errors");
	}
}
