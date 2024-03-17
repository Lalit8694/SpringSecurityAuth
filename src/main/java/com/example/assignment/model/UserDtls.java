package com.example.assignment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString; 


@Data
@Entity
public class UserDtls {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;
 private String fullName;
 private String password;
 private String role;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
 
 
 
 


 
 
}
