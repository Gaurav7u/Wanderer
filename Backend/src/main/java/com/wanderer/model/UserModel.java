package com.wanderer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class UserModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String mobile;
	@Column(nullable = false)  
	private String password;
	@javax.persistence.Transient
	private String confirmPassword;
	@Column(nullable = false) 
	private String role;
	
	public UserModel() {
		super();
	}
	public UserModel(int userId, String email, String name, String mobile, String password,
			String confirmPassword, String role) {
		super();
		this.userId = userId;
		this.email = email;
		this.name = name;
		this.mobile = mobile;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name =name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
