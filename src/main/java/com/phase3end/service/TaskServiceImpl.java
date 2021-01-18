package com.phase3end.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3end.dao.TaskDAO;
import com.phase3end.entity.Task;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	TaskDAO taskDAO;

	@Override
	public void addTask(Task task) {
		try {
			taskDAO.addTask(task);
		}catch(Exception e) {
			
		}
		
	}

	@Override
	public void deleteTask(long taskId) {
		try {
			taskDAO.deleteTask(taskId);
		}catch(Exception e) {
			
		}
		
	}

	@Override
	public void updateTask(Task task) {
		try {
			taskDAO.updateTask(task);
		}catch(Exception e) {
			
		}
		
	}

	@Override
	public Task getTask(long taskId) {
		try {
			return taskDAO.getTask(taskId);
		}catch(Exception e) {
			
		}
		return null;
	}
	
	
	

}
