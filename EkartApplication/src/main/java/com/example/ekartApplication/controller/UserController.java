package com.example.ekartApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ekartApplication.DTO.LoginRequest;
import com.example.ekartApplication.DTO.RegisterRequest;
import com.example.ekartApplication.entity.User;
import com.example.ekartApplication.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	public UserService userService;

	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
		User register = userService.register(request);
		return new ResponseEntity<>(register, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody LoginRequest request){
		User login = userService.login(request);
		return new ResponseEntity<>(login, HttpStatus.CREATED);
	}
}
