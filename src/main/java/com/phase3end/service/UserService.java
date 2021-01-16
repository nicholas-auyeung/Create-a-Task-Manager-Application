package com.phase3end.service;

import org.springframework.stereotype.Service;

import com.phase3end.entity.User;

public interface UserService {
	
	public void addUser(User usr);
	public void getUser(long uId);

}
