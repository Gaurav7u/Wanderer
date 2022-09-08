package com.wanderer.service;

import java.util.List;
import com.wanderer.model.UserModel;

public interface UserService {
	
	public String create(UserModel user);
	
	public List<UserModel> readAllUsers();

	public UserModel readUserById(int userId);

}
