package com.phase3end.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phase3end.entity.User;

public interface UserService {
	
	public void addUser(User usr);
	public User getUser(long uId);
	public List<User> getAllUsers();

}
