package com.wanderer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wanderer.config.CustomUserDetailsService;
import com.wanderer.config.JwtUtil;
import com.wanderer.dto.AuthRequest;
import com.wanderer.dto.AuthResponse;
import com.wanderer.dto.UserDto;
import com.wanderer.model.UserModel;
import com.wanderer.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired(required = true)
	private UserServiceImpl userService;
	
	@Autowired
	private CustomUserDetailsService userdetailservice;
	
	@Autowired
	private JwtUtil jwtutil;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserModel user;
	


	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) throws BadCredentialsException {
		
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));
		}catch(BadCredentialsException ex) {
			System.out.println("Bad credentials");
		}
		
		UserDetails userdata=this.userdetailservice.loadUserByUsername(authRequest.getUserName());
		return ResponseEntity.ok(new AuthResponse(this.jwtutil.generateToken(userdata.getUsername()),userService.findByEmail(userdata.getUsername()).getRole()));
	}
	
	//this is test controller to test jwt authentication.
	//delete this
	@GetMapping("/test")
	public String test()
	{
		return "Success";
	}
	
	
	
	@PostMapping("/")
	public ResponseEntity<String> createUser(@Valid @RequestBody UserDto user1) {
	
		try {
            if(user1.getPassword().equals(user1.getConfirmPassword())) {
            	user.setName(user1.getName());
            	user.setRole(user1.getRole());
            	user.setMobile(user1.getMobile());
            	user.setPassword(user1.getPassword());
            	user.setEmail(user1.getEmail());
            	userService.create(user);	
            }else {
            	return new ResponseEntity<>( " password doesn't match",
						HttpStatus.EXPECTATION_FAILED);	
            }
            
			return new ResponseEntity<>(user.getName() + "Registered Successfully", HttpStatus.CREATED);

	 } catch (DataIntegrityViolationException e) {
			
             String errors="";
				if (userService.findByEmailBool(user.getEmail())) {
					errors=errors+user.getEmail() + " Already Registered with this email\n";
				}
				if (userService.findByMobile(user.getMobile())) {
					errors=errors+user.getMobile() + " Already Registered with this mobilenumber\n";
				}
			
			return new ResponseEntity<>(errors, HttpStatus.CONFLICT);

		}

	}
	

	
	
}

