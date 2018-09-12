package com.marc2web.demo.dao;

import com.marc2web.demo.model.UserInfo;

public interface UserInfoDao {
	public UserInfo getActiveUser(String username);
	
	 public void saveUser(UserInfo user);
	
} 
