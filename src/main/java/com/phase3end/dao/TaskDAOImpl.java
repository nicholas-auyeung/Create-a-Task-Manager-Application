package com.phase3end.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.phase3end.entity.Task;
import com.phase3end.repository.TaskRepository;

@Service
public class TaskDAOImpl implements TaskDAO{
	
	@Autowired
	TaskRepository taskRepository;

	@Override
	public void addTask(Task task) {
		try {
			taskRepository.save(task);
		}catch(DataAccessException e) {
			throw e;
		}
		
	}

	@Override
	public void deleteTask(long taskId) {
		try {
			taskRepository.deleteById(taskId);
		}catch(DataAccessException e) {
			throw e;
		}
		
	}

	@Override
	public void updateTask(Task task) {
		try {
			taskRepository.save(task);
		}catch(DataAccessException e) {
			throw(e);
		}
	}

	@Override
	public Task getTask(long taskId) {
		try {
			return taskRepository.findById(taskId).get();
		}catch(DataAccessException e) {
			throw e;
		}
	}
}
