package com.phase3end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.phase3end.entity.Task;
import com.phase3end.service.TaskService;

@RestController
public class TaskRESTController {
	
	/*
	 * @Autowired TaskService taskService;
	 * 
	 * @RequestMapping(value = "/addtask/{sessionId}", method = RequestMethod.POST)
	 * public RedirectView addTask(@PathVariable("sessionId") String sessionId ,
	 * Task task) { System.out.println(sessionId); taskService.addTask(task); return
	 * new RedirectView("/dashboard/1"); }
	 */
	
}
