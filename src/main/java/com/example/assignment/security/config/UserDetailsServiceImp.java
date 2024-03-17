package com.example.assignment.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.assignment.model.UserDtls;
import com.example.assignment.repository.UserRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;
    
	//checking user name is correct or not	
	@Override
	public UserDetails loadUserByUsername(String fullName) throws UsernameNotFoundException {
		UserDtls user= userRepo.findByFullName(fullName);
		if(user != null) {
			return new CustomUserDetails(user);
			
		}

		throw new UsernameNotFoundException("user not available");
		
	}

}
