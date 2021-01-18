package com.phase3end.service;

import java.util.List;

import com.phase3end.entity.UserTask;

public interface UserTaskService {
	
	public void addUserTask(UserTask userTask);
	public void deleteUserTask(long taskId);
	public List<UserTask> getAllUserTask();
}
