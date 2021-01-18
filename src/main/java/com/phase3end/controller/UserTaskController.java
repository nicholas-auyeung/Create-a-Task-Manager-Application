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
import com.phase3end.entity.UserTask;
import com.phase3end.service.TaskService;
import com.phase3end.service.UserTaskService;

@Controller
public class UserTaskController {
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	UserTaskService userTaskService;
	
	private long sessionId = 0;
	
	@RequestMapping(value = "/addtask/{sessionId}", method = RequestMethod.GET)
	public ModelAndView addTaskView(@PathVariable("sessionId") long sessionId, ModelMap map) {
		this.sessionId = sessionId;
		map.addAttribute("sessionId", sessionId);
		Task task = new Task();
		return new ModelAndView("createtask", "form", task);
	}
	
	@RequestMapping(value = "/addtask/{sessionId}", method = RequestMethod.POST)
	public RedirectView addTask(Task task) {
		taskService.addTask(task);
		userTaskService.addUserTask(new UserTask(task.getTaskId(), sessionId));
		return new RedirectView("/dashboard/" + sessionId);
	}
	
	@RequestMapping(value = "/deletetask/{sessionId}", method = RequestMethod.GET)
	public ModelAndView  deleteTaskView(@PathVariable("sessionId") long sessionId, ModelMap map) {
		this.sessionId = sessionId;
		map.addAttribute("sessionId", sessionId);
		List<Task> taskList = new ArrayList<>();
		userTaskService.getAllUserTask().stream().filter(userTask -> userTask.getUId() == sessionId)
						.forEach(userTask ->{
							taskList.add(taskService.getTask(userTask.getTaskId()));
						});
		
		return new ModelAndView("deletetask", "taskList", taskList);
		
	}
	
	@RequestMapping(value = "/deletetask/{sessionId}", method = RequestMethod.POST)
	public RedirectView deleteTask(@RequestParam("deleteId") long deleteId) {
		taskService.deleteTask(deleteId);
		userTaskService.deleteUserTask(deleteId);
		return new RedirectView("/dashboard/" + sessionId);
	}
	
	@RequestMapping(value = "/updatetask/{sessionId}", method = RequestMethod.GET)
	public ModelAndView updateTaskPage(@PathVariable("sessionId") long sessionId, ModelMap map) {
		this.sessionId = sessionId;
		map.addAttribute("sessionId", sessionId);
		List<Task> taskList = new ArrayList<>();
		userTaskService.getAllUserTask().stream().filter(userTask -> userTask.getUId() == sessionId)
						.forEach(userTask ->{
							taskList.add(taskService.getTask(userTask.getTaskId()));
						});
		
		return new ModelAndView("updatetask", "taskList", taskList);
	}
	
	@RequestMapping(value = "/updatetask/{sessionId}", method = RequestMethod.POST)
	public RedirectView updateTasktoForm(@RequestParam("updateId") long updateId) {
		return new RedirectView("/updatetaskform/" + updateId);
	}
	
	@RequestMapping(value = "/updatetaskform/{updateId}", method = RequestMethod.GET)
	public ModelAndView updateTaskFormPage(@PathVariable("updateId") long updateId) {
		Task task = taskService.getTask(updateId);
		return new ModelAndView("updatetaskform", "task", task);
	}
	
	@RequestMapping(value = "/updatetaskform/{updateId}", method = RequestMethod.POST)
	public RedirectView updateTaskForm(Task task) {
		taskService.updateTask(task);
		return new RedirectView("/dashboard/" + sessionId);
	}
	
	
}
