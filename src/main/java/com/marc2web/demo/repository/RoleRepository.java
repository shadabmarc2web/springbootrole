package com.marc2web.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marc2web.demo.model.Role;
import com.marc2web.demo.model.UserInfo;
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{
	
	//public Role getRoleByrole(String role);
	public Role findByRoleid(Integer id);
}
