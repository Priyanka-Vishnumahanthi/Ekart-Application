package com.example.ekartApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ekartApplication.DTO.LoginRequest;
import com.example.ekartApplication.DTO.RegisterRequest;
import com.example.ekartApplication.entity.User;
import com.example.ekartApplication.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

//	public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
//		this.userRepository = userRepository;
//		this.passwordEncoder = passwordEncoder;
//	}
	
	public User register(RegisterRequest request) {
		if(userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new RuntimeException ("Email already in use");
		}
		
		User user = new User();
		  user.setName(request.getName());
		  user.setEmail(request.getEmail());
		  user.setPassword(passwordEncoder.encode(request.getPassword()));
		  user.setRole(request.getRole());
		
		  return userRepository.save(user);
	}
	
	public User login(LoginRequest request) {
		User user = userRepository.findByEmail(request.getEmail()).orElseThrow(()->new RuntimeException("Invalid Email or Password"));
		
		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			throw new RuntimeException("Invalis Email or Password");
		}
		return user;  //In real apps, return a token instead
	}

}
