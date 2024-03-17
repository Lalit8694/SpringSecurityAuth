package com.example.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.assignment.model.UserDtls;
import com.example.assignment.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	
	@Override
	public UserDtls createUser(UserDtls user) {
		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setRole("ROLE_USER");

		return userRepo.save(user);
	}
	

	@Override
	public boolean checkName(String fullName) {
		// TODO Auto-generated method stub
		return userRepo.existsByFullName(fullName);
	}


	
	

}
