package com.marc2web.demo.service;

import org.springframework.stereotype.Service;

import com.marc2web.demo.model.User;
@Service
public interface UserSevice {
	public User findUserByEmail(String email);
	public void saveUser(User user);

}
