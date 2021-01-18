package com.phase3end.dao;

import java.util.List;

import com.phase3end.entity.UserTask;

public interface UserTaskDAO {
	
	public void addUserTask(UserTask userTask);
	public void deleteUserTask(long taskId);
	public List<UserTask> getAllUserTask();
	public UserTask getUserTask(long taskId);
	

}
