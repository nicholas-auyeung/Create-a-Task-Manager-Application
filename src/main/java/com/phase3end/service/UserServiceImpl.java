package com.phase3end.service;

import org.springframework.beans.factory.annotation.Autowired;
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
		}catch(Exception e) {
			throw e;
		}
		
	}

	@Override
	public void getUser(long uId) {
		try {
			userDao.getUser(uId);
		}catch(Exception e) {
			throw e;
		}
		
	}
	
}
