package com.phase3end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phase3end.entity.UserTask;
import com.phase3end.service.UserTaskService;

@RestController
public class UserTaskRESTController {
	
	/*
	@Autowired
	UserTaskService userTaskService;
	
	@RequestMapping(value = "/addtask/{sessionId}", method = RequestMethod.POST)
	public void addUserTask(UserTask userTask) {
		userTaskService.addUserTask(userTask);
	}*/
}
