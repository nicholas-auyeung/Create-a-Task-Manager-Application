package com.phase3end.service;

import com.phase3end.entity.Task;

public interface TaskService {
	
	public void addTask(Task task);
	public void deleteTask(long taskId);
	public void updateTask(Task task);
	public Task getTask(long taskId);

}
