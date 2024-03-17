package com.example.assignment.service;

import com.example.assignment.model.UserDtls;

public interface UserService {
public UserDtls createUser(UserDtls user);
public boolean checkName(String fullName);
}
