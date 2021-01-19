package com.phase3end.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
		}catch(DataAccessException e) {
			
		}
		
	}

	@Override
	public void deleteUserTask(long taskId) {
		try {
			userTaskDAO.deleteUserTask(taskId);
		}catch(DataAccessException e) {
			
		}
		
	}

	@Override
	public List<UserTask> getAllUserTask() {

		return userTaskDAO.getAllUserTask();
		
	}

	@Override
	public UserTask getUserTask(long taskId) {
		try {
			return userTaskDAO.getUserTask(taskId);
		}catch(DataAccessException e) {
			
		}
		return null;
	}
	
	
	
}
