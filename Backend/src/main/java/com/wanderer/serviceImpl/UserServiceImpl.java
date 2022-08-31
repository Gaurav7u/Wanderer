package com.wanderer.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanderer.exception.NotFoundException;
import com.wanderer.model.UserModel;
import com.wanderer.repository.UserRepository;
import com.wanderer.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	@Override
	public String create(UserModel user) {
		userRepo.save(user);
		return "User Created";
	}

	@Override
	public List<UserModel> readAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public UserModel readUserById(int userId) {
		return userRepo.findById(userId).orElseThrow(()->new NotFoundException("user not found"));
	}
	
	public UserModel findByEmail(String email)
	{
		return userRepo.findByEmail(email);
	}
	public boolean findByEmailBool(String email)
	{
		UserModel user=userRepo.findByEmail(email);
		return (user!=null);
	}
	public boolean findByMobile(String mobile) {
		UserModel user=userRepo.findByMobile(mobile);
		return (user!=null);
	}
	public boolean findByEmailAndPassword(String email,String password) {
		UserModel user=userRepo.findByEmailAndPassword(email, password);
		return (user!=null);
	}

}
