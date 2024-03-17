package com.example.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.assignment.model.UserDtls;
import com.example.assignment.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControllerHomePage {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/dataEntry")
	public String dataEntry() {
		return "dataEntry";
	}
	
	@GetMapping("/signin")
	public String verifyUser() {
		return "verifyUser";
	}
	
	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UserDtls user, HttpSession session) {
		
		//System.out.println(user.toString());
		
		boolean f= userService.checkName(user.getFullName());
		if(f) {
			//System.out.println("Name is already exist");
			session.setAttribute("msg", "Name alrready exist");
		}else {
			UserDtls userDtls=userService.createUser(user);
			if(userDtls != null) {
				//System.out.println("Register Successfully");
				session.setAttribute("msg", "Register Successfully");
			}else {
				//System.out.println("server error");
				session.setAttribute("msg", "something went wrong");
			}
		}
		
		
		
		
		return "redirect:/dataEntry";
	}
	

}
