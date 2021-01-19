package com.phase3end.dao;


import com.phase3end.entity.Task;

public interface TaskDAO {
	
	public void addTask(Task task);
	public void deleteTask(long taskId);
	public void updateTask(Task task);
	public Task getTask(long taskId);

}
