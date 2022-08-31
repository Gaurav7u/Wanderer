package com.wanderer.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class UserDto {

	@NotEmpty(message="email can't be null")
	@NotNull(message="email can't be empty")
	@Email(message = "Please Enter valid email")
	private String email;
	@NotEmpty(message="Name can't be null")
	@NotNull(message="Name can't be empty")
	private String name;
	@NotEmpty(message="Mobile Number can't be null")
	@NotNull(message="Mobile Number can't be empty")
	@Pattern(regexp = "^[6789]\\d{9}$", message = "Mobile number starts with 6,7,8,9")
	@Size(min=10, max=10, message = "please enter 10 digit valid mobile number")
	private String mobile;
	@NotEmpty(message="password can't be null")
	@NotNull(message="password can't be empty")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password must contain one uppercase , one lowercase, one special character,one number")
	private String password;
	@NotEmpty(message="password can't be null")
	@NotNull(message="password can't be empty")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Confirm Password must contain one uppercase , one lowercase, one special character,one number")
	private String confirmPassword;
	
	@NotEmpty(message="role can't be null")
	@NotNull(message="role can't be empty")
	private String role;

	public UserDto(String email,String name,String mobile,String password,String confirmPassword,String role) {
		super();
		this.email = email;
		this.name = name;
		this.mobile = mobile;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.role = role;
	}

	public UserDto() {
		super();
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
		this.name = name;
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
