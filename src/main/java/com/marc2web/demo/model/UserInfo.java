package com.marc2web.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Entity(name="users")
public class UserInfo   {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	
	
	private String username;
	
	
	@Email//email validation constraints
	private String email;
	


	private String password;
	
	@Transient
	private String passwordConfirm;
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	private int active;
	
	
		
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

private Integer role_id;



public Integer getRole_id() {
	return role_id;
}

public void setRole_id(Integer role_id) {
	this.role_id = role_id;
}



public UserInfo()
{}




}
	
	
	

	
	
	
	


