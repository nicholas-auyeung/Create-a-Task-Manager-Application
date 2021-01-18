package com.phase3end.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
	
	private boolean userExists = false;
	
	private User currentSessionUser = new User();
	
	private long regisCounter = 0;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView userRegistration(HttpSession session) {
		User usr = new User();
		return new ModelAndView("registration", "form", usr);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public RedirectView addUser(User usr, HttpSession session) {
			session.setAttribute("userExists", true);
			userService.addUser(usr);
			regisCounter++;
			session.setAttribute("currentSessionId", regisCounter);
			currentSessionUser = usr;
			return new RedirectView("/dashboard/" + usr.getUId());
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView userLoginPage() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public RedirectView userLogin(@RequestParam("username") String userName, @RequestParam("password") String password, HttpSession session) {
		
		userService.getAllUsers().stream().filter(user -> user.getUserName().equals(userName) && user.getPassword().equals(password)).findAny()
				.ifPresent(user -> {
					userExists = true;
					currentSessionUser = user;
				});
		if(userExists) {
			session.setAttribute("userExists", true);
			session.setAttribute("currentSessionId", currentSessionUser.getUId());
			return new RedirectView("/dashboard/" + currentSessionUser.getUId());
		}
		return new RedirectView("/login");
	}

	@RequestMapping(value = "/dashboard/{sessionId}", method = RequestMethod.GET)
	public ModelAndView userTaskDashboard(@PathVariable("sessionId") long sessionId, ModelMap map, HttpSession session) {
		if((boolean) session.getAttribute("userExists") && (Long)session.getAttribute("currentSessionId") == currentSessionUser.getUId() && sessionId == currentSessionUser.getUId()) {
			List<Task> taskList = new ArrayList<>();
			userTaskService.getAllUserTask().stream().filter(userTask -> userTask.getUId() == sessionId)
							.forEach(userTask ->{
								taskList.add(taskService.getTask(userTask.getTaskId()));
							});
			map.addAttribute("sessionId", sessionId);
			currentSessionUser = userService.getUser(sessionId);
			
			return new ModelAndView("taskdashboard", "taskList", taskList);
		}
		return new ModelAndView("errors");
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public RedirectView userLogout(HttpSession session) {
		currentSessionUser = null;
		session.removeAttribute("alreadyRegistered");
		session.setAttribute("currentSessionId", 0);
		session.setAttribute("userExists", false);
		return new RedirectView("/login");
	}
	
}
