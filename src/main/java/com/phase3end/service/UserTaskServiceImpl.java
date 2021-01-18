package com.phase3end.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3end.dao.UserTaskDAO;
import com.phase3end.entity.UserTask;

@Service
public class UserTaskServiceImpl implements UserTaskService{

	@Autowired
	UserTaskDAO userTaskDAO;
	
	@Override
	public void addUserTask(UserTask userTask) {
		try {
			userTaskDAO.addUserTask(userTask);
		}catch(Exception e) {
			
		}
		
	}

	@Override
	public void deleteUserTask(long taskId) {
		try {
			userTaskDAO.deleteUserTask(taskId);
		}catch(Exception e) {
			
		}
		
	}

	@Override
	public List<UserTask> getAllUserTask() {
		try {
			return userTaskDAO.getAllUserTask();
		}catch(Exception e) {
			
		}
		return null;
	}
	
	
	
}
