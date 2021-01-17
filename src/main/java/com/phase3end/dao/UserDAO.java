package com.phase3end.dao;

import java.util.List;

import com.phase3end.entity.User;

public interface UserDAO{
	
	public void addUser(User usr);
	public User getUser(long uId);
	public List<User> getAllUsers();
		
}
