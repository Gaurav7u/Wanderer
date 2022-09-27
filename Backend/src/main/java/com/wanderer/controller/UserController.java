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
import org.springframework.web.bind.annotation.PathVariable;
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

@CrossOrigin(origins = "http://localhost:3000")
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
	
	@PostMapping("/")
	public ResponseEntity<String> createUser(@Valid @RequestBody UserDto user1) {
		UserModel user3 = new UserModel();
		try {
            if(user1.getPassword().equals(user1.getConfirmPassword())) {
            	user3.setName(user1.getName());
            	user3.setRole(user1.getRole());
            	user3.setMobile(user1.getMobile());
            	user3.setPassword(user1.getPassword());
            	user3.setEmail(user1.getEmail());
            	user3.setConfirmPassword(user1.getConfirmPassword());
            	userService.create(user3);	
            }else {
            	return new ResponseEntity<>( " password doesn't match",
						HttpStatus.EXPECTATION_FAILED);	
            }
            
			return new ResponseEntity<>(user3.getName() + "Registered Successfully", HttpStatus.CREATED);

	 } catch (DataIntegrityViolationException e) {
			
             String errors="";
				if (userService.findByEmailBool(user3.getEmail())) {
					errors=errors+user3.getEmail() + " Already Registered with this email\n";
				}
				if (userService.findByMobile(user3.getMobile())) {
					errors=errors+user3.getMobile() + " Already Registered with this mobilenumber\n";
				}
			
			return new ResponseEntity<>(errors, HttpStatus.CONFLICT);

		}

	}
	@GetMapping("/checkUserEmail/{email}")
	public ResponseEntity<Boolean> checkUserWithEmail(@PathVariable("email") String email)
	{
		return new ResponseEntity(userService.findByEmailBool(email),HttpStatus.OK);
	}
	
	@GetMapping("/checkUserMobile/{mobile}")
	public ResponseEntity<Boolean> checkUserWithMobile(@PathVariable("mobile") String mobile)
	{
		return new ResponseEntity(userService.findByMobile(mobile),HttpStatus.OK);
	}
	

	
	
}

