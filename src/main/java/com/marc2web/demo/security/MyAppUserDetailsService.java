package com.marc2web.demo.security;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marc2web.demo.dao.RoleDAO;
import com.marc2web.demo.dao.UserInfoDao;
import com.marc2web.demo.model.Role;
import com.marc2web.demo.model.UserInfo;
import com.marc2web.demo.repository.RoleRepository;
import com.marc2web.demo.services.RoleImpl;

@Service
public class MyAppUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserInfoDao userInfoDAO;
	

	
	@Autowired
	private RoleRepository roleRepository;
	

	


	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {

		UserInfo user = userInfoDAO.getActiveUser(username);
		
		if(user==null) throw new UsernameNotFoundException(username);
		
		final Integer roleid=user.getRole_id();
		
		System.out.println("######################"+roleid+"#############");
		Role role=roleRepository.findByRoleid(roleid);
		
		String authority_role=role.getRole();	
		System.out.println("######################"+authority_role+"#############");
		
		GrantedAuthority authority = new SimpleGrantedAuthority(authority_role);		
		User userds = new User(user.getUsername(),user.getPassword(),Arrays.asList(authority));		
		UserDetails userDetails = (UserDetails)userds; 		
		return userDetails;
	}
} 


