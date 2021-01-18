package com.phase3end.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.phase3end.entity.Task;
import com.phase3end.entity.User;
import com.phase3end.entity.UserTask;
import com.phase3end.service.TaskService;
import com.phase3end.service.UserService;
import com.phase3end.service.UserTaskService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserTaskService userTaskService;
	
	@Autowired
	TaskService taskService;
	
	boolean userExists = false;
	User currentSessionUser = new User();
	
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
					currentSessionUser = user;
				});
		if(userExists) {
			userExists = false;
			return new RedirectView("/dashboard/" + currentSessionUser.getUId());
		}
		return new RedirectView("/login");
	}

	@RequestMapping(value = "/dashboard/{sessionId}", method = RequestMethod.GET)
	public ModelAndView userTaskDashboard(@PathVariable("sessionId") long sessionId, ModelMap map) {
		List<Task> taskList = new ArrayList<>();
		userTaskService.getAllUserTask().stream().filter(userTask -> userTask.getUId() == sessionId)
						.forEach(userTask ->{
							taskList.add(taskService.getTask(userTask.getTaskId()));
						});
		map.addAttribute("sessionId", sessionId);
		currentSessionUser = userService.getUser(sessionId);
		
		return new ModelAndView("taskdashboard", "taskList", taskList);
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public RedirectView userLogout() {
		currentSessionUser = null;
		return new RedirectView("/login");
	}
	
}
