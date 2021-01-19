package com.phase3end.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.phase3end.entity.User;
import com.phase3end.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void addUser(User usr) {
		try {
			userRepository.save(usr);
		}catch(DataAccessException e) {
			throw e;
		}
		
	}

	@Override
	public User getUser(long uId) {
		try {
			return userRepository.findById(uId).get();
		}catch(DataAccessException e) {
			throw e;
		}
		
	}

	@Override
	public List<User> getAllUsers() {
	
		return (List<User>)userRepository.findAll();

		
	}

	
}
