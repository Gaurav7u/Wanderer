package com.wanderer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wanderer.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
	UserModel findByEmailAndPassword(String email, String password);
	UserModel findByEmail(String email);
	UserModel findByMobile(String mobile);

}
