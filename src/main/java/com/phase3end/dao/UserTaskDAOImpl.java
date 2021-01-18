package com.phase3end.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3end.entity.UserTask;
import com.phase3end.repository.UserTaskRepository;

@Service
public class UserTaskDAOImpl implements UserTaskDAO{
	
	@Autowired
	UserTaskRepository userTaskRepository;

	@Override
	public void addUserTask(UserTask userTask) {
		
		try {
			userTaskRepository.save(userTask);
		}catch(Exception e) {
			
		}
		
	}

	@Override
	public void deleteUserTask(long taskId) {
		try {
			userTaskRepository.deleteById(taskId);
		}catch(Exception e) {
			
		}
		
	}

	@Override
	public List<UserTask> getAllUserTask() {
		try {
			return (List<UserTask>)userTaskRepository.findAll();
		}catch(Exception e) {
			
		}
		return null;
	}

	@Override
	public UserTask getUserTask(long taskId) {
		try {
			return userTaskRepository.findById(taskId).get();
		}catch(Exception e) {
			
		}
		return null;
	}

}
