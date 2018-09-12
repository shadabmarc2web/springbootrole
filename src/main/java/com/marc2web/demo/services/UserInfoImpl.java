package com.marc2web.demo.services;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marc2web.demo.dao.UserInfoDao;
import com.marc2web.demo.model.Role;
import com.marc2web.demo.model.UserInfo;
import com.marc2web.demo.repository.RoleRepository;
import com.marc2web.demo.repository.UserRepository;
@Service
@Qualifier("UserInfoDao")
public class UserInfoImpl implements UserInfoDao {
	
	@Autowired
	private UserRepository userRepository;
	
	  
	
	   @Bean
		public BCryptPasswordEncoder bCryptPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
	public UserInfo getActiveUser(String username) {
		
		return userRepository.getUserByUsername(username);
	}

	@Override
	public void saveUser(UserInfo user) {
		
		user.setPassword(bCryptPasswordEncoder().encode(user.getPassword()));
		user.setRole_id(2);
		user.setActive(1);	
		userRepository.save(user);

		
	}
	
	
} 


