package com.phase3end.dao;

import org.springframework.stereotype.Service;

import com.phase3end.entity.User;

public interface UserDAO{
	
	public void addUser(User usr);
	public void getUser(long uId);
		
}
