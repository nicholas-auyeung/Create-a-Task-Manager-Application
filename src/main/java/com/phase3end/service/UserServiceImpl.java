package com.phase3end.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.phase3end.dao.UserDAO;
import com.phase3end.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDao;

	@Override
	public void addUser(User usr) {
		try {
			userDao.addUser(usr);
		}catch(DataAccessException e) {
			throw e;
		}
		
	}

	@Override
	public User getUser(long uId) {
		try {
			return userDao.getUser(uId);
		}catch(DataAccessException e) {
			throw e;
		}
		
	}

	@Override
	public List<User> getAllUsers() {
		
		return userDao.getAllUsers();
		
	}
	
}
