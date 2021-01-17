package com.phase3end.dao;

import org.springframework.beans.factory.annotation.Autowired;

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
		}catch(Exception e) {
			throw e;
		}
		
	}

	@Override
	public User getUser(long uId) {
		try {
			return userRepository.findById(uId).get();
		}catch(Exception e) {
			throw e;
		}
		
	}

	@Override
	public List<User> getAllUsers() {
		try {
			return (List<User>)userRepository.findAll();
		}catch(Exception e) {
		
		}
		return null;
	}


	
}
