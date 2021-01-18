package com.phase3end.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import net.bytebuddy.asm.Advice.This;

@Controller
public class UserTaskController {
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	UserTaskService userTaskService;
	
	private long sessionId = 0;
	
	@RequestMapping(value = "/addtask/{sessionId}", method = RequestMethod.GET)
	public ModelAndView addTaskView(@PathVariable("sessionId") long sessionId, ModelMap map, HttpSession session) {
		if((boolean) session.getAttribute("userExists") && sessionId == (long)session.getAttribute("currentSessionId")) {
			this.sessionId = sessionId;
			map.addAttribute("sessionId", sessionId);
			Task task = new Task();
			return new ModelAndView("createtask", "form", task);
		}
		return new ModelAndView("errors");
	}
	
	@RequestMapping(value = "/addtask/{sessionId}", method = RequestMethod.POST)
	public RedirectView addTask(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Task task) {
		task.setStartDate(startDate);
		task.setEndDate(endDate);
		taskService.addTask(task);
		userTaskService.addUserTask(new UserTask(task.getTaskId(), sessionId));
		return new RedirectView("/dashboard/" + sessionId);
	}
	
	@RequestMapping(value = "/deletetask/{sessionId}", method = RequestMethod.GET)
	public ModelAndView  deleteTaskView(@PathVariable("sessionId") long sessionId, ModelMap map, HttpSession session) {
		if((boolean) session.getAttribute("userExists") && sessionId == (long)session.getAttribute("currentSessionId")) {
			this.sessionId = sessionId;
			map.addAttribute("sessionId", sessionId);
			List<Task> taskList = new ArrayList<>();
			userTaskService.getAllUserTask().stream().filter(userTask -> userTask.getUId() == sessionId)
							.forEach(userTask ->{
								taskList.add(taskService.getTask(userTask.getTaskId()));
							});
			
			return new ModelAndView("deletetask", "taskList", taskList);
		}
		return new ModelAndView("errors");
	}
	
	@RequestMapping(value = "/deletetask/{sessionId}", method = RequestMethod.POST)
	public RedirectView deleteTask(@RequestParam("deleteId") long deleteId) {
		if(taskService.getTask(deleteId) != null && userTaskService.getUserTask(taskService.getTask(deleteId).getTaskId()).getUId() == sessionId) {
			taskService.deleteTask(deleteId);
			userTaskService.deleteUserTask(deleteId);
			return new RedirectView("/dashboard/" + sessionId);
		}
		return new RedirectView("/deletetask/" + sessionId);
	}
	
	@RequestMapping(value = "/updatetask/{sessionId}", method = RequestMethod.GET)
	public ModelAndView updateTaskPage(@PathVariable("sessionId") long sessionId, ModelMap map, HttpSession session) {
		if((boolean) session.getAttribute("userExists") && sessionId == (long)session.getAttribute("currentSessionId")) {
			this.sessionId = sessionId;
			map.addAttribute("sessionId", sessionId);
			List<Task> taskList = new ArrayList<>();
			userTaskService.getAllUserTask().stream().filter(userTask -> userTask.getUId() == sessionId)
							.forEach(userTask ->{
								taskList.add(taskService.getTask(userTask.getTaskId()));
							});
			
			return new ModelAndView("updatetask", "taskList", taskList);
		}
		return new ModelAndView("errors");
	}
	
	@RequestMapping(value = "/updatetask/{sessionId}", method = RequestMethod.POST)
	public RedirectView updateTasktoForm(@RequestParam("updateId") long updateId) {
		if(taskService.getTask(updateId) != null && userTaskService.getUserTask(taskService.getTask(updateId).getTaskId()).getUId() == sessionId) {
			return new RedirectView("/updatetaskform/" + updateId);
		}
		return new RedirectView("/updatetask/" + sessionId);
	}
	
	@RequestMapping(value = "/updatetaskform/{updateId}", method = RequestMethod.GET)
	public ModelAndView updateTaskFormPage(@PathVariable("updateId") long updateId, HttpSession session) {
		
		if((boolean) session.getAttribute("userExists") && userTaskService.getUserTask(updateId).getUId() == (long)session.getAttribute("currentSessionId")) {
			Task task = taskService.getTask(updateId);
			return new ModelAndView("updatetaskform", "task", task);
		}
		return new ModelAndView("errors");
	}
	
	@RequestMapping(value = "/updatetaskform/{updateId}", method = RequestMethod.POST)
	public RedirectView updateTaskForm(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Task task) {
		task.setStartDate(startDate);
		task.setEndDate(endDate);
		taskService.updateTask(task);
		return new RedirectView("/dashboard/" + sessionId);
	}
	
	
}
