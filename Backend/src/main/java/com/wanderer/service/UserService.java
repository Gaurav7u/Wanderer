package com.wanderer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wanderer.model.UserModel;

@Service
public interface UserService {
	
	public String create(UserModel user);
	
	public List<UserModel> readAllUsers();

	public UserModel readUserById(int userId);

}
