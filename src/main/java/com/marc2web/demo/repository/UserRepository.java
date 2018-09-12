package com.marc2web.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marc2web.demo.model.UserInfo;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, Integer>{
	public UserInfo getUserByUsername(String username);
}
