package com.marc2web.demo.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marc2web.demo.model.Role;
import com.marc2web.demo.model.User;
import com.marc2web.demo.repository.RoleRepository;
import com.marc2web.demo.repository.UserRepository;
@Configuration
@Service("userService")
public class UserServiceImpl {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	/*
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;*/
	
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
/*	public void saveUsera(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role  (Arrays.asList(userRole)));
		userRepository.save(user);
	}*/
	
	public void saveUser(User user)
	{
		
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setActive(1);
		Role userRole=roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

}
